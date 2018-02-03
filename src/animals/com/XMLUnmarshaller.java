package animals.com;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * @author osama
 * @Project Ikea test
 * class to convert from XML file
 */
public class XMLUnmarshaller {



    public void unmarshalFromXML(String xmlFile){
        File file =new File(xmlFile);
        try {
            JAXBContext context =JAXBContext.newInstance(ListAnimals.class);
            Unmarshaller unmarshaller=context.createUnmarshaller();
            ListAnimals animals=(ListAnimals) unmarshaller.unmarshal(file);

            System.out.println("printing after unmarshalling");
            for (Animal p : animals.getAnimalslist()){
                //if (p.getType().equalsIgnoreCase("dog")) annimalls.add((Fish) p);
                System.out.println(p.toString());

            }


        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


}



