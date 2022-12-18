import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    static final int FIRSTNAME = 1;
    static final int LASTNAME = 2;
    static final int ADDRESS = 3;
    static final int CITY = 4;
    static final int STATE = 5;
    static final int ZIP = 6;
    static final int PHONENUMBER = 7;
    static final int EMAIL = 8;
    private ArrayList<Contact> addressBookList = new ArrayList<>();

    public ArrayList<Contact> getAddressBookList() {
        return addressBookList;
    }

    public void setAddressBookList(ArrayList<Contact> addressBookList) {
        this.addressBookList = addressBookList;
    }

    public void addContact(String firstName) {
      //  System.out.println("--------------------------------------------------------" + "\nAdd Contact Details\n--------------------------------------------------------");
       // System.out.print("How many Contact you want to Add:");
        Scanner sc = new Scanner(System.in);
     //   int number = sc.nextInt();
//        for (int i = 0; i < number; i++) {
//            System.out.println("----------------------------------\nContact : " + (i + 1) + "" +
//                    "\n----------------------------------");
            Contact contact = new Contact();
//            System.out.print("First Name : ");
//            String firstName=sc.next();

            contact.setFirstName(firstName);
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
            addressBookList.add(contact);
      //  }
        showContacts();
        System.out.println("\nadded successfully..... \n");
    }

    public int deleteContact(String firstName, String lastName) {
        System.out.println("--------------------------------------------------------" + "\nDelete Contact Details\n--------------------------------------------------------");

        for (int i = 0; i < addressBookList.size(); i++) {
            String fName = addressBookList.get(i).getFirstName();
            String lName = addressBookList.get(i).getLastName();
            if (firstName.equals(fName) && lastName.equals(lName)) {
                System.out.println("Contact found.........");
                addressBookList.remove(i);
                System.out.println("\nDelete successfully..... \n");
                return 1;
            }
        }
        System.out.println("contact not found hence deletion rejected");
        return 0;
    }

    public int editContact(String firstName) {
        System.out.println("--------------------------------------------------------" + "\nEdit Contact Details\n--------------------------------------------------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("\nsearch detail for edit.........");
        for (int i = 0; i < addressBookList.size(); i++) {
            String fName = addressBookList.get(i).getFirstName();
            if (firstName.equals(fName)) {
                System.out.println("Contact found.........");
                System.out.print("\n1. First Name\n2. Last Name\n3. Address\n" + "4. City\n5. State\n6. zip\n7. Phone Number\n8. Email\ninsert choice to edit Contact details : ");
                switch (sc.nextInt()) {
                    case FIRSTNAME:
                        System.out.print("Name : ");
                        addressBookList.get(i).setFirstName(sc.next());
                        showContacts();
                        System.out.println("\nedit successfully..... \n");
                        return 1;
                    case LASTNAME:
                        System.out.print("Last Name : ");
                        addressBookList.get(i).setLastName(sc.next());
                        showContacts();
                        System.out.println("\nedit successfully..... \n");
                        return 1;
                    case ADDRESS:
                        System.out.print("Address : ");
                        addressBookList.get(i).setAddress(sc.next());
                        showContacts();
                        System.out.println("\nedit successfully..... \n");
                        return 1;
                    case CITY:
                        System.out.print("City : ");
                        addressBookList.get(i).setCity(sc.next());
                        showContacts();
                        System.out.println("\nedit successfully..... \n");
                        return 1;
                    case STATE:
                        System.out.print("State : ");
                        addressBookList.get(i).setState(sc.next());
                        showContacts();
                        System.out.println("\nedit successfully..... \n");
                        return 1;
                    case ZIP:
                        System.out.print("zip : ");
                        addressBookList.get(i).setZip(sc.next());
                        showContacts();
                        System.out.println("\nedit successfully..... \n");
                        return 1;
                    case PHONENUMBER:
                        System.out.print("Phone Number : ");
                        addressBookList.get(i).setPhoneNumber(sc.next());
                        showContacts();
                        System.out.println("\nedit successfully..... \n");
                        return 1;
                    case EMAIL:
                        System.out.print("Email : ");
                        addressBookList.get(i).setEmail(sc.next());
                        showContacts();
                        System.out.println("\nedit successfully..... \n");
                        return 1;
                    default:
                        System.out.println("invalid input");
                }
            } else System.out.println("Contact Not available in Address Book.......");
            return 0;
        }
        return 0;
    }

    public void showContacts() {
        for (int i = 0; i < addressBookList.size(); i++) {
            System.out.println("----------------------------------\nContact : " + (i + 1) + "\n----------------------------------");
            System.out.println( addressBookList.get(i));
        }
        System.out.println("----------------------------------");
    }


    @Override
    public String toString() {
        return "\n" + addressBookList;
    }
}
