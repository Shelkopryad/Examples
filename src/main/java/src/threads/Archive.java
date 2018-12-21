package src.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by 16734975 on 21.12.2018.
 */
public class Archive {



    public static void mainThread() {
        LiftOff liftOff = new LiftOff();
        liftOff.run();
    }

    public static void basicThread() {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for liftoff");
    }

    public static void moreBasicThread() {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for liftoff");
    }

    public static void cachedThreadPool() {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            service.execute(new LiftOff());
        }
        service.shutdown();
        System.out.println("Waiting for liftoff");
    }

    public static void fixedThreadPool() {
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            service.execute(new LiftOff());
        }
        service.shutdown();
        System.out.println("Waiting for liftoff");
    }

    public static void singleThreadExecutor() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            service.execute(new LiftOff());
        }
        service.shutdown();
        System.out.println("Waiting for liftoff");
    }

    public static void callableDemo() {
        ExecutorService service = Executors.newCachedThreadPool();

        List<Future<String>> list = new ArrayList<Future<String>>();

        for (int i = 0; i < 10; i++) {
            list.add(service.submit(new TaskWithResult(i)));
        }

        for (Future<String> future : list) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                service.shutdown();
            }
        }
    }

    public static void fibonacciDemoRunnable() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 20; i++) {
            service.execute(new FibonacciTestRunnable(i));
        }
        service.shutdown();
    }

    public static void fibonacciDemoCallable() {
        ExecutorService service = Executors.newCachedThreadPool();

        List<Future<Integer>> list = new ArrayList<Future<Integer>>();

        for (int i = 0; i < 20; i++) {

            list.add(service.submit(new FibonacciTestCallable(i)));
        }
        service.shutdown();
        int result = 0;
        for (Future<Integer> future : list) {
            try {
                result += future.get();
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                service.shutdown();
            }
        }

        System.out.println("result = " + result);
    }

    public static void evenCheckerDemo() {
        EvenChecker checker;
        for (int i = 0; i < 10; i++) {
            checker = new EvenChecker(new IntGeneratorImpl(), i);
            checker.run();
        }

        checker = new EvenChecker(new IntGeneratorImpl(), 10);
        checker.test(new IntGeneratorImpl());


    }


}
