# Undo/Redo Text Editor (Java)

## Project Description

The **Undo/Redo Text Editor** is a console-based text editor developed using Java. It allows users to add lines, delete the last line, undo previous changes, redo undone changes, and display the current document.

The document is stored using a Linked List, while two Stacks are used to manage Undo and Redo operations. File Handling is implemented to save the document into `document.txt` and load it automatically when the program starts.

## Project Information

- **PS No.:** 17
- **Project Title:** Undo/Redo Text Editor
- **Programming Language:** Java
- **Data Structures:** Linked List, Stack
- **Concepts Used:** Methods, File Handling, Exception Handling

## Features

- Add a new line to the document.
- Delete the last line.
- Undo the previous operation.
- Redo the undone operation.
- Display the complete document.
- Automatically load document data from a file.
- Save document data when exiting.
- Handle invalid menu options.
- Maintain document history using Stack.

## Technologies Used

- Java
- Java Collections Framework
- LinkedList
- Stack
- File Handling
- Scanner Class

## Data Structures Used

| Data Structure | Purpose |
|---|---|
| LinkedList | Stores document lines |
| Undo Stack | Stores previous document states |
| Redo Stack | Stores undone document states |

## Menu Options

```text
===== UNDO/REDO TEXT EDITOR =====

1. Add line
2. Delete last line
3. Undo
4. Redo
5. Display
6. Exit

Enter your choice:
```

## How to Run the Project

### Step 1: Clone the Repository

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
```

### Step 2: Open the Project Folder

```bash
cd Undo-Redo-Text-Editor
```

### Step 3: Compile the Java Program

```bash
javac UndoRedoTextEditor.java
```

### Step 4: Run the Application

```bash
java UndoRedoTextEditor
```

## Sample Output

```text
===== UNDO/REDO TEXT EDITOR =====

1. Add line
2. Delete last line
3. Undo
4. Redo
5. Display
6. Exit

Enter your choice: 1
Enter text: Hello World

Line added.

Enter your choice: 1
Enter text: Python is fun

Line added.

Enter your choice: 5

Document:
1. Hello World
2. Python is fun

Enter your choice: 3

Undo done.

Enter your choice: 5

Document:
1. Hello World

Enter your choice: 4

Redo done.

Enter your choice: 5

Document:
1. Hello World
2. Python is fun
```

## Test Cases

| Test Case | Input | Expected Output |
|---|---|---|
| Normal Input | Add line: Hello World | Line added |
| Boundary Input | Undo on empty document | Nothing to undo |
| Invalid Input | Menu option 9 | Invalid option. Choose 1 to 6 |
| Valid Scenario | Add, Undo, Redo | Document restored correctly |

## Project Structure

```text
Undo-Redo-Text-Editor/
│
├── UndoRedoTextEditor.java
├── document.txt
└── README.md
```

**Note:** `document.txt` is created automatically when the document is saved. It is loaded automatically when the application starts.

## Learning Outcomes

Through this project, I learned:

- Implementation of Stack data structures.
- Working with Linked Lists in Java.
- Understanding Undo and Redo operations.
- Managing document history.
- Reading and writing files in Java.
- Implementing menu-driven console applications.

## Future Enhancements

- Add editing of existing lines.
- Add delete-specific-line functionality.
- Implement keyboard shortcuts for Undo and Redo.
- Develop a graphical user interface (GUI).
- Add automatic saving after every modification.

## Author

**Developed as part of a Java Data Structures project.**

## License

This project is created for educational and learning purposes.
