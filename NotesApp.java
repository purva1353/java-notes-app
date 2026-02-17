import java.io.*;
import java.util.Scanner;

public class NotesApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Notes App ===");
            System.out.println("1. Write Note");
            System.out.println("2. Read Notes");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    try (FileWriter writer = new FileWriter("notes.txt", true)) {
                        System.out.print("Enter your note: ");
                        String note = sc.nextLine();
                        writer.write(note + "\n");
                        System.out.println("Note saved successfully!");
                    } catch (IOException e) {
                        System.out.println("Error writing file.");
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    try (BufferedReader reader = new BufferedReader(new FileReader("notes.txt"))) {
                        String line;
                        System.out.println("\n--- Your Notes ---");
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
                    } catch (IOException e) {
                        System.out.println("Error reading file.");
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);

        sc.close();
    }
}
