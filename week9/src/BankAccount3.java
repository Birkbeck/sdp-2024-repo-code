import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount3 {
    private double balance;
    private final Lock lock = new ReentrantLock();

    public void deposit(double amount) {
        // synchronized (lock) would use the intrinsic lock,
        //            not the ReentrantLock object from Java 5

        lock.lock(); // interface Lock is more flexible
                    // and provides more functionality compared to intrinsic lock
        try {
            balance += amount;
        }
        finally { // not needed in this simple example (as no exceptions can be thrown)
            lock.unlock();
        }
    }

    public void withdraw(double amount) {
        lock.lock();
        try {
            balance -= amount;
        }
        finally {
            lock.unlock();
        }
    }

    public double balance() {
        lock.lock();
        try {
            return balance;
        }
        finally {
            lock.unlock();
        }
    }
}
