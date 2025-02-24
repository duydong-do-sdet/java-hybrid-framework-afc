package commons;

import java.util.Random;

public class BaseTest {

    protected int getRandomNumber() {
        return new Random().nextInt(10000);
    }

}
