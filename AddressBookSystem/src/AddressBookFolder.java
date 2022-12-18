import java.util.*;
import java.util.stream.Collectors;

public class AddressBookFolder {
    static final int EXISTINGADDRESSBOOK = 1;
    static final int NEWADDRESSBOOK = 2;
    private Map<String, AddressBook> addressBookMap = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    public void showAllContactByState(){
        System.out.print("Enter State name :");
        String stateName = sc.next();
        Set<String> keys = addressBookMap.keySet();
        isExistForContact(keys);
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            AddressBook addressBook = addressBookMap.get(key);
            List<Contact> collect = addressBook.getAddressBookList().stream().filter(contact -> Objects.equals(contact.getState(), stateName)).collect(Collectors.toList());
            System.out.println(collect);
        }
    }

    public void showAllContactByCity() {
        System.out.print("Enter City name :");
        String cityName = sc.next();
        Set<String> keys = addressBookMap.keySet();
        isExistForContact(keys);
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            AddressBook addressBook = addressBookMap.get(key);
            List<Contact> collect = addressBook.getAddressBookList().stream().filter(contact -> Objects.equals(contact.getCity(), cityName)).collect(Collectors.toList());
            System.out.println(collect);
        }
    }
    public void editAddressBook() {
        System.out.println("Enter Name : ");
        String fName = sc.next();
        Set<String> keys = addressBookMap.keySet();
        Iterator<String> it = keys.iterator();
        int count = 0;
        while (it.hasNext()) {
            String key = it.next();
            AddressBook addressBook = addressBookMap.get(key);
            count = addressBook.editContact(fName);
            if (count == 1) {
                return;
            }
        }
    }

    public void deleteAddressBook() {
        System.out.println("Enter First Name : ");
        String fName = sc.next();
        System.out.println("Enter LAst Name : ");
        String lName = sc.next();
        Set<String> keys = addressBookMap.keySet();
        Iterator<String> it = keys.iterator();
        int count = 0;
        while (it.hasNext()) {
            String key = it.next();
            AddressBook addressBook = addressBookMap.get(key);
            count = addressBook.deleteContact(fName, lName);
            if (count == 1) {
                return;
            }
        }
    }

    public void addAddressBook() {
        Set<String> keys = addressBookMap.keySet();
        System.out.println("\n--------------------------\nEXISTING ADDRESSBOOKS ");
        System.out.println("--------------------------\n" + keys + "\n--------------------------\n");
        if (keys.size() > 0) {
            System.out.println(" 1. Use existing addressbook\n 2. Create new addressbook");
        } else {
            System.out.println(" 2. Create new addressbook");
        }
        System.out.print("Please Enter your Choice : ");
        String firstName;
        switch (sc.nextInt()) {
            case EXISTINGADDRESSBOOK:
                System.out.println("Enter existing Address Book Name   : ");
                String bookName = sc.next();
                System.out.print("First Name : ");
                firstName = sc.next();
                if (isExistForName(firstName)) {
                    System.out.println("already exixt");
                    return;
                }
                for (String key : keys) {
                    if (key.equals(bookName)) {
                        AddressBook addressBook = addressBookMap.get(key);
                        addressBook.addContact(firstName);
                        addressBookMap.put(key, addressBook);
                        return;
                    }
                }
                break;
            case NEWADDRESSBOOK:
                System.out.print("Enter New Address Book Name  : ");
                String name = sc.next();
                System.out.print("First Name : ");
                firstName = sc.next();
                if (isExistForName(firstName)) {
                    System.out.println("already exixt");
                } else {
                    AddressBook addressBook = new AddressBook();
                    addressBook.addContact(firstName);
                    addressBookMap.put(name, addressBook);
                }
        }
    }

    public boolean isExistForName(String firstName) {
        Set<String> keys = addressBookMap.keySet();
        for (String key : keys) {
            AddressBook addressBook1 = addressBookMap.get(key);
            List<Contact> collect = addressBook1.getAddressBookList().stream().filter(contact -> Objects.equals(contact.getLastName(), firstName)).collect(Collectors.toList());
            if (collect.size() > 0) {
                System.out.println(collect);
                return true;
            }
        }
        return false;
    }
    
    public void isExistForContact(Set<String> keyes){
        if (keyes.size()==0){
            System.out.println("contact not found or addressbook is empty");
        }
        else {
            System.out.println("contact found");
        }
    }

    public void showAddressbook() {
        Set<String> keys = addressBookMap.keySet();
        if (keys.size() == 0) {
            System.out.println("\n------------ Empty ------------");
        }
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            AddressBook addressBook = addressBookMap.get(key);
            System.out.println("\n************************* " + key + " *************************");
            addressBook.showContacts();
        }
    }
}