package animals.com;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author osama
 * @Project Ikea test
 */

public class Main {

    public static final Logger logger = Logger.getLogger(AnimalFactory.class);
    public static List<Animal> annimalls = new ArrayList<>();
    private static String csvfile = "src/start.txt";// path to the csv file
    private static String xmlfile = "src/result.xml";// path to the xml file
    private static String swimmersCSVFile="swimmers.csv";
     CSVRwiter csvRwiter;

    public static void main(String[] args) {

        ToXMLConverter conv = new ToXMLConverter();
        // convert the CSV file into XML file
        conv.convertToXml(csvfile, xmlfile);
        //

        // read from XML file into animals Collection
        XMLUnmarshaller unmarshaller1 = new XMLUnmarshaller();
        unmarshaller1.unmarshalFromXML(xmlfile);

        System.out.println("---------------------------");
        //read from CSV file
        CSVReader csvReader = new CSVReader();
        List<Animal> animalList = csvReader.convertCsvFile("src/start.csv");
        Service service=new Service();


        System.out.println("----------------------------");
        service.printSortedByName(animalList);

        System.out.println("----------------------------");
        List<Animal> ducks = service.allDucks(animalList);
        logger.info("geting all the ducks from the animals list");
        for (Animal p : ducks) {
            System.out.println(p.toString());
        }
        System.out.println("----------------------------");
        System.out.println("the sum of the yearbirth " + service.sumYearsOfBirth(animalList));
        logger.info("printing the sum of all yearbirths numbers of all the animals");

        System.out.println("----------------------------");

        //get the animal Collection that represent swimmers animals
        List<Animal> swimmers = service.getSwimmers(animalList);
        for (Animal p : swimmers)
            System.out.println(p.toString());
        ;
        logger.debug("get all the swimmers animals from the whole list into Collection");

        System.out.println("----------------------------");
        List<Animal> sortedListOfSwimmers = service.sortByBirth(swimmers);
        for (Animal p : sortedListOfSwimmers)
            System.out.println(p.toString());

        System.out.println("----------------------------");
        CSVRwiter csvRwiter=new CSVRwiter();
        csvRwiter.writeCSCVFile(sortedListOfSwimmers,swimmersCSVFile);


        System.out.println("----------------------------");
        ServerClient serverClient = new ServerClient();
        serverClient.startServer();
        serverClient.startSender(swimmers);

    }

    /*// print the animals list ordered by name
    private static void printSortedByName(List<Animal> animals) {
        animals.stream().sorted(Comparator.comparing(Animal::getName))
                .forEach(System.out::println);
        logger.info("printed Animals list have been sorted by name");
    }

    // return a list of animals that have the type "duck"
    private static List<Animal> allDucks(List<Animal> animals) {
        return animals.stream().filter(entry -> entry.getType()
                .equalsIgnoreCase("Duck"))
                .collect(Collectors.toList());


    }

    // function that return the sum of all years of birth for the all animals
    // in the list
    private static int sumYearsOfBirth(List<Animal> lis) {
        return lis.stream().map(Animal::birth)
                .reduce(0, (birth1, birth2) -> birth1 + birth2);

    }

    // return a list of animals that can swim which implements Swimmer Interface
    private static List<Animal> getSwimmers(List<Animal> lis) {
        List<Animal> swimmeranimals = new ArrayList<>();
        for (Animal p : lis) {
            if (p instanceof Swimmer) {
                swimmeranimals.add(p);
                logger.debug("swimmer have been added" + "with name: " + p.getName());
            }
        }
        return swimmeranimals;
    }

    // sort animals list by bybirth year and return the list from the youngest to oldest
    private static List<Animal> sortByBirth(List<Animal> lis) {
        return lis.stream().sorted(Comparator.comparing(Animal::birth).reversed())
                .collect(Collectors.toList());

    }*/
}
