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
- If your computer supports GPU (especially NVIDIA), install GPU driver for optimizing AVD (Android Virtual Device) perfomance.
```
sudo ubuntu-drivers autoinstall
```
- Install 

<br>

# Customize
## Theme
1. Open **File &rarr; Settings &rarr; Plugins** in Android Studio
2. Install theme you want. Recommend: `One Dark Theme`, `Hiberbee Theme`, `Material Theme`

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

## Bind layout
- `find` : bind XML component in layout to Java object
- `findquick` : bind XML component in layout to Java object without declaring

## Button
- `btnclick` : set OnClick Listener to button object (non-lambda style)
- `btnclickquick` : set OnClick Listener to button object (lambda style + non pre-declared)
- *`button.setOnClickListener(v -> {})`* : set OnClick Listener to button object (lambda style)

## TextView
- *`textView.setText(valueStr)`* : change content of TextView object

## EditText
- *`editText.setText(valueStr)`* : change content of TextView object
- *`editText.length()`* : get text length
- *`editText.setError("show error")`* : trigger error in EditText object
- `textchangewatch` : handle text change event

## TextInputLayout
- *`editText.setText(valueStr)`* : change content of TextView object
- *`editText.length()`* : get text length
- *`editText.setError("show error")`* && *`editText.setErrorEnabled(true)`* : show error in TextInputLayout object
- *`editText.setErrorEnabled(false)`* : hide error in TextInputLayout object
- `textchangewatch` : handle text change event

## Activity
- `swact` : switch to another activity
- `loadintent` : load input argument of activity after being created
- *`overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out)`* : swipe left to new activity, run after triggering activity
- *`overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out)`* : swipe right to previous activity, run after triggering activity

## Intent
- `call` : dial a phone number
- `sms` : compose a SMS message to a phone number
- `web` : browse a website

## Clipboard
- `clipman` : declare ClipboardManager object
- `clipcopytext` : copy plain text to clipboard
- `clippastetext` : paste plain text from clipboard

## Toast
- `toast` : make new toast
- *`toast.setGravity(Gravity.CENTER | Gravity.TOP, 0, 0)`* : change toast position

## Snackbar
- `snack` : make snackbar with button
- `snacktext` : make new snackbar (for notification)

<br>

# Concept
## Life Cycle of Activity
**Create**  <br>
|------------- finish data binding, allocate resources <br>
*Start* <br>
|------------- visible to user <br>
**Resume** <br>
|-------------------- running <br>
*Pause* <br>
|------------- freezing: `transition to next activity` , `new app partially cover` <br>
**Stop** <br>
|------------- hiding: `dive into Back Stack` , `Recent App pressed` , `Home pressed`, `new app fully cover` <br>
**Destroy** <br>
|------------- free all resources: `pop out of Back Stack` , `kill app` <br>