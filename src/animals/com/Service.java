package animals.com;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author osama
 * @Project Ikea test
 * Class that deliver services to manipulate the lists of
 * Animals and Swimmers @param List<Animal>
 */
public class Service {


    public Service() {
    }


    public static final Logger logger = Logger.getLogger(AnimalFactory.class);

    // print the animals list ordered by name
    public void printSortedByName(List<Animal> animals) {
        animals.stream().sorted(Comparator.comparing(Animal::getName))
                .forEach(System.out::println);
        logger.info("printed Animals list have been sorted by name");
    }

    // return a list of animals that have the type "duck"
    public List<Animal> allDucks(List<Animal> animals) {
        return animals.stream().filter(entry -> entry.getType()
                .equalsIgnoreCase("Duck"))
                .collect(Collectors.toList());


    }

    // function that return the sum of all years of birth for the all animals
    // in the list
    public int sumYearsOfBirth(List<Animal> lis) {
        return lis.stream().map(Animal::birth)
                .reduce(0, (birth1, birth2) -> birth1 + birth2);

    }

    // return a list of animals that can swim which implements Swimmer Interface
    public List<Animal> getSwimmers(List<Animal> lis) {
        List<Animal> swimmeranimals = new ArrayList<>();
        for (Animal p : lis) {
            if (p instanceof Swimmer) {
                swimmeranimals.add(p);
                logger.debug("swimmer have been added" + "with name: " + p.getName());
            }
        }
        return swimmeranimals;
    }

    // sort animals list by bybirth year and return the list from the youngest to oldest
    public List<Animal> sortByBirth(List<Animal> lis) {
        return lis.stream().sorted(Comparator.comparing(Animal::birth).reversed())
                .collect(Collectors.toList());

    }


}
