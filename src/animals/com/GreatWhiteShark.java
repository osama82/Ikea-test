package animals.com;

/**
 * @author osama
 * @Project Ikea test
 */
public class GreatWhiteShark extends Animal implements Swimmer {
    public GreatWhiteShark() {
        this.setType("GreatWhiteShark");
    }

    public GreatWhiteShark(String name, String yearBirth) {
        super(name, yearBirth);
        this.setType("GreatWhiteShark");
    }

    @Override
    public void swim() {
        System.out.println("white shark is dangerous and swim fast");
    }
}
