import java.time.Duration;
import java.time.Instant;

public class Ex40_VirtualThreads {
    public static void main(String[] args) {
        int numberOfThreads = 100_000;

        // Measure time taken using virtual threads
        Instant start = Instant.now();

        for (int i = 0; i < numberOfThreads; i++) {
            Thread.startVirtualThread(() -> {
                System.out.println("Hello from virtual thread: " + Thread.currentThread());
            });
        }

        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println("Time taken with virtual threads: " + duration.toMillis() + " ms");
    }
}
