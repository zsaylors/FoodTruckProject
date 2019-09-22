# Food Truck Rating Project
## Hello, Food Truck!
![alt text](https://i.ibb.co/bv7Ffnq/Screen-Shot-2019-09-22-at-5-05-32-AM.png "Running app image")
## Skill Distillery Week Two Homework Project

### Overview
This application allows a user to input a food trucks name, food type, and rating.  After a user enters information, the app will return to the main menu and allow the user to see a list of trucks and ratings, the average rating, and the best rated truck.

1.  **Rate trucks**:
The first step requires input for the number of trucks.  It will continue to ask for an input until an integer greater than zero is entered.  This will create an array (or list) of the size that the user entered.

Then, the app will ask for a name, food type, and rating.  The program will only allow for an integer 0 - 5 to be entered for rating.  Until the number of specified trucks are entered, the program will continue to loop.  If a user needs to exit early, 'quit' may be typed when entering the truck name.  A unique id will be assigned to each truck.

The "Rate trucks" option may be run again, but a new array will be created and the previous data will no longer be displayed.  A prompt appears to ensure the user does not accidentally loose data.

2. **Display trucks**:
This menu option will run through a `for` loop in order to display all truck data from the array created.  It will show the id, truck name, food type, and rating.

3. **Average rating**:
The average rating of all food trucks is displayed.  This is done by running a `for` loop and dividing by the `array.length`.

4. **Best truck**:
Best truck will display the top rated truck.  If there is more than one top food truck with the same top rating, the truck with the lowest id will show.  This could be changed with an `if` statement, but was not implemented.

5. **Quit**:
Quit ends the program with a random goodbye message.  There are eight possible messages.

### Technologies/ Topics Applied
- **Packages**:
A single package (or directory) titled FoodTrucks was used that contained four Java classes.

- **Objects and Classes**:
The program was divided into a `main` class and three subclasses.  The first subclass defined food truck data, another took user input, and the third contained methods to return menu items.

- **StringBuilder**:
`StringBuilder` was used to return the list of food trucks as a `toString`.  It was also used in order to build the visual menu.

- **Arrays**:
Arrays were created in order to store truck data and goodbye messages.

- **For loops**:
The application required many `for` loops to iterate through arrays in order to print or use the arrays data.

- **Do while**:
The main use of a `do while` loop was to prevent the program from breaking during a input mismatch (more about this in lessons learned).

- **While loop**:
A `while` loop was used to keep the menu / `switch` statement running until the `userInput()` method was run or the user wanted to quit the program.

- **Unicode**:
Unicode was used to output stars and other characters to give the app some life.  <http://fileformat.info> was utilized to find conversions in hexadecimal value format.

### Lessons Learned
The biggest lesson was dividing code into classes and and methods, which I am still figuring out.  Originally, I had the program working with only two classes.  To experiment and learn further, I divided it into four classes.  When divided, the main class only has code that provides a menu with methods from other classes. This also helped organize the program better.

Another learning point was the difference between a constructor and a setter.  The program works without the setter methods since the `getUserInput()` method creates an array by `truck[i] = new FoodTruck(truckName, foodType, rating);`.  I did add setters, but the methods are commented out since they are unused.   I added them to test and learn from. There is an uncommented setter, `setId()`, which resets the id to 1 if the user runs "1. Rate trucks" more than once.

One issue that I wanted to resolve while testing was to prevent mismatch errors that broke the program.  This happened when accidentally entering a string while an int was expected.  The menu accepts strings to be entered such as "1", "2", ... "5", and that works for the menu.  However, in other cases, an integer is required in order to iterate through data.  Casting a string to an int does not work - believe me, I tried.  After searching, I found a solution to import `InputMismatchException`, and then run a `do while` loop with `try` and `catch`.  This solution prevents the program from breaking while input is something other than an integer for the number of trucks or food truck ratings.
