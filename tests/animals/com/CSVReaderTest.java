package animals.com;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

/**
 * @author osama
 * @Project Ikea test
 * test the method wich reads from the csv file into List<Animal>
 */
class CSVReaderTest {
    private String file = "test.csv";// experimental csv file
    private CSVReader csvReader;
    private File csv;

    @BeforeEach
    void setUp() {
        csv = new File(file);
        csvReader = new CSVReader();

    }


    @Test
    void convertCsvFileTest() {
        List<Animal> list = csvReader.convertCsvFile(file);
        Assert.assertTrue(csv.exists());
        // when the file is empty check the list result have no objects
        if (csv.length() == 0) {
            Assert.assertTrue(list.size() == 0);

        } else {
            Assert.assertNotNull(list);// the list not null
            Assert.assertTrue(csv.length() != 0 && list.size() != 0);// the file and the list not empty
            Assert.assertFalse(list.size() == 1);//the size is not 1
            Assert.assertTrue(list.size() == 2);
            // check that the objects in the result are relevant
            Assert.assertTrue(list.get(0) instanceof Duck && list.get(1) instanceof Dolphin);
        }

    }

}