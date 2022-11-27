import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\t\t\tWelcome to Address Book Program\n" +
                "--------------------------------------------------------");
        AddressBook addressBook = new AddressBook();
        Scanner sc = new Scanner(System.in);
        int flag = 1;
        while (flag == 1) {
            System.out.print("\n1. Show all contact\n2. Add Contact\n3. Edit Contact\n0. Exit\n Enter Your Choice:");
            switch (sc.next()) {
                case "1":
                    addressBook.showContacts();
                    flag = 1;
                    break;
                case "2":
                    addressBook.addContact();
                    flag = 1;
                    break;
                case "3":
                    addressBook.editContact();
                    flag = 1;
                    break;
                case "0":
                    flag = 0;
                    break;
                default:
                    System.out.println("invalid input....");
                    flag = 1;
            }
        }
    }
}