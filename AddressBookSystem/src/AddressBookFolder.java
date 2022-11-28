import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookFolder {
    private Map<String, AddressBook> addressBookMap = new HashMap<>();
    AddressBook addressBook = new AddressBook();

    public void addAddressBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many Address Book you Want to create : ");
        int number = sc.nextInt();
        for (int i = 0; i < number; i++) {
            System.out.println("Enter Address Book Name : ");
            String name = sc.next();
            addressBook.addContact();
            addressBookMap.put(name, addressBook);
        }
        System.out.println(addressBookMap);
    }

    @Override
    public String toString() {
        return "AddressBookFolder" +
                "addressBookMap=" + addressBookMap +
                ", addressBook=" + addressBook ;
    }
}
