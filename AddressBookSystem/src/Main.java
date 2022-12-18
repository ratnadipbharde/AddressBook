import java.util.Scanner;

public class Main {
    public static final int EXIT = 0;
    public static final int SHOWALLCONTACT= 1;
    public static final int ADDCONTACT= 2;
    public static final int EDITCONTACT= 3;
    public static final int DELETECONTACT = 4;
    public static final int CONTACTBYCITY = 5;
    public static final int CONTACTBYSTATE = 6;


    public static void main(String[] args) {
        System.out.println("\t\t\tWelcome to Address Book Program\n" +
                "--------------------------------------------------------");
        AddressBookFolder addressBookFolder=new AddressBookFolder();
        Scanner sc = new Scanner(System.in);
        int flag = 1;
        while (flag == 1) {
            System.out.print("\n1. Show all contact\n2. Add Contact\n3. Edit Contact\n4. Delete Contact\n5. Show All Contact By City\n0. Exit\n Enter Your Choice:");
            switch (sc.nextInt()) {
                case SHOWALLCONTACT:
                    addressBookFolder.showAddressbook();
                    flag = 1;
                    break;
                case ADDCONTACT:
                    addressBookFolder.addAddressBook();
                    flag = 1;
                    break;
                case EDITCONTACT:
                    addressBookFolder.editAddressBook();
                    flag = 1;
                    break;
                case DELETECONTACT:
                    addressBookFolder.deleteAddressBook();
                    flag = 1;
                    break;
                    case CONTACTBYCITY:
                    addressBookFolder.showAllContactByCity();
                    flag = 1;
                    break;
                case CONTACTBYSTATE:
                    addressBookFolder.showAllContactByState();
                    flag = 1;
                    break;
                case EXIT:
                    flag = 0;
                    break;
                default:
                    System.out.println("invalid input....");
                    flag = 1;
            }
        }
    }
}