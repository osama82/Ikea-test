package animals.com;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @Project Ikea test
 * @author osama
 * the class writes a list of animals objects
 * into a csv file
 */
public class CSVRwiter {

    //private VirtualFlow.ArrayLinkedList<Animal> h;
   private static String filName="swimmers.csv";
   private static List<Animal> list;
   private static String delemiter=",";// comma between every tow values in the same raw
   private static final String HEADER="type,name,yearBirth";
   private static String lineSeparator="\n";// separate every tow lines of the csv file


    public CSVRwiter(List<Animal> list) {

        this.list = list;
    }

    /**
     * convert the objects of the animals into csv file
     * @param list<Animal>
     * @param filName where the info of animals objects will be stored
     * in the structure of csv files
     */

    public   void writeCSCVFile(List<Animal> list,String filName ){
        try {
             FileWriter fileWriter = new FileWriter(filName);
             fileWriter.append(HEADER);
             // appending the fields of the animals objects into lines
             for (Animal p:list){
                 fileWriter.append(lineSeparator);
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

   /* public static void main(String[] args) {
        list = new ArrayList<>();
        list.add(new Dog("jo","65"));
        list.add(new Fish("rody","1"));

        writeCSCVFile(list,filName);


    }*/
}
