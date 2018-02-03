package animals.com;

/**
 * @author osama
 * @Project Ikea test
 */
public class Dog extends Animal implements Swimmer {
    public Dog(){
    this.setType("dog");
    }

    public Dog( String name, String birthYear) {

        super( name, birthYear);
        super.setType("dog");
    }

    @Override
    public void swim() {
        System.out.println("dogs can swimm");
    }
}
