package animals.com;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author osama
 * @Project Ikea test
 */
public class CSVRwiterTest {

    List<Animal>list=new ArrayList<>();


    CSVRwiter writer;
    CSVReader reader;


    @Before
    public void setUp() throws Exception {

        list.add(new Duck("lilo","1987"));
        reader=new CSVReader();
        writer=new CSVRwiter();

    }

    @Test
    public void writeCSCVFile() throws Exception {
       // System.out.println(list);
        writer.writeCSCVFile(list,"test.csv");
        List<Animal>result=reader.convertCsvFile("test.csv");
        Assert.assertEquals(result.toString().toUpperCase(),list.toString().toUpperCase());

    }

}