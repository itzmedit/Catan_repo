// java.util package
import java.util.Scanner;

// BankAccount class
public class BankAccount {
    // Attributes
    int accountNumber;
    String accountName;
    double balance;
     
    // Default constructor
    public BankAccount(int _accountNumber, String _accountName) {
        accountNumber = _accountNumber;
        accountName = _accountName;
        balance = 0;
    }

    // deposit method
    public void deposit() {
        Scanner scan = new Scanner(System.in);
        System.out.println("----------------------------------------");
        System.out.println("\tDEPOSIT");
        System.out.println("----------------------------------------");
        System.out.print("Enter the amount to deposit (PHP): ");
        double deposit = scan.nextDouble();
        balance += deposit;
        System.out.println("----------------------------------------");
        System.out.println("\nYou successfully deposited PHP" + deposit + " to your account.");
    }
    
    // withdraw method
    public void withdraw() {
        Scanner scan = new Scanner(System.in);
        System.out.println("----------------------------------------");
        System.out.println("\tWITHDRAW");
        System.out.println("----------------------------------------");
        System.out.print("Enter the amount to withdraw (PHP): ");
        double withdraw = scan.nextDouble();
        balance -= withdraw;
        System.out.println("----------------------------------------");
        System.out.println("\nYou successfully withdrawn PHP" + withdraw + " from your account.");
    }

    // displayBalance method
    public void displayBalance(){
        System.out.println("----------------------------------------");
        System.out.println("\tDISPLAY BALANCE");
        System.out.println("----------------------------------------");
        System.out.println("Balance: PHP" + balance);
        System.out.print("----------------------------------------");
    }

    // main method
    static public void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("----------------------------------------");
        System.out.println("\tBANK ACCOUNT");
        System.out.println("----------------------------------------");
        System.out.print("Enter your Account Number: ");
        int _accountNumber = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter your Account Name: ");
        String _accountName = scan.nextLine();
        System.out.println("----------------------------------------");
         
        BankAccount p1 = new BankAccount(_accountNumber, _accountName); 
        
        int ask = 1;
        while (ask != 0) {
            System.out.println("----------------------------------------");
            System.out.println("\tBANK ACCOUNT");
            System.out.println("----------------------------------------");
            System.out.println("Account Number: " + p1.accountNumber);
            System.out.println("Account Name: " + p1.accountName);
            System.out.println("----------------------------------------");
            System.out.println("Choose an option below: ");
            System.out.println("----------------------------------------");
            System.out.println("[1] DEPOSIT \n[2] WITHDRAW \n[3] DISPLAY BALANCE \n[0] CANCEL \n----------------------------------------");
            int num = scan.nextInt();

            switch(num) {
                case 1:
                    p1.deposit();
                    break;

                case 2:
                    p1.withdraw();
                    break;

                case 3:
                    p1.displayBalance();
                    break;

                case 0: 
                    System.out.println("\nTransaction Cancelled.");
            }
            
            System.out.println("\n----------------------------------------");
            System.out.println("Do you want to continue? \n----------------------------------------");
            System.out.println("[1] Yes \n[0] No \n----------------------------------------");
            ask = scan.nextInt();
        }
    
        System.out.println("----------------------------------------"); 
        System.out.println("\tTHANK YOU!");
        System.out.println("----------------------------------------");
    }
}