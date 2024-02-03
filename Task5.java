
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String emailAddress;
    

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

  

    
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber + ", Email Address: " + emailAddress;
    }

	public Object getName() {
	
		return null;
	}
}

class AddressBook {
    private ArrayList<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(String name) {
        contacts.removeIf(contact -> contact.getName().equals(name));
    }

    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        return null;
    }

    public void displayAllContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(contacts);
            System.out.println("Contacts saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            contacts = (ArrayList<Contact>) ois.readObject();
            System.out.println("Contacts loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AddressBook addressBook = new AddressBook();

        while (true) {
            System.out.println("\nAddress Book System");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Save to File");
            System.out.println("6. Load from File");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter contact name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter email address: ");
                    String emailAddress = scanner.nextLine();
                    Contact contact = new Contact(name, phoneNumber, emailAddress);
                    addressBook.addContact(contact);
                    System.out.println("Contact added successfully.");
                    break;

                case 2:
                    System.out.print("Enter contact name to remove: ");
                    String removeName = scanner.nextLine();
                    addressBook.removeContact(removeName);
                    System.out.println("Contact removed successfully.");
                    break;

                case 3:
                    System.out.print("Enter contact name to search: ");
                    String searchName = scanner.nextLine();
                    Contact foundContact = addressBook.searchContact(searchName);
                    if (foundContact != null) {
                        System.out.println("Contact found:");
                        System.out.println(foundContact);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    addressBook.displayAllContacts();
                    break;

                case 5:
                    System.out.print("Enter filename to save: ");
                    String saveFilename = scanner.nextLine();
                    addressBook.saveToFile(saveFilename);
                    break;

                case 6:
                    System.out.print("Enter filename to load: ");
                    String loadFilename = scanner.nextLine();
                    addressBook.loadFromFile(loadFilename);
                    break;

                case 7:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
