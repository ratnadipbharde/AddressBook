import java.util.Scanner;

public class Main {
    public static final String EXIT ="0";
    public static final String SHOWALLCONTACT="1";
    public static final String ADDCONTACT="2";
    public static final String EDITCONTACT="3";
    public static final String DELETECONTACT ="4";

    public static void main(String[] args) {
        System.out.println("\t\t\tWelcome to Address Book Program\n" +
                "--------------------------------------------------------");
        AddressBook addressBook = new AddressBook();
        AddressBookFolder addressBookFolder=new AddressBookFolder();
        Scanner sc = new Scanner(System.in);
        int flag = 1;
        while (flag == 1) {
            System.out.print("\n1. Show all contact\n2. Add Contact\n3. Edit Contact\n4. Delete Contact\n0. Exit\n Enter Your Choice:");
            switch (sc.next()) {
                case SHOWALLCONTACT:
                    addressBook.showContacts();
                    flag = 1;
                    break;
                case ADDCONTACT:
                    addressBookFolder.addAddressBook();
                    flag = 1;
                    break;
                case EDITCONTACT:
                    addressBook.editContact();
                    flag = 1;
                    break;
                case DELETECONTACT:
                    addressBook.deleteContact();
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