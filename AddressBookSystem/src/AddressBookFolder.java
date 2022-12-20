import java.util.*;
import java.util.function.Predicate;

public class AddressBookFolder {
    static final int EXISTINGADDRESSBOOK = 1;
    static final int NEWADDRESSBOOK = 2;
    private Map<String, AddressBook> addressBookMap = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    public void showAllContactByCityOrState() {
        System.out.print("1. City \n2. State\n\nChoose option for search : ");
        int item = sc.nextInt();
        if (item == 1) {
            System.out.println("enter Name of City : ");
        } else {
            System.out.println("enter Name of State : ");
        }
        String itemName = sc.next();
        for (AddressBook addressBook : addressBookMap.values()) {
            addressBook.getAddressBookList().stream().filter(predicateForCityOrState(item, itemName)).forEach(System.out::println);
        }
    }

    private Predicate<Contact> predicateForCityOrState(int item, String itemName) {
        if (item == 1) {
            return contact -> contact.getCity().equals(itemName);
        } else {
            return contact -> contact.getState().equals(itemName);
        }
    }

    public void editAddressBook() {
        System.out.println("Enter Name : ");
        String fName = sc.next();
        addressBookMap.values().forEach(addressBook -> {
                addressBook.editContact(fName);
        });
    }

    public void deleteAddressBook() {
        System.out.println("Enter First Name : ");
        String fName = sc.next();
        System.out.println("Enter LAst Name : ");
        String lName = sc.next();
        addressBookMap.values().forEach(addressBook -> addressBook.deleteContact(fName, lName));
    }

    public void addAddressBook() {
        Set<String> keys = addressBookMap.keySet();
        System.out.println("\n--------------------------\nEXISTING ADDRESSBOOKS ");
        System.out.println("--------------------------\n" + keys + "\n--------------------------\n");
        int number;
        if (keys.size() > 0) {
            System.out.println(" 1. Use existing address book\n 2. Create new address book\n");
            System.out.print("Please Enter your Choice : ");
            number = sc.nextInt();
        } else {
            System.out.println("No existing Address-book is available");
            number = 2;
        }

        String firstName;
        switch (number) {
            case EXISTINGADDRESSBOOK:
                System.out.println("Enter existing Address Book Name   : ");
                String bookName = sc.next();
                System.out.print("First Name : ");
                firstName = sc.next();
                if (contactIsExist(firstName)) {
                    return;
                }
                AddressBook addressBook1 = addressBookMap.get(bookName);
                addressBook1.addContact(firstName);

                break;
            case NEWADDRESSBOOK:
                System.out.print("Enter New Address Book Name  : ");
                String name = sc.next();
                System.out.print("First Name : ");
                firstName = sc.next();
                if (contactIsExist(firstName)) {
                    return;
                } else {
                    AddressBook addressBook = new AddressBook();
                    addressBook.addContact(firstName);
                    addressBookMap.put(name, addressBook);
                }
            default:
                System.out.println("invallid input");
                break;
        }
    }

    public boolean contactIsExist(String firstName) {
        for (AddressBook addressBook : addressBookMap.values()) {
            System.out.println("Contact already exist...");
            return addressBook.getAddressBookList().stream().anyMatch(contact -> contact.getFirstName().equals(firstName));
        }
        return false;
    }

    public void showAddressbook() {
        addressBookMap.values()
                .forEach(AddressBook::showContacts);
    }
}