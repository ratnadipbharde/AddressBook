import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    private ArrayList<Contact> addressBookList = new ArrayList<>();

    public void addContact() {
        System.out.println("--------------------------------------------------------" + "\nAdd Contact Details\n--------------------------------------------------------");
        Scanner sc = new Scanner(System.in);
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
        addressBookList.add(contact);
        showContacts();
        System.out.println("\nadded successfully..... \n");
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
        return "AddressBook{" + "addressBookList=" + addressBookList + '}';
    }
}
