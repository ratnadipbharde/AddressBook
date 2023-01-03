import java.util.Scanner;

public class Main {
    public static final int EXIT = 0;
    public static final int SHOWALLCONTACT = 1;
    public static final int ADDCONTACT = 2;
    public static final int EDITCONTACT = 3;
    public static final int DELETECONTACT = 4;
    public static final int SHOWCONTACTBYCITYORSTATE = 5;
    public static final int VIEWCONTACTBYCITYORSTATEWICE = 6;
    public static final int COUNTCONTACTBYCITYORSTATE=7;
    public static final int WRITEADDRESSOOKMAPINFILE = 8;
    public static final int READADDRESSOOKMAPINFILE = 9;
    public static final int WRITECSVFILE = 10;
    public static final int READCSVFILE = 11;
    public static final int WRITEJSONFILE = 12;
    public static final int READJSONFILE = 13;



    public static void main(String[] args) {
        System.out.println("\t\t\tWelcome to Address Book Program\n" +
                "--------------------------------------------------------");
        AddressBookFolder addressBookFolder = new AddressBookFolder();
        Scanner sc = new Scanner(System.in);
        boolean b = true;
        while (b) {
            System.out.print("\n1. Show all contact.\n2. Add Contact.\n3. Edit Contact.\n4. Delete Contact." +
                    "\n5. View Contact By City or State.\n6. View Countact by city and State\n7. count contact by city or state " +
                    "\n8.Write Text File\n9.Read Text File\n10.Write Csv File\n11.Read Csv File\n12.Write Json File\n13.Read Json File\n");
            System.out.println("\nEnter Your Choice : ");
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
                case SHOWCONTACTBYCITYORSTATE:
                    addressBookFolder.showAllContactByCityOrState();
                    break;
                case VIEWCONTACTBYCITYORSTATEWICE:
                    addressBookFolder.viewContactsByCityOrStateMap();
                    break;
                case COUNTCONTACTBYCITYORSTATE:
                    addressBookFolder.getNumberOfCountPersonByCityOrState();
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