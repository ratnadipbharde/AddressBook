import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    private ArrayList<Contact> addressBookList = new ArrayList<>();

    public void addContact() {
        System.out.println("--------------------------------------------------------" + "\nAdd Contact Details\n--------------------------------------------------------");
        System.out.print("How many Contact you want to Add:");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        for (int i = 0; i < number; i++) {
            System.out.println("----------------------------------\nContact : " + (i + 1) + "" +
                    "\n----------------------------------");
            Contact contact = new Contact();
            System.out.print("First Name : ");
            contact.setFirstName(sc.next());
            System.out.print("Last Name : ");
            contact.setLastName(sc.next());
            System.out.print("Address : ");
            contact.setAddress(sc.next());
            System.out.print("City : ");
            contact.setCity(sc.next());
            System.out.print("State : ");
            contact.setState(sc.next());
            System.out.print("zip : ");
            contact.setZip(sc.next());
            System.out.print("Phone Number : ");
            contact.setPhoneNumber(sc.next());
            System.out.print("Email : ");
            contact.setEmail(sc.next());
            for (int j = 0; j < addressBookList.size(); j++) {
                if (addressBookList.get(j).getFirstName().equals(contact.getFirstName()) && addressBookList.get(j).getLastName().equals(contact.getLastName())) {
                    System.out.println("contact already exist..");
                    i--;
                    continue;
                }
            }
            addressBookList.add(contact);
        }
        showContacts();
        System.out.println("\nadded successfully..... \n");
    }

    public void deleteContact() {
        System.out.println("--------------------------------------------------------" + "\nDelete Contact Details\n--------------------------------------------------------");
        Contact contact = new Contact(); //object create for Contact
        Scanner sc = new Scanner(System.in);
        System.out.println("\nsearch detail for edit.........");
        System.out.println("Enter First Name : ");
        String firstName = sc.next();
        System.out.println("Enter Last Name : ");
        String lastName = sc.next();
        for (int i = 0; i < addressBookList.size(); i++) {
            String fName = addressBookList.get(i).getFirstName();
            String lName = addressBookList.get(i).getLastName();

            if (firstName.equals(fName) && lastName.equals(lName)) {
                System.out.println("Contact found.........");
                addressBookList.remove(i);
                System.out.println("\nDelete successfully..... \n");
                return;
            }
        }
        System.out.println("contact not found hence deletion rejected");
    }

    public void editContact() {
        System.out.println("--------------------------------------------------------" + "\nEdit Contact Details\n--------------------------------------------------------");
        Contact contact = new Contact(); //object create for Contact
        Scanner sc = new Scanner(System.in);
        System.out.println("\nsearch detail for edit.........");
        System.out.print("Name : ");
        String firstName = sc.next();
        for (int i = 0; i < addressBookList.size(); i++) {
            String fName = addressBookList.get(i).getFirstName();
            if (firstName.equals(fName)) {
                System.out.println("Contact found.........");
                System.out.print("\n1. First Name\n2. Last Name\n3. Address\n" + "4. City\n5. State\n6. zip\n7. Phone Number\n8. Email\ninsert choice to edit Contact details : ");
                switch (sc.next()) {
                    case "1":
                        System.out.print("Name : ");
                        addressBookList.get(i).setFirstName(sc.next());
                        showContacts();
                        System.out.println("\nedit successfully..... \n");
                        break;
                    case "2":
                        System.out.print("Last Name : ");
                        addressBookList.get(i).setLastName(sc.next());
                        showContacts();
                        System.out.println("\nedit successfully..... \n");
                        break;
                    case "3":
                        System.out.print("Address : ");
                        addressBookList.get(i).setAddress(sc.next());
                        showContacts();
                        System.out.println("\nedit successfully..... \n");
                        break;
                    case "4":
                        System.out.print("City : ");
                        addressBookList.get(i).setCity(sc.next());
                        showContacts();
                        System.out.println("\nedit successfully..... \n");
                        break;
                    case "5":
                        System.out.print("State : ");
                        addressBookList.get(i).setState(sc.next());
                        showContacts();
                        System.out.println("\nedit successfully..... \n");
                        break;
                    case "6":
                        System.out.print("zip : ");
                        addressBookList.get(i).setZip(sc.next());
                        showContacts();
                        System.out.println("\nedit successfully..... \n");
                        break;
                    case "7":
                        System.out.print("Phone Number : ");
                        addressBookList.get(i).setPhoneNumber(sc.next());
                        showContacts();
                        System.out.println("\nedit successfully..... \n");
                        break;
                    case "8":
                        System.out.print("Email : ");
                        addressBookList.get(i).setEmail(sc.next());
                        showContacts();
                        System.out.println("\nedit successfully..... \n");
                        break;
                    default:
                        System.out.println("invalid input");
                }
            } else System.out.println("Contact Not available in Address Book.......");
        }
    }

    public void showContacts() {
        System.out.println("\n----------------------Contact----------------------");
        for (int i = 0; i < addressBookList.size(); i++) {
            System.out.println("----------------------------------\nContact : " + (i + 1) + "\n----------------------------------");
            System.out.println("\n" + addressBookList.get(i));
        }
        System.out.println("\n---------------------------------------------------");
    }

    @Override
    public String toString() {
        return "\n" + addressBookList ;
    }
}
