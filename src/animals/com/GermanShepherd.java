package animals.com;

/**
 * @author osama
 * @Project Ikea test
 */
public class GermanShepherd extends Animal implements Swimmer {
    public GermanShepherd() {
        this.setType("GermanShephered");
    }

    public GermanShepherd(String name, String yearBirth) {
        super(name, yearBirth);
        this.setType("GermanShepherd");
    }

    @Override
    public void swim() {
        System.out.println("german shepherd can swim");
    }
}
