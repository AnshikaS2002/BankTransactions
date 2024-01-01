class Customer extends Thread {
    private static int customerCount = 0;
    private int customerId;
    private Bank bank;

    public Customer(Bank bank) {
        this.bank = bank;
        this.customerId = ++customerCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            int accountNumber = customerId * 2 - 1; // First account for customer
            int amount = (int) (Math.random() * 100) + 1;
            bank.deposit(accountNumber, amount);
            amount = (int) (Math.random() * 100) + 1;
            bank.withdraw(accountNumber, amount);

            accountNumber = customerId * 2; // Second account for customer
            amount = (int) (Math.random() * 100) + 1;
            bank.deposit(accountNumber, amount);
            amount = (int) (Math.random() * 100) + 1;
            bank.withdraw(accountNumber, amount);

            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
