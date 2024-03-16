public class ProducerConsumer {
    private String placeholder;

    // READ THIS CODE AND FIND A BUG (OR TWO)

    // runs in "sender" threads
    public void send(String message) throws InterruptedException {
        synchronized (this) {
            if (placeholder != null)
                wait(); // wait needs to be called from the synchronized block
                        // (on the same object!)
            placeholder = message;
            notifyAll(); // notify and notifyAll also need to be called
                         // from the synchronized block
        }
    }
    // runs in receiver threads
    public String receive() throws InterruptedException {
        synchronized (this) {
            if (placeholder == null)
                wait();
            String message = placeholder;
            placeholder = null;
            notifyAll();
            return message;
        }
    }
}
