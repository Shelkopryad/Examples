package src.threads;

import java.util.Random;

/**
 * Created by 16734975 on 30.10.2018.
 */
public class IntGeneratorImpl extends IntGenerator {

    public int next() {
        return new Random().nextInt(500);
    }

}
