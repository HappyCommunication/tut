public class BankApp {
    public static void main(String[] args) {
        CheckingAccount acct1 = new CheckingAccount("Alin", "Parker", "123-45-6789", 1000.0f);

        CheckingAccount acct2 = new CheckingAccount("Mary", "Jones", "987-65-4321", 500.0f);

        SavingsAccount acct3 = new SavingsAccount("John", "Smith", "1233-45-6789", 200.0f);

        acct1.deposit(22000.00f);
        acct2.deposit(12000.00f);


        acct1.withdraw(2000.00f);
        acct2.withdraw(1000.00f);

        acct1.applyInterest(); //seems to skip
        acct2.applyInterest(); //seems to skip

        acct1.displayBalance(); //seems to skip
        acct2.displayBalance(); //seems to skip

        acct1.withdraw(30000.00f);
    }
}
