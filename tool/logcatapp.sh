#!/bin/bash

# HELP
helpf() {
    echo "ADB Logcat for each Android Application"
    echo "Author: bluelul.com"
    echo "Version: 1.0"
    echo
    echo "How to use:"
    echo "logcatapp.sh -h : print this help page"
    echo
    echo "logcatapp.sh -s : Scan all running Android apps on device"
    echo
    echo "logcatapp.sh com.android.example : View logcat of com.android.example app"
    echo
    exit 1
}

# COLOR
RED='\033[1;31m'
GREEN='\033[1;32m'
BLUE='\033[1;34m'
YELLOW='\033[1;33m'
PURPLE='\033[1;35m'
NC='\033[0m' # No Color

# FLAG
mode="log"
while getopts hs flag
do
    case "$flag" in
	h) helpf;;
	s) mode="scan";;
    esac
done

# SCAN
scanf() {
    pidzygote64=$(adb shell pidof zygote64)
    if [[ $pidzygote64 =~ ^[0-9]+$ ]]; then
	adb shell ps -elf --ppid $pidzygote64
    fi
}

# LOGCAT
logcatf() {
    while true
    do
	echo "[LOGCATAPP] Wait for device booting up... "
	adb wait-for-device shell "while [[ -z $(getprop sys.boot_completed) ]]; do sleep 0.2; done;"
	echo "[LOGCATAPP] Booting up DONE"

	echo "[LOGCATAPP] Wait for $1 starting... "
	pidapp=$(adb shell pidof -s $1)
        until [[ $pidapp =~ ^[0-9]+$ ]];
	do
	    sleep 0.2
   	    pidapp=$(adb shell pidof -s $1)
	done

	while [[ $(adb shell getprop sys.boot_completed) -eq 1 ]];
	do
	    echo "[LOGCATAPP] $1 (PID $pidapp) has started"
	    adb logcat | grep --line-buffered -F $pidapp &
	    pidlogcat=$!

	    pidnow=$pidapp
	    while [[ $(adb shell getprop sys.boot_completed) -eq 1 ]];
	    do
		sleep 0.1
		pidold=$pidnow
		pidnow=$(adb shell pidof -s $1)
		if [[ $pidnow != $pidold ]]; then
    		    if [[ $pidnow =~ ^[0-9]+$ ]]; then
		        pidapp=$pidnow
			break
		    else
		        sleep 0.1 # delay for logcat printing the app's last word
		        kill $! # kill logcat background process
		        echo "[LOGCATAPP] $1 (PID $pidapp) has been killed"
			echo "============================================"
		    fi
		fi
	    done
	done
    done
}

# MAIN
if [ $mode == "scan" ]; then
    scanf
elif [ $mode == "log" ] && [[ $1 =~ ^[a-zA-Z0-9.]+$ ]] && [ $# == 1 ]; then
    logcatf $1
else
    helpf
fi
