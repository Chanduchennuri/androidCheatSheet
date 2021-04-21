# Android Cheat Sheet 
### Editor: `bluelul`
<br>

# Install
## Ubuntu
1. Download Android Studio at [Android Homepage](https://developer.android.com/studio).
2. Extract to any folder you want, i.e. *{installation home}*
3. Open terminal at *{installation home}*
```bash
./bin/studio.sh
```
4. Follow instruction to install Android Studio (`custom option` recommended)

## Note
- If your computer supports GPU (especially NVIDIA), install driver for optimizing AVD (Android Virtual Device) perfomance.

<br>

# Customize
## Theme
1. Open **File &rarr; Settings &rarr; Plugins** in Android Studio
2. Install theme you want
- Recommend: `One Dark Theme`, `Hiberbee Theme`, `Material Theme`

<br>

# Code snippet / Live Template
## Install template
1. Copy all content of bluelulAndroid.xml to clipboard
2. Open **File &rarr; Settings** (`Ctrl + Alt + S`) in Android Studio, then **Editor &rarr; Live Templates**
3. Press `+` button on the right (or press `Alt + Insert`) and choose `Template Group`
4. Input `AndroidBluelul` or any name you want
5. Press `Ctrl + V` to add all copied templates to this group

## Log
- `logt` : assign TAG
- `logi` : log info
- `loge` : log error
- `logd` : log debug

## Button
- `find` : bind buttonID element in layout to a Button object
- `btnclick` : set OnClick Listener to button object (non-lambda style)
- *`button.setOnClickListener(v -> {})`* : set OnClick Listener to button object (lambda style)

## TextView
- `find` : bind textViewID element in layout to a TextView object
- *`textView.setText(valueStr)`* : change content of TextView object

## Activity
- `swact` : switch to another activity
- *`Intent intent = getIntent()`* : get intent sent to activity, should put in onCreate() callback function
- *`String val = intent.getStringExtra("arg")`* : parse argument from intent

## Toast
- `toast` : make new toast
- *`toast.setGravity(Gravity.CENTER | Gravity.TOP, 0, 0)`* : change toast position
