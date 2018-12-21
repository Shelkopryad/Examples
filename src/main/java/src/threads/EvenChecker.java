package src.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 16734975 on 30.10.2018.
 */
public class EvenChecker implements Runnable {

    private IntGenerator generator;

    private final int id;

    public EvenChecker(IntGenerator g, int id) {
        this.generator = g;
        this.id = id;
    }

    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println(val + " not even!");
                generator.cancel();
            }
        }
    }

    public static void test(IntGenerator g, int count) {
        System.out.println("Press Ctrl+C to exit");
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            service.execute(new EvenChecker(g, i));
        }
        service.shutdown();
    }

    public static void test(IntGenerator g) {
        test(g, 10);
    }

}
