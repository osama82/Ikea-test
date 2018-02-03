package animals.com;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author osama
 * @Project Ikea test
 */
public class DuckTest {
    private static Duck duck;

    @Before
    public void init() {
        System.out.println("Duck object have been made");
        duck = new Duck("lina", "2017");
    }

    @Test
    public void DuckTest() throws Exception {
        //Duck duck = new Duck("lina", "2017");
        Assert.assertEquals("duck".toUpperCase(), duck.getType().toUpperCase());

    }

}