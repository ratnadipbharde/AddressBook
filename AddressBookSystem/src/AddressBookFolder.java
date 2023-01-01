import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class AddressBookFolder {
    static final int EXISTINGADDRESSBOOK = 1;
    static final int NEWADDRESSBOOK = 2;
    static final int CITY=1;
    static final int STATE=2;

    private Map<String, AddressBook> addressBookMap = new HashMap<>();
    private Map<String, List<Contact>> cityContactMap = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    public void viewContactsByCityOrStateMap() {
        System.out.println("1. City \n2. State\n\nChoose option for view contacts :");
        int choice=sc.nextInt();
        cityContactMap = addressBookMap.values()
                .stream()
                .flatMap(addressBook -> addressBook.getAddressBookList().stream())
                .collect(getcCityOrStateContactCollector(choice));
        cityContactMap.forEach((key, contacts) -> System.out.println("Contacts of '" + key + "' City : " + contacts + ""));
    }

    private Collector<Contact, ?, Map<String, List<Contact>>> getcCityOrStateContactCollector(int choice) {
        if (choice==CITY){
           return Collectors.groupingBy(contact -> contact.getCity());
        }if (choice==STATE){
            return Collectors.groupingBy(contact -> contact.getState());
        }
       return null;
    }

    public void showAllContactByCityOrState() {
        System.out.print("1. City \n2. State\n\nChoose option for show contact by city or state : ");
        int item = sc.nextInt();
        if (item == CITY) {
            System.out.println("enter Name of City : ");
        } if (item == STATE) {
            System.out.println("enter Name of State : ");
        }
        else {
            System.out.println("invalid input");
        }
        String itemName = sc.next();
        for (AddressBook addressBook : addressBookMap.values()) {//**
            addressBook.getAddressBookList()
                    .stream()
                    .filter(predicateForCityOrState(item, itemName))
                    .forEach(contact -> System.out.println(contact));
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
        addressBookMap.values().forEach(addressBook -> addressBook.editContact(fName));
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
                System.out.println("how many addressbook create : ");
                int numberOfBook = sc.nextInt();
                for (int i = 0; i < numberOfBook; i++) {
                    System.out.print("Enter New Address Book Name  : ");
                    String name = sc.next();
                    System.out.println("How many contacts : ");
                    int numberOfContacts = sc.nextInt();
                    for (int j = 0; i < numberOfContacts; i++) {
                        System.out.print("First Name : ");
                        firstName = sc.next();
                        if (contactIsExist(firstName)) {
                            i--;
                            break;
                        } else {
                            AddressBook addressBook = new AddressBook();
                            addressBook.addContact(firstName);
                            addressBookMap.put(name, addressBook);
                        }
                    }
                }
            default:
                System.out.println("invallid input");
                break;
        }
    }

    public boolean contactIsExist(String firstName) {
        boolean result = false;
        for (AddressBook addressBook : addressBookMap.values()) {
            result = addressBook.getAddressBookList().stream().anyMatch(contact -> contact.getFirstName().equals(firstName));
        }
        if (result == true)
            System.out.println("Contact already exist...");
        return result;
    }

    public void showAddressbook() {
        addressBookMap.values()
                .forEach(AddressBook::showContacts);
    }
}