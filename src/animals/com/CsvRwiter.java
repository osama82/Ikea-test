package animals.com;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvRwiter {
    private VirtualFlow.ArrayLinkedList<Animal> h;

   private List<Animal> list;
   private String delemiter=",";
   private final String HEADER="type,name,age";
   private String lineSerator="\n";


    public CsvRwiter(List<Animal> list) {
        this.list = list;
    }
    public void makeCsvFile(List<Animal> list){
        try {
             FileWriter fileWriter = new FileWriter("swimmers.txt");
             fileWriter.append(HEADER);
             for(Animal p:list){
                 fileWriter.append(lineSerator);
                 fileWriter.append(p.getType());
                 fileWriter.append(delemiter);
                 fileWriter.append(p.getName());
                 fileWriter.append(delemiter);
                 fileWriter.append(p.getBirthYear());
                 fileWriter.flush();
                 fileWriter.close();

             }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
