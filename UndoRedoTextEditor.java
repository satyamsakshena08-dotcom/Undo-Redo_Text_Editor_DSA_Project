
import java.util.LinkedList;
import java.util.Stack;
import java.util.Scanner;
import java.io.*;

public class UndoRedoTextEditor {

    // Linked List to store document lines
    static LinkedList<String> document = new LinkedList<>();

    // Stacks for Undo and Redo operations
    static Stack<LinkedList<String>> undoStack = new Stack<>();
    static Stack<LinkedList<String>> redoStack = new Stack<>();

    static final String FILE_NAME = "document.txt";

    // Save previous document state
    static void saveState() {
        undoStack.push(new LinkedList<>(document));
        redoStack.clear();
    }

    // Add a new line
    static void addLine(String line) {
        saveState();
        document.add(line);
        System.out.println("Line added.");
    }

    // Delete the last line
    static void deleteLastLine() {

        if (document.isEmpty()) {
            System.out.println("Document is empty.");
            return;
        }

        saveState();
        document.removeLast();

        System.out.println("Last line deleted.");
    }

    // Undo operation
    static void undo() {

        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }

        redoStack.push(new LinkedList<>(document));
        document = undoStack.pop();

        System.out.println("Undo done.");
    }

    // Redo operation
    static void redo() {

        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo.");
            return;
        }

        undoStack.push(new LinkedList<>(document));
        document = redoStack.pop();

        System.out.println("Redo done.");
    }

    // Display document
    static void display() {

        if (document.isEmpty()) {
            System.out.println("Document is empty.");
            return;
        }

        System.out.println("Document:");

        int count = 1;

        for (String line : document) {
            System.out.println(count + ". " + line);
            count++;
        }
    }

    // Load document from file
    static void loadFromFile() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("New document created.");
            return;
        }

        try (BufferedReader reader =
                 new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {
                document.add(line);
            }

            System.out.println("Document loaded successfully.");

        } catch (IOException e) {
            System.out.println("Error loading document: " + e.getMessage());
        }
    }

    // Save document to file
    static void saveToFile() {

        try (BufferedWriter writer =
                 new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (String line : document) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Document saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving document: " + e.getMessage());
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Load document when program starts
        loadFromFile();

        // Initialize choice to avoid compilation error
        int choice = 0;

        do {

            System.out.println("\n===== UNDO/REDO TEXT EDITOR =====");
            System.out.println("1. Add line");
            System.out.println("2. Delete last line");
            System.out.println("3. Undo");
            System.out.println("4. Redo");
            System.out.println("5. Display");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            // Check invalid input
            if (!sc.hasNextInt()) {

                System.out.println(
                    "Invalid option. Choose 1 to 6."
                );

                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter text: ");
                    String line = sc.nextLine();

                    addLine(line);
                    break;

                case 2:

                    deleteLastLine();
                    break;

                case 3:

                    undo();
                    break;

                case 4:

                    redo();
                    break;

                case 5:

                    display();
                    break;

                case 6:

                    saveToFile();
                    System.out.println("Exiting Text Editor...");
                    break;

                default:

                    System.out.println(
                        "Invalid option. Choose 1 to 6."
                    );
            }

        } while (choice != 6);

        sc.close();
    }
}
