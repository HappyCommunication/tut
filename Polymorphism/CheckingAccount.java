public class CheckingAccount extends BankAccount {

    float amtInterest;
    float applyInterest;
    String displayBalance;

    public CheckingAccount() {
    }

    public CheckingAccount(String firstName, String lastName, String ssn, float balance) {
        super(firstName, lastName, ssn, balance);
        System.out.println("Successfully created account for " + firstName + " " + lastName + " " + accountNumber);
        System.out.println(firstName + " " + lastName + ", Balance $" + balance);
    }    

    float applyInterest () {
       if (balance <= 10000) {
           balance = balance * 0.1f;  
           }
       if (balance > 10000) {
           balance = 1000 + (balance * 0.02f);
       }
       return balance;
    }

    float displayBalance() {
        return balance;
    }
}
