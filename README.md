# Android Activities – Android App

## About the Project

This project was developed as part of **Mobile Application Development**. The goal is to create an Android application containing three activities that allow users to navigate between different screens while maintaining and transferring the current value of a counter.

The application demonstrates inter-activity navigation, data transfer between activities using `Intent` extras, and gesture-based navigation using swipe detection.

The application is developed in **Java** using **Android Studio**, with the user interface defined in XML.

## Features

- Three separate activities:
  - `MainActivity` – Main screen containing the counter and navigation buttons.
  - `HelloActivity` – Displays the message `Hello!` and the current counter value.
  - `ThirdActivity` – Displays the message `Activity 3` and the current counter value.
- Counter functionality with a button that increments the counter.
- Counter value transferred between activities using `Intent` extras.
- Navigation between activities using buttons.
- Gesture-based navigation in `ThirdActivity`:
  - Swipe left to navigate to `MainActivity`.
  - Swipe right to navigate to `HelloActivity`.
- Navigation from `HelloActivity` back to `MainActivity`.
- Navigation from `ThirdActivity` to both other activities.

## Technologies Used

- **Language:** Java
- **IDE:** Android Studio
- **UI Design:** XML
- **Platform:** Android
- **Components:** Activity, Intent, TextView, Button
- **Additional Classes:** `OnSwipeTouchListener`

## Application Structure

The application primarily uses the following files and classes:

- `MainActivity.java` – Handles the counter logic, displays the current counter value, and manages navigation to the other activities.
- `HelloActivity.java` – Displays the `Hello!` message and the counter value received from `MainActivity`. Provides navigation back to the main screen.
- `ThirdActivity.java` – Displays `Activity 3` and the transferred counter value. Handles button-based and swipe-based navigation to the other activities.
- `activity_main.xml` – Defines the main screen layout, including the counter display and navigation buttons.
- `activity_hello.xml` – Defines the layout for the second activity.
- `activity_third.xml` – Defines the layout for the third activity.
- `AndroidManifest.xml` – Registers the application's activities.
- `OnSwipeTouchListener.java` – Detects swipe gestures and triggers the corresponding navigation actions.

## How It Works

1. Launch the application to display `MainActivity`.
2. Tap the **Count** button to increment the counter.
3. The updated counter value is displayed on the main screen.
4. Navigate to `HelloActivity` using the corresponding navigation button.
5. The second activity displays `Hello!` along with the transferred counter value.
6. Navigate back to `MainActivity` using the return button.
7. Navigate to `ThirdActivity` using its navigation button.
8. The third activity displays `Activity 3` and the current counter value.
9. Navigate between activities using either the navigation buttons or swipe gestures:
   - Swipe left to return to `MainActivity`.
   - Swipe right to open `HelloActivity`.

## Navigation and Data Transfer

The application uses Android `Intent` objects to start activities and transfer the counter value between them.

The `putExtra()` method is used to attach the current counter value to an intent before launching another activity. The receiving activity retrieves the value using `getIntExtra()`.

This ensures that the counter value is preserved when navigating between activities.

For swipe navigation, the `OnSwipeTouchListener` class detects horizontal touch gestures. Swiping from the middle of the screen towards the left opens `MainActivity`, while swiping towards the right opens `HelloActivity`.

## Installation and Setup

1. Clone this repository:

   ```bash
   git clone https://github.com/YOUR-USERNAME/YOUR-REPOSITORY.git
   ```

2. Open **Android Studio**.
3. Select **Open** and choose the cloned project folder.
4. Wait for Gradle to finish syncing.
5. Start an Android emulator or connect an Android device.
6. Click **Run** to build and launch the application.

Replace `YOUR-USERNAME` and `YOUR-REPOSITORY` with your GitHub username and repository name.

## Learning Objectives

This assignment provides practical experience with:

- Creating and managing multiple Android activities.
- Navigating between activities using `Intent`.
- Passing data between activities using `putExtra()` and `getIntExtra()`.
- Implementing and managing a simple counter.
- Handling button click events.
- Detecting touch gestures and implementing swipe navigation.
- Using `OnTouchListener` to handle touch input.
- Defining activity layouts using XML.
- Registering activities in `AndroidManifest.xml`.
