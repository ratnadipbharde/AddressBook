import java.util.Scanner;

public class Main {
    public static final int EXIT = 0;
    public static final int SHOWALLCONTACT = 1;
    public static final int ADDCONTACT = 2;
    public static final int EDITCONTACT = 3;
    public static final int DELETECONTACT = 4;
    public static final int VIEWCONTACTBYCITYORSTATE = 5;
    public static final int VIEWANDCOUNTCONTACTBYCITYORSTATE = 6;
    public static final int WRITEADDRESSOOKMAPINFILE = 7;
    public static final int READADDRESSOOKMAPINFILE = 8;
    public static final int WRITECSVFILE = 9;
    public static final int READCSVFILE = 10;
    public static final int WRITEJSONFILE = 11;
    public static final int READJSONFILE = 12;


    public static void main(String[] args) {
        System.out.println("\t\t\tWelcome to Address Book Program\n" +
                "--------------------------------------------------------");
        AddressBookFolder addressBookFolder = new AddressBookFolder();
        Scanner sc = new Scanner(System.in);
        boolean b = true;
        while (b) {
            System.out.print("\n1. Show all contact.\n2. Add Contact.\n3. Edit Contact.\n4. Delete Contact." +
                    "\n5. View Contact By City or State.\n6. View and Count Countact by city and State \n7.Write Text File\n8.Read Text File\n9.Write Csv File\n10.Read Csv File\n11.Write Json File\n12.Read Json File");
            switch (sc.nextInt()) {
                case SHOWALLCONTACT:
                    addressBookFolder.showAddressbook();
                    break;
                case ADDCONTACT:
                    addressBookFolder.addAddressBook();
                    break;
                case EDITCONTACT:
                    addressBookFolder.editAddressBook();
                    break;
                case DELETECONTACT:
                    addressBookFolder.deleteAddressBook();
                    break;
                case VIEWCONTACTBYCITYORSTATE:
                    addressBookFolder.showAllContactByCityOrState();
                    break;
                case VIEWANDCOUNTCONTACTBYCITYORSTATE:
                    addressBookFolder.viewContactsByCityOrStateMap();
                    break;
                case WRITEADDRESSOOKMAPINFILE:
                    addressBookFolder.writeTextFile();
                    break;
                case READADDRESSOOKMAPINFILE:
                    addressBookFolder.readTextFile();
                    break;
                case WRITECSVFILE:
                    addressBookFolder.writeCsvFile();
                    break;
                case READCSVFILE:
                    addressBookFolder.readCsvFile();
                    break;
                case WRITEJSONFILE:
                    addressBookFolder.writeJsonFile();
                    break;
                case READJSONFILE:
                    addressBookFolder.readJsonFile();
                    break;
                case EXIT:
                    b = false;
                default:
                    System.out.println("invalid input....");
                    break;
            }
        }
    }
}