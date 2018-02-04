package animals.com;

/**
 * @author osama
 * @Project Ikea test
 */
public class Duck extends Animal implements Swimmer {

    public Duck() {

        this.setType("Duck");
    }

    public Duck(String name, String yearBirth) {
        super(name, yearBirth);
        super.setType("Duck");
    }


    @Override
    public void swim() {
        System.out.println("duck can swim");
    }
}
