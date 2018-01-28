package Tests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestLoger {
    public static int pluss(int a, int b){
        return a+b;


    }

    private static final Logger logger= LoggerFactory.getLogger(TestLoger.class);
    public static void main(String[] args) {

        logger.debug("hello");


    }
}
