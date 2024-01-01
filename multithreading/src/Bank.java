import java.util.HashMap;
import java.util.Map;

class Bank {
    private Map<Integer, Integer> accounts = new HashMap<>();

    public synchronized void deposit(int accountNumber, int amount) {
        int currentBalance = accounts.getOrDefault(accountNumber, 0);
        accounts.put(accountNumber, currentBalance + amount);
        System.out.println("Deposited Rs. " + amount + " into account " + accountNumber);
    }

    public synchronized void withdraw(int accountNumber, int amount) {
        int currentBalance = accounts.getOrDefault(accountNumber, 0);
        if (currentBalance >= amount) {
            accounts.put(accountNumber, currentBalance - amount);
            System.out.println("Withdrawn Rs. " + amount + " from account " + accountNumber);
        } else {
            System.out.println("Insufficient funds in account " + accountNumber);
        }
    }

    public synchronized int getBalance(int accountNumber) {
        return accounts.getOrDefault(accountNumber, 0);
    }
}