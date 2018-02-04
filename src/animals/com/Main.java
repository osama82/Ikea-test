package animals.com;

import org.apache.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author osama
 * @Project Ikea test
 */

public class Main {

    public static final Logger logger = Logger.getLogger(AnimalFactory.class);
    public static List<Animal> annimalls = new ArrayList<>();
    private static String csvfile = "src/start.csv";// path to the csv file
    private static String xmlfile = "src/result.xml";// path to the xml file
    private static String xml = "src/csvToXml.xml";// path to the xml file
    private static String swimmersCSVFile = "swimmers.csv";

    public static void main(String[] args) throws JAXBException {


        ToXMLMarshaller marshaller = new ToXMLMarshaller();
        CSVReader csvReader = new CSVReader();
        List<Animal> animalList = csvReader.convertCsvFile("src/start.csv");//read the animals from csv file
        marshaller.marshalingToXML(animalList,xmlfile);//convert to XML
        System.out.println("---------------------------");
        System.out.println("---------------------------");


        ToXMLConverter conv = new ToXMLConverter();
        // convert the CSV file into XML file
        conv.convertToXml(csvfile, xml);// converting the csv file to xml without validating the entries
        System.out.println("---------------------------");
        System.out.println("---------------------------");

        // read from XML file into animals Collection and print them to console
        XMLUnmarshaller unmarshaller1 = new XMLUnmarshaller();
        List<Animal> list = unmarshaller1.unmarshalFromXML(xmlfile);

        System.out.println("---------------------------");
        System.out.println("---------------------------");
        //read from CSV file
        //CSVReader csvReader = new CSVReader();
        //List<Animal> animalList = csvReader.convertCsvFile("src/start.csv");

        Service service = new Service();


        System.out.println("----------------------------");
        // print the animals to console sorted ny name
        service.printSortedByName(animalList);

        System.out.println("----------------------------");
        // printing all the Duck entries to console
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
        logger.debug("Add all the swimmers animals from the whole list to Collection");

        System.out.println("----------------------------");
        System.out.println("sort the swimmers and print them to console");
        List<Animal> sortedListOfSwimmers = service.sortByBirth(swimmers);
        for (Animal p : sortedListOfSwimmers)
            System.out.println(p.toString());

        System.out.println("----------------------------");
        System.out.println("saving the sorted list of swimmers to csv file");
        CSVRwiter csvRwiter = new CSVRwiter();
        csvRwiter.writeCSCVFile(sortedListOfSwimmers, swimmersCSVFile);


        System.out.println("----------------------------");
        ServerClient serverClient = new ServerClient();
        serverClient.startServer();
        serverClient.startSender(swimmers);

    }
}
