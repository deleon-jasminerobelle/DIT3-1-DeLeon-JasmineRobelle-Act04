# DIT3-1-DeLeon-JasmineRobelle-Act04

1. How did you implement event handling for user actions?

In my Android Studio project, I implemented event handling for user actions using various listeners such as OnClickListener, OnItemSelectedListener, and TextWatcher. These listeners allowed the application to respond effectively to user inputs, including button clicks, selections, and text changes. For some UI components, I also used the XML onClick attribute to link interface elements directly to their corresponding functions in the activity, which made the layout and logic cleaner and easier to maintain. Additionally, when multiple buttons required similar behavior, I handled them using a single event listener combined with a switch statement to make the code more efficient and organized.

2. What techniques ensured smooth and stable interaction?

To ensure smooth and stable interaction within the application, I implemented several techniques such as input validation and proper error handling using try-catch blocks to prevent unexpected crashes from invalid data. I also used asynchronous operations through AsyncTask or coroutines to perform long-running tasks without freezing the user interface. Debouncing was applied to prevent multiple actions from a single rapid tap, and UI updates were always performed on the main thread to maintain responsiveness. Furthermore, I utilized the ViewModel and LiveData components under the MVVM architecture to manage and observe data changes efficiently, ensuring that the UI remained consistent and lag-free even during configuration changes.

3. What improvements would you add in future versions?

For future improvements, I plan to enhance user interaction by integrating gesture controls such as swipe-to-delete or drag-and-drop features. I also aim to add animations and transition effects using MotionLayout to make the interface more engaging and visually appealing. Improving error handling and user feedback mechanisms, such as through the use of snackbars and alert dialogs, is another goal to make the app more user-friendly. Additionally, I intend to implement data caching using Room or Retrofit to enable offline functionality and faster loading times. Finally, I plan to optimize performance and memory usage to ensure that the application remains stable and efficient even on lower-end devices.
