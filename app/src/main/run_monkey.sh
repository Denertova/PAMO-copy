#!/bin/bash

# Package name from your AndroidManifest.xml
PACKAGE="com.example.helfi"

echo "Checking if $PACKAGE is installed..."
if adb shell pm list packages | grep -q "$PACKAGE"; then
    echo "Starting Monkey test on $PACKAGE..."
    adb shell monkey -p $PACKAGE --throttle 300 -v 500
else
    echo "Error: $PACKAGE is not installed on the device."
    echo "Please deploy the app from Android Studio first."
fi
