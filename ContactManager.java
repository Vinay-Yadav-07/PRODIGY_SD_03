import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContactManager {
    private static Map<String, String[]> contacts = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            
            System.out.println("\n1. Add new contact");
            System.out.println("2. View contact list");
            System.out.println("3. Edit contact");
            System.out.println("4. Delete contact");
            System.out.println("5. Exit");
	    System.out.println("\nChoose an option:");

            int choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContactList();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void addContact() {
        System.out.println("Enter name:");
        String name = sc.nextLine();

        System.out.println("Enter phone number:");
        String phoneNumber = sc.nextLine();

        System.out.println("Enter email:");
        String email = sc.nextLine();

        contacts.put(name, new String[]{phoneNumber, email});
        System.out.println("Congrats! Contact added successfully.");
    }

    private static void viewContactList() {
        if (contacts.isEmpty()) {
            System.out.println("Contact list is empty.");
        } else {
            System.out.println("Contact List:");
            for (Map.Entry<String, String[]> entry : contacts.entrySet()) {
                String name = entry.getKey();
                String[] info = entry.getValue();
                System.out.println("Name: " + name + ", Phone: " + info[0] + ", Email: " + info[1]);
            }
        }
    }

    private static void editContact() {
        System.out.println("Enter name of the contact to edit:");
        String nameToEdit = sc.nextLine();

        if (contacts.containsKey(nameToEdit)) {
            System.out.println("Enter new phone number:");
            String newPhoneNumber = sc.nextLine();

            System.out.println("Enter new email:");
            String newEmail = sc.nextLine();

            contacts.get(nameToEdit)[0] = newPhoneNumber;
            contacts.get(nameToEdit)[1] = newEmail;

            System.out.println("Contact edited successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void deleteContact() {
        System.out.println("Enter name of the contact to delete:");
        String nameToDelete = sc.nextLine();

        if (contacts.containsKey(nameToDelete)) {
            contacts.remove(nameToDelete);
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }
}