
//Base Class (Composition for account holder details)
class BankAccount {

 private String accountNumber;
 private String holderName;
 private double balance;

 BankAccount(String accountNumber, String holderName, double balance) {
     this.accountNumber = accountNumber;
     this.holderName = holderName;
     this.balance = balance;
 }

 // Deposit
 void deposit(double amount) {
     balance += amount;
     System.out.println(amount + " deposited successfully. New Balance: " + balance);
 }

 // Withdraw (Base Version)
 String withdraw(double amount) {
     balance -= amount;
     return "Withdrawn: " + amount + " | Available balance: " + balance;
 }

 // Getter
 double getBalance() {
     return balance;
 }

 // Print Details
 void printDetails() {
     System.out.println("Account Number: " + accountNumber);
     System.out.println("Account Holder: " + holderName);
     System.out.println("Balance: " + balance);
 }
}


//Subclass Savings Account
class SavingsAccount extends BankAccount {

 private double interestRate;  // extra property

 SavingsAccount(String accNo, String name, double balance, double interestRate) {
     super(accNo, name, balance);
     this.interestRate = interestRate;
 }

 // Override withdraw() → Prevent withdrawing more than balance
 @Override
 String withdraw(double amount) {
     if (amount > getBalance()) {
         return "Withdrawal Failed! Insufficient balance.";
     } else {
         // call base class withdrawal
         return super.withdraw(amount);
     }
 }

 // Apply interest
 void applyInterest() {
     double interest = getBalance() * (interestRate / 100);
     deposit(interest);
     System.out.println("Interest Applied: " + interest);
 }
}


//Main Class
public class Main {
 public static void main(String args[]) {

     System.out.println("----- Normal Bank Account -----");
     BankAccount b = new BankAccount("ACC101", "Mandeep Kaur", 9000);
     b.deposit(2000);
     System.out.println(b.withdraw(3000));
     b.printDetails();

     System.out.println("\n----- Savings Account -----");
     SavingsAccount s = new SavingsAccount("SAV202", "Mandeep Kaur", 10000, 5);

     s.deposit(5000);
     System.out.println(s.withdraw(20000));  // exceeds → overridden method blocks it
     System.out.println(s.withdraw(3000));   // valid

     s.applyInterest();  // interest added
     s.printDetails();   // final details
 }
}
