package animals.com;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author osama
 * the class writes a list of animals into a csv file
 */
public class CsvRwiter {

    //private VirtualFlow.ArrayLinkedList<Animal> h;

   private static List<Animal> list;
   private static String delemiter=",";
   private static final String HEADER="type,name,yearBirth";
   private static String lineSerator="\n";


    public CsvRwiter(List<Animal> list) {

        this.list = list;
    }
    public  void writeCSCVFile(List<Animal> list){
        try {
             FileWriter fileWriter = new FileWriter("swimmers.csv");
             fileWriter.append(HEADER);

             for (Animal p:list){
                 fileWriter.append(lineSerator);
                 fileWriter.append(p.getType());
                 fileWriter.append(delemiter);
                 fileWriter.append(p.getName());
                 fileWriter.append(delemiter);
                 fileWriter.append(p.getBirthYear());


             }
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /*public static void main(String[] args) {
        list = new ArrayList<>();
        list.add(new Dog("dog","rody","32"));
        list.add(new Fish("dog","rody","1"));

        writeCSCVFile(list);


    }*/
}
