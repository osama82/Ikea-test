package animals.com;

import com.sun.xml.internal.bind.v2.util.ByteArrayOutputStreamEx;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;


/**
 * @author osama
 * @Project Ikea test
 * the tests for the functions of Service class
 */
public class ServiceTest {
    List<Animal> animals = new LinkedList<>();
    Service service = new Service();

    @Before
    public void setUp() throws Exception {
        service = new Service();
        animals.add(new Duck("lilu", "2016"));
        animals.add(new Dolphin("kilo", "2017"));
        animals.add(new BengalCat("lolu", "2016"));

    }

    @Test
    public void printSortedByNameTest() throws Exception {
        service.printSortedByName(animals);
        Assert.assertEquals(animals.size(), 3);

        ByteArrayOutputStream outContent = new ByteArrayOutputStreamEx();
        System.setOut(new PrintStream(outContent));
        service.printSortedByName(animals);
        Assert.assertEquals("dolphin,kilo,2017\nDuck,lilu,2016\nbengalCat,lolu,2016".
                replaceAll("(\\r|\\n|\\t)", "").trim().toUpperCase(), (outContent.toString().
                replaceAll("(\\r|\\n|\\t)", "").trim().toUpperCase()));

    }

    @Test
    public void sumYearsOfBirthTest() throws Exception {
        Assert.assertEquals(6049, animals.get(0).birth()
                + animals.get(1).birth()
                + animals.get(2).birth());
    }

    @Test
    public void getSwimmersTest() throws Exception {
        List<Animal> swimers = service.getSwimmers(animals);
        Assert.assertEquals(2, swimers.size());
        Assert.assertEquals("kilo", swimers.get(1).getName());
        Assert.assertThat(swimers.get(0), is(instanceOf(Swimmer.class)));


    }

    @Test
    public void sortByBirthTest() throws Exception {
        List<Animal> sorted = service.sortByBirth(animals);
        Assert.assertTrue(Integer.valueOf(sorted.get(0).getBirthYear()) >
                Integer.valueOf(sorted.get(1).getBirthYear()));


    }

}