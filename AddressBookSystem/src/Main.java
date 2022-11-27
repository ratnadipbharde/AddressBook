import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\t\t\tWelcome to Address Book Program\n" +
                "--------------------------------------------------------");
        Contact contact = new Contact();
        Scanner sc = new Scanner(System.in);
        System.out.println("First Name : ");
        contact.setFirstName(sc.next());
        System.out.println("Last Name : ");
        contact.setLastName(sc.next());
        System.out.println("Address : ");
        contact.setAddress(sc.next());
        System.out.println("City : ");
        contact.setCity(sc.next());
        System.out.println("State : ");
        contact.setState(sc.next());
        System.out.println("zip : ");
        contact.setZip(sc.next());
        System.out.println("Phone Number : ");
        contact.setPhoneNumber(sc.next());
        System.out.println("Email : ");
        contact.setEmail(sc.next());
        System.out.println(contact);
    }
}