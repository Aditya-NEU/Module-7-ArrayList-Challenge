import java.util.Scanner;

public class Main {

    /**
     * 	    // Create a program that implements a simple mobile phone with the following capabilities.
     *         // Able to store, modify, remove and query contact names.
     *         // You will want to create a separate class for Contacts (name and phone number).
     *         // Create a master class (MobilePhone) that holds the ArrayList of Contacts
     *         // The MobilePhone class has the functionality listed above.
     *         // Add a menu of options that are available.
     *         // Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
     *         // and search/find contact.
     *         // When adding or updating be sure to check if the contact already exists (use name)
     *         // Be sure not to expose the inner workings of the Arraylist to MobilePhone
     *         // e.g. no ints, no .get(i) etc
     *         // MobilePhone should do everything with Contact objects only.
     */

    private static Scanner scanner=new Scanner(System.in);
    private static MobilePhone mobilePhone= new MobilePhone("123 456 7890");

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();
        while(!quit) {
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;

                case 1:
                    mobilePhone.printContacts();
                    break;

                case 2:
                    addNewContact();
                    break;

                case 3:
                    updateContact();
                    break;

                case 4:
                    removeContact();
                    break;

                case 5:
                    queryContact();
                    break;

                case 6:
                    printActions();
                    break;
            }

        }

    }



    private static void addNewContact(){
        System.out.println("Enter the name of the contact:");
        String name= scanner.nextLine();
        System.out.println("Enter phone number:");
        String phone= scanner.nextLine();
        Contacts contacts= Contacts.createContact(name,phone);
        if(mobilePhone.addNewContact(contacts)){
            System.out.println("New contact is added.");
        }
        else {
            System.out.println("Cannot add "+name +", already in the file.");
        }
    }

    private static void updateContact(){
        System.out.println("Enter the name of the contact to be updated:");
        String name= scanner.nextLine();
        Contacts existingContact=mobilePhone.queryContact(name);
        if(existingContact==null){
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Enter new contact name");
        String newName= scanner.nextLine();
        System.out.println("Enter the new phone number.");
        String newPhone= scanner.nextLine();
        Contacts newContact= Contacts.createContact(newName,newPhone);
        if(mobilePhone.updateContact(existingContact,newContact)){
            System.out.println("Successfully updated record.");
        }
        else {
            System.out.println("Error");
        }

    }

    private static void removeContact(){
        System.out.println("Enter the name of the contact to be removed");
        String name= scanner.nextLine();
        Contacts existingContact= mobilePhone.queryContact(name);
        if(existingContact==null){
            System.out.println("No contact found");
        }
        if(mobilePhone.removeContact(existingContact)){
            System.out.println("Successfully deleted.");
        }
        else {
            System.out.println("Error deleting contact.");
        }
    }


    private static void queryContact(){
        System.out.println("Enter the name of the contact name:");
        String name= scanner.nextLine();
        Contacts existingContact= mobilePhone.queryContact(name);
        if(existingContact==null){
            System.out.println("Cannot be found");
        }
        System.out.println("Name:"+existingContact.getContactName()+" phone number is :"+existingContact.getPhoneNumber());
    }

    private static void startPhone(){
        System.out.println("Starting phone....");

    }

    private static void printActions(){
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0  - to shutdown\n" +
                "1  - to print contacts\n" +
                "2  - to add a new contact\n" +
                "3  - to update existing an existing contact\n" +
                "4  - to remove an existing contact\n" +
                "5  - query if an existing contact exists\n" +
                "6  - to print a list of available actions.");
        System.out.println("Choose your action: ");
    }



}
