package src.threads;

import java.util.concurrent.Callable;

/**
 * Created by 16734975 on 30.10.2018.
 */
public class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }

}
