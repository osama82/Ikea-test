package animals.com;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {
  // public ArrayList<Animal> animals;

    public static void main(String[] args) {
        //XMLCreators creator = new XMLCreators();
        //creator.convertFile("src/start.txt","src/result.xml",",");
        File file =new File("src/result.xml");
        try {
            JAXBContext context =JAXBContext.newInstance(ListAnimals.class);
            Unmarshaller unmarshaller=context.createUnmarshaller();
            ListAnimals animals=(ListAnimals) unmarshaller.unmarshal(file);
            for (Animal p : animals.getAnimalslist()){
                System.out.println(p.toString());
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        System.out.println("hello");




    }
}
