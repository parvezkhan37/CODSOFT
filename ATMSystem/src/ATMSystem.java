import java.util.Scanner;

class ATM{
    float balance=9846;
    int PIN = 2580;
    public void checkPin() {
        System.out.println("Enter your pin: ");
        Scanner sc = new Scanner(System.in);
        int enteredPin = sc.nextInt();

        if (enteredPin == PIN) {
            menu();
        } else {
            System.out.println("Enter a valid PIN");
        }
    }
        public void menu(){
            System.out.println("Enter your choice");
            System.out.println("1.Check account balance");
            System.out.println("2.Withdraw money");
            System.out.println("3.Deposite money");
            System.out.println("4.EXIT");
            Scanner sc = new Scanner(System.in);
            int opt = sc.nextInt();

            if(opt==1){
                checkBalance();
            } else if (opt==2) {
                withdrawMoney();
            } else if (opt==3) {
                depositMoney();
            } else if (opt==4) {
                return;
            }else{
                System.out.println("Enter a valid choice.");
            }
        }
        public void checkBalance(){
            System.out.println("Balance: "+balance);
            menu();
        }
        public void withdrawMoney(){
            System.out.println("Enter your amount: ");
            Scanner sc = new Scanner(System.in);
            float amount = sc.nextFloat();
            if(amount>balance){
                System.out.println("Insufficient balance");
            }else{
                balance = balance-amount;
                System.out.println("Your withdrawal is successful");
            }
            menu();
        }
        public void depositMoney(){
            System.out.println("Enter the amount: ");
            Scanner sc = new Scanner(System.in);
            float amount = sc.nextFloat();
            balance = balance+amount;
            System.out.println("Your deposit is successful");
            menu();
        }
    }
public class ATMSystem {
    public static void main(String[] args) {
        ATM obj = new ATM();
        obj.checkPin();
    }
}