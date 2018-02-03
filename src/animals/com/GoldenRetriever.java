package animals.com;

/**
 * @author osama
 * @Project Ikea test
 */
public class GoldenRetriever extends Animal implements Swimmer {
    @Override
    public void swim() {
        System.out.println("golden retriver can swim");
    }
}
