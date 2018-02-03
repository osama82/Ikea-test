package animals.com;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author osama
 * @Project Ikea test
 */
public class DolphinTest {
    @Test
    public void dolphinTest() throws Exception {
        Dolphin dol= new Dolphin("lili","1989");
        Assert.assertTrue(dol instanceof Swimmer);
        Assert.assertEquals("dolphin".toUpperCase(),dol.getType().toUpperCase());
    }

}