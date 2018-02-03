package animals.com;

/**
 * @author osama
 * @Project Ikea test
 */
public class ArabianHorse extends Animal implements Swimmer {

    public ArabianHorse(){
    this.setType("ArabianHorse");
    }

    public ArabianHorse( String name, String yearBirth) {
        super( name, yearBirth);
        super.setType("ArabianHorse");
    }

    @Override
    public void swim() {
        System.out.println("Arabian horse can swimm");
}

}
