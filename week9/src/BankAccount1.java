public class BankAccount1 {
    private double balance;

    public synchronized void deposit(double amount) {
            balance += amount;
    }

    public synchronized void withdraw(double amount) {
        balance -= amount;
    }

    public synchronized double balance() {
        return balance;
    }

    public static void transfer(BankAccount1 a1, BankAccount1 a2, double amount) {
        synchronized (a1) { // this can cause deadlock
            synchronized (a2) { // deadlocks can be avoided by obtaining a lock on the "smaller" bank account first
                a1.withdraw(amount);
                a2.deposit(amount);
            }
        }
    }
}
