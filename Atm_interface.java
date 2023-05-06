import java.util.ArrayList;
import java.util.Scanner;

public class Atm_interface {
        public static Scanner sc = new Scanner(System.in);
        public static ArrayList<String> list = new ArrayList<>();

        
        public static void transac(int balance) {
            for (String i : list) {
                System.out.println(i);
            }
            ask(balance);
        }


        public static void login(String username, int pin) {
            if (username.contains("Esha") && pin == 0007) {
                list.add("Logged in");
                ask(50000);
            } else {
                System.out.println("------------------------------------------");
                System.out.println("Invlid Username Or Password \nPlease Enter valid Information" );
                System.out.println("------------------------------------------");
                login(sc.next(), sc.nextInt());
            
            }
        }


        public static void withdraw(int balance, int amount) {
            if (amount <= balance && amount >= 0) {
                balance = balance - amount;
                System.out.println();
                System.out.println("Transaction successful \nCurrent balance is " + balance);
                list.add("Rupee's " + amount + " withdrawn.");
                ask(balance);
            } else {
                System.out.print("Enter a valid amount(greater than equal to zero): ");
                withdraw(balance, sc.nextInt());
            }
        }

       
        public static void deposit(int balance, int amount) {
            if (amount >= 0) {
                balance =balance + amount;
                System.out.println();
                System.out.println("Transaction Successful \nCurrent Balance is " + balance);
                list.add(amount + " Rupee/'s deposited!");
                ask(balance);
            } else {
                System.out.print("Enter a valid Amount(Greater than equal to zero): ");
                deposit(balance, sc.nextInt());
            }
        }


        public static void transfer(int balance, int amount) {
            if ((amount <= balance) && (amount >= 0)) {
                System.out.print("Enter Receiver's Username: ");
                String accname = sc.next();
                balance = balance - amount;
                System.out.println();
                System.out.println(amount + " Rupee's sent to " + accname);
                System.out.println();
                System.out.println("Transaction Successful \nCurrent Balance is " + balance);
                list.add(amount + " Transferred to Account " + accname);
                ask(balance);
            } else {
                System.out.print("Enter a valid amount(greater than equal to zero): ");
                transfer(balance, sc.nextInt());
            }
        }

        
        public static void quit(int balance, char qresponse) {
            if (qresponse == 'y' || qresponse == 'Y') {
                System.out.println("----------------------------------------");
                System.out.println("Thanks For Banking with us.");
                System.out.println("SUCCESSFULLY LOGGED OUT!!");
                System.out.println("----------------------------------------");
                System.out.println();
            } else
                ask(balance);
        }


        public static void ask(int bal) {
            System.out.println("----------------------------------------");
            System.out.println();
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.println();
            System.out.println("------------------------------------------");
            System.out.println("Choose one of the following actions : ");
            int opt = sc.nextInt();
            System.out.println("------------------------------------------");
            System.out.println();
            if (1 > opt || opt > 5) {
                System.out.println("Enter valid input!");
                ask(bal);
            } else {
                switch (opt) {
                    case 1:
                        System.out.println("--------------------------------");
                        System.out.println("Transaction History!");
                        transac(bal);
                        System.out.println("--------------------------------");
                        break;

                    case 2:
                        System.out.print("Enter amount to be withdrawn : ");
                        withdraw(bal, sc.nextInt());
                        
                        break;

                    case 3:
                        System.out.print("Enter amount to be deposited : ");
                        deposit(bal, sc.nextInt());
                        System.out.println();
                        break;

                    case 4:
                        System.out.print("Enter amount to be transfered : ");
                        transfer(bal, sc.nextInt());
                        System.out.println();
                        break;

                    case 5:
                        System.out.print("Do you want to Exit? (Yes/No) : ");
                        char qresponse = sc.next().charAt(0);
                        quit(bal, qresponse);
                        break;
                }
            }
        }

        public static void main(String[] args) {
            System.out.println();
            System.out.println("------------------------------------------");
            System.out.println("Please Enter Your Login Details!!");
            System.out.println("------------------------------------------");
            System.out.print("Enter User Name: ");
            String username = sc.next();
            System.out.print("Enter Pin: ");
            int pin = sc.nextInt();
            login(username, pin);
        }
    }



