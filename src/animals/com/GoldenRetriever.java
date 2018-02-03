package animals.com;

/**
 * @author osama
 * @Project Ikea test
 */
public class GoldenRetriever extends Animal implements Swimmer {

    public GoldenRetriever(){
        this.setType("GoldenRetriever");

    }
    public GoldenRetriever(String name,String yearBirth){
        super(name,yearBirth);
        this.setType("GoldenRetriever");
    }
    @Override
    public void swim() {
        System.out.println("golden retriver can swim");
    }
}
