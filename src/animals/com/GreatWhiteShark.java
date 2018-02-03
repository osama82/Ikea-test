package animals.com;

/**
 * @author osama
 * @Project Ikea test
 */
public class GreatWhiteShark extends Animal implements Swimmer {
    @Override
    public void swim() {
        System.out.println("white shark is dangerous and swim fast");
    }
}
