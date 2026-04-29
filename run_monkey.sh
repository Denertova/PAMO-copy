#!/bin/bash

# Use the full path to adb if it's not in your PATH
ADB="/Users/klaudia/Library/Android/sdk/platform-tools/adb"
PACKAGE="com.example.helfi"

echo "Checking for connected devices..."
$ADB devices

echo "Checking if $PACKAGE is installed..."
if $ADB shell pm list packages | grep -q "$PACKAGE"; then
    echo "Starting Monkey test on $PACKAGE..."
    # --throttle 300 adds a 300ms delay between events to make it more realistic
    $ADB shell monkey -p $PACKAGE --throttle 300 -v 500
else
    echo "Error: $PACKAGE is not installed."
    echo "Please click the 'Run' button (green play icon) in Android Studio first."
fi
