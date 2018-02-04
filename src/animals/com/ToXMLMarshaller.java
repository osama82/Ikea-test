package animals.com;

import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

/**
 * @author osama
 * @Project Ikea test
 * the class to convert and marshall the objects
 * of the Animal list into XML file
 */
public class ToXMLMarshaller {
    public static final Logger logger = Logger.getLogger(AnimalFactory.class);
   /* public static void main(String[] args)throws JAXBException {
        CSVReader csvReader = new CSVReader();
        List<Animal> animalList = csvReader.convertCsvFile("src/start.csv");
        marshalingToXML(animalList);

    }*/
    /**
     *@param List<Animal>
     *@return XML file in the
     */
    public void marshalingToXML(List<Animal> list,String file) throws JAXBException {
        ListAnimals listAnimals1 = new ListAnimals();
        listAnimals1.setAnimalslist(list);
        JAXBContext jaxbContext = JAXBContext.newInstance(ListAnimals.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //Marshal the Animals list to console
        //jaxbMarshaller.marshal(listAnimals1, System.out);

        //Marshal the Animals list to file
        jaxbMarshaller.marshal(listAnimals1, new File(file));
        logger.info("marshalling the objects to the XML file have been done");
    }
}