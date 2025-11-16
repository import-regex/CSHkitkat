# CSHkitkat - Android Camera Surveillance Server

This is a simple, lightweight Android application that turns an old smartphone or a tablet (running Android 4.1 / API 16 "KitKat" or newer) into a web-based camera surveillance and recording server.

The entire system is self-contained. The phone hosts a web server that you can access from any device on the same Wi-Fi/hotspot network to store and review recordings.

## Key Features

-   **Web-Based Recording:** Manage recording parameters directly from the web interface.
-   **File Management:**  Fitler by time and source, view and download recordings from a simple web page.
-   **Hotspot Mode:** Works completely offline and can run on a phone's own Wi-Fi hotspot, creating a portable, private surveillance network.
-   **Flexible Storage:** Automatically detects and prioritizes saving recordings to a USB drive, SD card, or internal storage.
-   **No Cloud, No Accounts:** Completely private. Nothing is ever uploaded to the internet.
-   **Resource effiency** The whole system is optimized for minimal resources and peak storage, network and CPU load efficiency.
-   **Customization** Users have in depth control to set, change and optimize detailed running parameters of the whole system.

## How to Use

1.  **Install the App:**
    -   Download the `app-debug.apk` file from the [Releases page](https://github.com/import-regex/CSHkitkat/releases) (or build it yourself using Android Studio).
    -   Install the APK on your target Android device. You may need to enable "Install from unknown sources" in your device's security settings.

2.  **Prepare Storage:**
    -   For best results, connect a USB OTG drive or insert an SD card. The app will automatically try to use it.
    -   **Important:** The app works best with a completely empty storage device. It assumes the whole storage capacity as dedicated for recordings.

3.  **Start the Server:**
    -   Open the app. It will suggest a storage path.
    -   Press **"Apply and Start a Server"**.

4.  **Connect and View:**
    -   The app will display an IP address on the screen (e.g., `http://192.168.1.10:8080`).
    -   On another device (a laptop or another phone) connected to the **same Wi-Fi network**, open a web browser and go to that address.
    -   You will see the main camera page. To view recordings, navigate to `http://<IP_ADDRESS>:8080/watch`.
    -   You are most likely to encounter permissions issues. Run the app locally to initialize the page as localhost:8080 and update the upload URL to the correct one. On PC run the page as file:///
    -   Use the page /learn to learn more

## Technical Details

-   **Minimum API Level:** 16 (Android 4.x.x including even Jelly Bean)
-   **Web Server:** Implemented using the lightweight `NanoHTTPD` library.
-   **Recording:** Uses the `MediaRecorder` API, accessible from JavaScript in the browser.
-   **Compatibility:** The web interface is designed to work on variety of browsers of any type, but modern Chromium based ones have the least bugs.
-   **Pages and use**
<br>/ - the main page is the camera mode page.
<br>/upload - POST the recording files to the server there.
<br>/watch - the watch page is where you review and download recordings.
<br>/info - the learn page is where you learn more about the project.
<br>/apk - download the same apk - conveninent for sharing around the app to Androids that need an initialization server or just share the app with friends.
<br>/custom/abc.xyz - retrieve your custom abc.xyz file saved under the /custom/ directory in the recordings storage path of the server.
