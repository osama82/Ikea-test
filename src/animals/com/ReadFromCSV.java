package animals.com;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReadFromCSV {

    //static Animal item;
    static int counter;

    public static final Logger logger=Logger.getLogger("hello");


    public static void main(String[] args)  {


        try {
            convertCsvFile("src/start.txt");
        } catch (IOException e) {
            logger.error("file error",e);
            e.printStackTrace();
        }


    }
    private  static   List<Animal> convertCsvFile(String p) throws IOException {

        List<Animal> inputList = new ArrayList<>();

        try{

            File inputF = new File(p);
            InputStream inputFS = new FileInputStream(p);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
            inputList = br.lines().skip(1).
                        map(retriveAnimal).
                        filter(entry->entry!=null).
                        collect(Collectors.toList());
            br.close();
        } catch ( IOException e) {
        }
        for(Animal t:inputList){
            System.out.println(t);
        }
        return inputList ;
    }

    private static int i;
    private   static Function<String, Animal> retriveAnimal = (String line) -> {

        String[] p = line.split(",");// a CSV has comma separated lines﻿
        if (!p[2].matches("[0-9]+")) {
            i++;
            logger.info("hii");
            //logger.log(Level.toLevel("Sever"),"",new Exception("hii"));
            System.err.println(i+" invalid entry");
            return null;
        }
        else {


            Animal item = AnimalFactory.getAnimal(p[0]);
            if(item instanceof Swimmer)
                 ((Swimmer) item).swim();
                //System.out.println(((Swimmer) item).swim());
            //item.setType(p[0]);//<-- this is the first column in the csv file
            item.setName(p[1]);
            item.setBirthYear(p[2]);

        return item;

        }
    };
}
