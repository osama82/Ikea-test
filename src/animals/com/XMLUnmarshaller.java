package animals.com;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

/**
 * @author osama
 * @Project Ikea test
 * class to convert from XML file into list of Animals
 */
public class XMLUnmarshaller {



    public List<Animal> unmarshalFromXML(String xmlFile){
        File file =new File(xmlFile);
        ListAnimals animals=new ListAnimals();
        try {
            JAXBContext context =JAXBContext.newInstance(ListAnimals.class);
            Unmarshaller unmarshaller=context.createUnmarshaller();
             animals=(ListAnimals) unmarshaller.unmarshal(file);
            System.out.println("printing after unmarshalling");
            for (Animal p : animals.getAnimalslist()){
                System.out.println(p.toString());

            }


        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return animals.getAnimalslist();
    }


}



