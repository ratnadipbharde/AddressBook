import java.util.*;

public class AddressBookFolder {
    private Map<String, AddressBook> addressBookMap = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    public void editAddressBook(){
        System.out.println("Enter Name : ");
        String fName=sc.next();
        Set<String> keys = addressBookMap.keySet();
        Iterator<String> it = keys.iterator();
        int count=0;
        while (it.hasNext()){
            String key=it.next();
            AddressBook addressBook=addressBookMap.get(key);
            count=addressBook.editContact(fName);
            if (count==1) {
                return;
            }
        }
    }

    public void deleteAddressBook(){
        System.out.println("Enter First Name : ");
        String fName=sc.next();
        System.out.println("Enter LAst Name : ");
        String lName=sc.next();
        Set<String> keys = addressBookMap.keySet();
        Iterator<String> it = keys.iterator();
        while (it.hasNext()){
            String key=it.next();
            AddressBook addressBook=addressBookMap.get(key);
            addressBook.deleteContact(fName,lName);
        }
    }
    public void addAddressBook() {
        System.out.println("How many Address Book you Want to create : ");
        int number = sc.nextInt();
        for (int i = 0; i < number; i++) {
            System.out.println("Enter Address Book Name : ");
            String name = sc.next();
            AddressBook addressBook = new AddressBook();
            addressBook.addContact();
            addressBookMap.put(name, addressBook);
        }
        showAddressbook();
    }

    public void showAddressbook(){
        Set<String>keys=addressBookMap.keySet();
        Iterator<String>it= keys.iterator();
        while (it.hasNext()){
            String key=it.next();
            AddressBook addressBook=addressBookMap.get(key);
            System.out.println(key+"="+addressBook);
        }
    }

    @Override
    public String toString() {
        return "AddressBookFolder{" +
                "addressBookMap=" + addressBookMap +
                '}';
    }
}
