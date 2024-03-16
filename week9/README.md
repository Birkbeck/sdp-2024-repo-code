# Java Concurrency

**Java 1 (1996)**: multi-threaded GUI, most CPUs have one core:
- `new Thread()` and `Runnable`;
- low-level primitives: `volatile`, intrinsic locks aka `synchronized`, intrinsic queues aka `wait`/`notify`/`notifyAll`.

**Java 5 (2004)**: CPUs with 2-4 cores and hardware support for atomic operations and CAS (compare-and-swap):
- atomic integers, longs, references, etc.;
- more flexible locks: `ReentrantLock` + `Condition`, `ReentrantReadWriteLock`;
- more synchronisation primitives: `Semaphores` (at most n), `CountDownLatch/CyclicBarrier` (at least n);
- concurrent collection: `ConcurrentHashMap`, `ConcurrentLinkedQueue`, `CopyOnWriteArrayList`, etc.;
- `Callable` (return results & throws exceptions) and `Future`;
- Executors: tasks and pool threads instead of `new Thread()` (better thread lifecycle management).

Java 7 (2011)
- `ForkJoinPool` executes `ForkJoinTasks`, which are suitable for computational tasks/pure functions (light-weight threads, with work stealing). In particular, this can be used for implementing fast parallel algorithms.

**Java 8 (2014)**
- Streams and parallel streams (in-memory computations);
- `CompletionStage` (implemented by `CompletableFuture`) - composition of tasks (first steps towards asynchronous/*reactive* programming - an attempt at dealing with blocking IO).

Java 9 (2017)
- `Flow` (reactive streams)

**Java 21 (2024)**
- Virtual threads  - first part of *Project Loom* replacing asynchronous programming with synchronous (structured concurrency and scoped values are in preview).       