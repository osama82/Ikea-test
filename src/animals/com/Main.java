package animals.com;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Main {


    public static List<Animal> annimalls=new ArrayList<>();

    public static void main(String[] args) {
        //XMLCreators creator = new XMLCreators();
        //creator.convertFile("src/start.txt","src/result.xml",",");
        Swimmer fis =new Fish("fish","katy","12");



        File file =new File("src/result.xml");
        try {
            JAXBContext context =JAXBContext.newInstance(ListAnimals.class);
            Unmarshaller unmarshaller=context.createUnmarshaller();
            ListAnimals animals=(ListAnimals) unmarshaller.unmarshal(file);
            for (Animal p : animals.getAnimalslist()){
                   // if (p.getType().equalsIgnoreCase("fish")) annimalls.add((Fish) p);
                System.out.println(p.toString());

            }
            Function<Animal,String> byType=Animal::getType;
            System.out.println("hello");
            annimalls.stream().sorted(Comparator.comparing(Animal::getType)).forEach(System.out::println);
            System.out.println("hello");
            annimalls.stream().filter(e -> e.getType().equals("horse")).forEach(System.out::println);


        } catch (JAXBException e) {
            e.printStackTrace();
        }






    }
}
