package animals.com;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author osama
 * @Project Ikea test
 * class responsible of reading the CSV file into collection of animals
 */

public class CSVReader {

    //static Animal item;
    static int counter;

    public static final Logger logger = Logger.getLogger(CSVReader.class);


    public List<Animal> convertCsvFile(String csvFile) {

        List<Animal> inputList = new ArrayList<>();

        try {
            File inputF = new File(csvFile);
            InputStream inputFS = new FileInputStream(csvFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
            inputList = br.lines().skip(1).// retrieve the lines and skip the first line that holds description
                    map(retriveAnimal).// get the animal object that goes with the type
                    filter(entry -> entry != null).// eliminate the NULL Entries caused by wrong input
                    collect(Collectors.toList());// collect to whole objects into List
            br.close();

        } catch (IOException e) {
        }
        for (Animal t : inputList) {
            System.out.println(t);
        }
        return inputList;
    }

    private static int i;

    private Function<String, Animal> retriveAnimal = (String line) -> {

        String[] p = line.split(",");// a CSV has comma separate between values

        // using regular expression to eliminate the values which are not numeric
        if (!p[2].matches("[0-9]+")) {
            try {
                throw new InvaliEntryExeption("not valid year Birth");
            } catch (InvaliEntryExeption e) {
                // e.printStackTrace();
                logger.warn("Invalid Entry", e);
            }
            i++;

            //logger.log(Level.toLevel("Sever"),"",new Exception("hii"));
            System.err.println(i + " invalid entry");
            return null;
        } else {


            Animal item = AnimalFactory.getAnimal(p[0]);
            item.setName(p[1]);
            item.setBirthYear(p[2]);

            return item;

        }
    };
}
