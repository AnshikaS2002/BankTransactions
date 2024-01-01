public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Created 4 customers, each with 2 accounts
        Customer[] customers = new Customer[4];
        for (int i = 0; i < 4; i++) {
            customers[i] = new Customer(bank);
            customers[i].start();
        }

        for (Customer customer : customers) {
            try {
                customer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 1; i <= 8; i++) {
            System.out.println("Balance in account " + i + ": " + bank.getBalance(i));
        }
    }
}
