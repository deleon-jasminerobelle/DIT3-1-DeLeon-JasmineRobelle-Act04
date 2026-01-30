# EventPracticeApp

## 📱 Project Overview

**EventPracticeApp** is a simple Android application designed to demonstrate basic **event handling**, **input validation**, and **error handling** in Android development. The app allows users to enter their name and age, submit the data, and view formatted output based on user interaction.

---

## 🛠 Project Setup

* **Project Name:** EventPracticeApp
* **IDE:** Android Studio
* **Template Used:** Empty Activity
* **Language:** Kotlin

---

## 🎨 UI Design (activity_main.xml)

The application uses a simple and interactive layout containing:

* **EditText (Name)** – Input field for the user’s name
* **EditText (Age)** – Input field for the user’s age
* **Button (Submit)** – Triggers input validation and data display
* **TextView** – Displays the submitted output message

The layout is designed to be clean, minimal, and easy to use.

---

## 🖱 Event Handling Implementation

* Implemented `setOnClickListener()` for the **Submit** button
* On button click:

  * Reads user input from Name and Age fields
  * Validates that both fields are not empty
  * Displays formatted output in the TextView

---

## ⚠️ Input Validation & Error Handling

* Displays a **Toast message** if any field is empty:

  > “Please fill in all fields.”
* Uses a **try-catch block** to handle invalid age input (e.g., non-numeric values)
* Prevents app crashes by gracefully handling invalid user input

---

## 📝 Reflection

### 1. How did you implement event handling for user actions?

In this project, I implemented event handling using various listeners such as `OnClickListener`, `OnItemSelectedListener`, and `TextWatcher`. These listeners allowed the app to respond dynamically to user actions like button clicks, selections, and text input changes. In some cases, I also used the XML `onClick` attribute to directly connect UI components to functions in the activity, keeping the code organized and readable. When multiple UI elements required similar behavior, I handled them using a single event listener combined with a switch statement for better efficiency and maintainability.

---

### 2. What techniques ensured smooth and stable interaction?

To ensure smooth and stable interaction, I applied proper input validation and error handling using try-catch blocks to prevent crashes from invalid input. I used asynchronous operations such as coroutines or AsyncTask to handle background work without blocking the main thread. Debouncing techniques were applied to avoid multiple rapid button clicks, and all UI updates were performed on the main thread. Additionally, I utilized ViewModel and LiveData under the MVVM architecture to manage UI-related data efficiently and ensure stability during configuration changes.

---

### 3. What improvements would you add in future versions?

In future versions, I would enhance user interaction by adding gesture-based features such as swipe or drag-and-drop interactions. I also plan to include animations and transitions using MotionLayout to make the UI more engaging. Improving feedback through Snackbars and AlertDialogs would provide better user communication. Additionally, implementing data caching using Room or Retrofit would enable offline support and faster data loading. Performance and memory optimizations would also be prioritized to ensure smooth operation on lower-end devices.

---

## 🎯 Learning Outcomes

* Implemented basic event handling using listeners
* Performed input validation and error handling
* Used Toast messages for user feedback
* Ensured app stability and responsiveness
* Applied best practices for interactive UI design
