package animals.com;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author osama
 * @Project Ikea test
 * Calss represent Factory pattern to create objects
 * of different kinds of animals the parameter is the
 * String @type representing the kind of animal we need
 * an object of @ param  type
 */
public class AnimalFactory {

    private static final Logger logger=Logger.getLogger(AnimalFactory.class);

       static Animal getAnimal(String type){
    if(type.trim().equalsIgnoreCase("Dolphin"))
        return new Dolphin();
    else if(type.trim().equalsIgnoreCase("ArabianHorse"))
        return new ArabianHorse();
    else if (type.trim().equalsIgnoreCase("chicken"))
        return new Chicken();
    else if (type.trim().equalsIgnoreCase("parakeet"))
        return new Parakeet();
    else if (type.trim().equalsIgnoreCase("Duck"))
        return new Duck();
    else if (type.trim().equalsIgnoreCase("BengalCat"))
        return new BengalCat();
    else if (type.trim().equalsIgnoreCase("GermanShepherd"))
        return new GermanShepherd();
    else if (type.trim().equalsIgnoreCase("GoldenRetriever"))
        return new GoldenRetriever();
    else if (type.trim().equalsIgnoreCase("GreatWhiteShark"))
        return new GreatWhiteShark();

    return null;
    }

    // mapping every @type to correct object (Animal)
    final static Map<String, Supplier<Animal>> map = new HashMap<>();
    static {
        map.put("DOG".toUpperCase(), Dog::new);
        map.put("Dolphin".toUpperCase(), Dolphin::new);
    }
    /**
     * method to get an object of Animal of requested @type
     * @return Animal
     * @param type dtermine the result object created
     * @throws Exception when the type is not recognized
     */
    public static Animal getAnimal8(String type){
        Supplier<Animal> animal = map.get(type.toUpperCase().trim());
        if(animal != null)
            return animal.get();

        logger.error("the error is", new IllegalArgumentException("No such animal " + type.toUpperCase()));
        throw new IllegalArgumentException("invalid argument");
    }

}
