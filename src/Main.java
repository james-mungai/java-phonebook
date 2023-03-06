import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Contact> myContacts = new ArrayList<Contact>();
        myContacts.add(new Contact(1,"Sharon", "Jebet",1234));
        myContacts.add(new Contact(2,"Ken", "Maundu",12345));
        myContacts.add(new Contact(3,"Kailikia", "Munene",123456));
        myContacts.add(new Contact(4,"Edwins", "Mboga",23456));
        myContacts.add(new Contact(5,"Eric", "Marete",98765));

        ArrayList <Message> myMessages = new ArrayList<Message>();
        myMessages.add(new Message("Hello, I need water", 1));
        myMessages.add(new Message("Good Morning. Is the meeting still on?", 2));
        myMessages.add(new Message("Good Morning. Is the meeting still on?", 2));
        myMessages.add(new Message("Thank you I had a good time", 2));

        Scanner scanner = new Scanner(System.in);

        boolean shouldContinueMainMenu = true;
        while(shouldContinueMainMenu){
            System.out.println("Choose an option");
            System.out.println("\t 1. Manage Contacts");
            System.out.println("\t 2. Messages");
            System.out.println("\t 3. Quit");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    boolean shouldContinueManageContacts = true;
                    while(shouldContinueManageContacts){
                        System.out.println("Choose an option");
                        System.out.println("\t 1. Show all contacts");
                        System.out.println("\t 2. Add a new contact");
                        System.out.println("\t 3. Search for contact");
                        System.out.println("\t 4. Delete a Contact. ");
                        System.out.println("\t 5. Go back to previous menu");
                        int input2 = scanner.nextInt();
                        switch (input2){
                            case 1:

                                myContacts.forEach(element-> {
                                            System.out.println(myContacts.indexOf(element)+1);
                                            System.out.println("\t First Name "+element.getFirstName());
                                            System.out.println("\t Last Name "+element.getLastName());
                                            System.out.println("\t Phone Number "+element.getPhoneNumber());
                                        }
                                );
                                break;
                            case 2:
                                System.out.println("enter contacts phone number: ");
                                int phoneNumber = scanner.nextInt();
                                System.out.println("Enter contacts first Name");
                                String firstName = scanner.next();
                                System.out.println("Enter contacts last name");
                                String lastName = scanner.next();
                                Contact newContact = new Contact(myContacts.size()+1,firstName, lastName, phoneNumber);
                                myContacts.add(newContact);
                                System.out.println("You have created a new contact "+ newContact.getID());
                                break;
                            case 3:
                                System.out.println("search contacts by first name");
                                String enteredFName = scanner.next();
                                ArrayList<Contact> filteredContacts = new ArrayList<Contact>();
                                for (Contact myContact : myContacts) {
                                    if(myContact.getFirstName().contains(enteredFName)){
                                        filteredContacts.add(myContact);
                                    }
                                }
                                System.out.printf("The names that contain %s are \n", enteredFName);
                                filteredContacts.forEach(el-> System.out.println(el.getFirstName()));
                                break;
                            case 4:
                                System.out.println("delete contacts by ID");
                                int id = scanner.nextInt();
                                myContacts.removeIf(el->el.getID()==id);
                                System.out.println("These are your remaining contacts");
                                System.out.println(myContacts.toString());
                                System.out.println("Contact deleted successfully \n");
                                break;
                            case 5:
                                shouldContinueManageContacts = false;
                        }
                    }
                    break;
                case 2:
                    System.out.println("\t 1. See all messages");
                    System.out.println("\t 2. send a new message");
                    System.out.println("\t 3. Go back to previous menu");
                case 3:
                    System.out.println("good bye");
                    shouldContinueMainMenu = false;
            }

        }


    }




}