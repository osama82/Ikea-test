package animals.com;

import org.apache.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author osama
 * the class writes a list of animals objects
 * into a csv file
 * @Project Ikea test
 */
public class CSVRwiter {

    //private VirtualFlow.ArrayLinkedList<Animal> h;
    private static String filName = "swimmers.csv";
    private static List<Animal> list;
    private static String delemiter = ",";// comma between every tow values in the same raw
    private static final String HEADER = "type,name,yearBirth";
    private static String lineSeparator = "\n";// separate every tow lines of the csv file
    public static final Logger logger = Logger.getLogger(AnimalFactory.class);


    public CSVRwiter() {

        //this.list = list;
    }

    /**
     * convert the objects of the animals into csv file
     *
     * @param list<Animal>
     * @param filName      where the info of animals objects will be stored
     *                     in the structure of csv files
     */

    public void writeCSCVFile(List<Animal> list, String filName) {
        try {
            FileWriter fileWriter = new FileWriter(filName);
            fileWriter.append(HEADER);
            // appending the fields of the animals objects into lines
            for (Animal p : list) {
                fileWriter.append(lineSeparator);
                fileWriter.append(p.getType());
                fileWriter.append(delemiter);
                fileWriter.append(p.getName());
                fileWriter.append(delemiter);
                fileWriter.append(p.getBirthYear());


            }
            fileWriter.flush();
            fileWriter.close();
            logger.info("writing into CSV file");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
