// Facade_Pattern 
   
/*
📘 Scenario

An Online Banking System needs multiple services to complete a transaction:

Account Check

Balance Check

Transaction Processing

Facade provides a single method for user.
*/

class AccountService {
    void verifyAccount() {
        System.out.println("Account verified");
    }
}

class BalanceService {
    void checkBalance() {
        System.out.println("Balance sufficient");
    }
}

class TransactionService {
    void makeTransaction() {
        System.out.println("Transaction successful");
    }
}

// Facade
class BankFacade {
    AccountService account = new AccountService();
    BalanceService balance = new BalanceService();
    TransactionService transaction = new TransactionService();

    void withdrawMoney() {
        account.verifyAccount();
        balance.checkBalance();
        transaction.makeTransaction();
    }
}

// Client
public class Facade_Pattern  {
    public static void main(String[] args) {
        BankFacade bank = new BankFacade();
        bank.withdrawMoney();
    }
}
