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
    static final int CITY = 1;
    static final int STATE = 2;

    private Map<String, AddressBook> addressBookMap = new HashMap<>();
    private Map<String, List<Contact>> cityContactMap = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    final static String filePathForTxt = "addressbook.txt";
    final static String filePathForCsv = "addressbook.csv";
    final static String filePathForJson = "addressbook.json";
    public void readJsonFile() {
        Gson gson = new Gson();
        try (Reader reader = Files.newBufferedReader(Paths.get(filePathForJson))) {
            HashMap map = gson.fromJson(reader, HashMap.class);
            map.forEach((s, addressBook) -> System.out.println(s + "=" + addressBook));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeJsonFile() {
        try (Writer writer = new FileWriter(filePathForJson)) {
            new Gson().toJson(addressBookMap, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readCsvFile() {
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(filePathForCsv));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                for (String token : nextLine) {
                    System.out.print(token + " , ");
                }
                System.out.print("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            assert reader != null;
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeCsvFile() {
        File file = new File(filePathForCsv);
        try {
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);
            String[] header = {"Address-book Name", "First Name", "Last Name", "Address", "City", "State", "Zip", "Phone Number", "Email"};
            writer.writeNext(header);
            for (String key : addressBookMap.keySet()) {
                AddressBook addressBook = addressBookMap.get(key);
                addressBook.getAddressBookList().forEach(contact -> {
                    String[] data = {key, contact.getFirstName(), contact.getLastName(), contact.getAddress(), contact.getCity(), contact.getState(), contact.getZip(), contact.getPhoneNumber(), contact.getEmail()};
                    writer.writeNext(data);
                });
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readTextFile() {
        File file = new File(filePathForTxt);
        FileReader fr;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader br = new BufferedReader(fr);
        String line;
        while (true) {
            try {
                if ((line = br.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(line);
        }
    }

    public void writeTextFile() {
        File addressbookFileCreate = new File(filePathForTxt);
        try {
            if (addressbookFileCreate.createNewFile()) {
                System.out.println("file is created...");
            } else {
                System.out.println("File already exists...");
            }
        } catch (IOException e) {
            System.out.println("File not create....");
            throw new RuntimeException(e);
        }
        File file = new File(filePathForTxt);
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
                bf.write(entry.getKey() + ":" + entry.getValue());
                bf.newLine();
            }
            bf.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bf.close();
            } catch (Exception e) {
            }
        }
    }

    public void getNumberOfCountPersonByCityOrState() {
        System.out.print("1. City \n2. State\n\nChoose option for show contact by city or state : ");
        int item = sc.nextInt();
        if (item == CITY) {
            System.out.println("enter Name of City : ");
        }
        if (item == STATE) {
            System.out.println("enter Name of State : ");
        }
        String itemName = sc.next();
        long count=0;
        for (AddressBook addressBook : addressBookMap.values()) {
            count = addressBook.getAddressBookList()
                    .stream()
                    .filter(predicateForCityOrState(item, itemName))
                    .count();
        }
        System.out.println("count is : "+count);
    }

    public void viewContactsByCityOrStateMap() {
        System.out.println("1. City \n2. State\n\nChoose option for view contacts :");
        int choice = sc.nextInt();
        cityContactMap = addressBookMap.values()
                .stream()
                .flatMap(addressBook -> addressBook.getAddressBookList().stream())
                .collect(getcCityOrStateContactCollector(choice));
        cityContactMap.forEach((key, contacts) -> System.out.println("Contacts of '" + key + "' City : " + contacts + ""));
    }

    private Collector<Contact, ?, Map<String, List<Contact>>> getcCityOrStateContactCollector(int choice) {
        if (choice == CITY) {
            return Collectors.groupingBy(contact -> contact.getCity());
        }
        if (choice == STATE) {
            return Collectors.groupingBy(contact -> contact.getState());
        }
        return null;
    }

    public void showAllContactByCityOrState() {
        System.out.print("1. City \n2. State\n\nChoose option for show contact by city or state : ");
        int item = sc.nextInt();
        if (item == CITY) {
            System.out.println("enter Name of City : ");
        }
        if (item == STATE) {
            System.out.println("enter Name of State : ");
        } else {
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