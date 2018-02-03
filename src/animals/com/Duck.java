package animals.com;

/**
 * @author osama
 * @Project Ikea test
 */
public class Duck extends Animal implements Swimmer{

    public Duck(){
        this.setType("Duck");
    }
    public Duck(String name,String yearbirth){
        super(name,yearbirth);
        super.setType("duck");
    }


    @Override
    public void swim() {
        System.out.println("duck can swim");
    }
}
