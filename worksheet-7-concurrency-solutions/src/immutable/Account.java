package immutable;

public class Account {

    public synchronized void withdraw(double amount) {}
    public synchronized void deposit(double amount) {}

    public synchronized void transfer(Account b, double amount) {
        synchronized (b) {
            b.withdraw(amount);
            deposit(amount);
        }
    }
}
