public class BankAccount2 {
    private double balance;
    // the lock object is now hidden from the external uses
    // better encapsulation, but impossible to add new external atomic operations
    private final Object lock = new Object();

    public void deposit(double amount) {
        synchronized (lock) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        synchronized (lock) {
            balance -= amount;
        }
    }

    public double balance() {
        synchronized (lock) {
            return balance;
        }
    }
}
