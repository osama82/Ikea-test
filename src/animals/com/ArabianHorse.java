package animals.com;

public class ArabianHorse extends Animal implements Swimmer {

    public ArabianHorse(){

    }

    public ArabianHorse(String type, String name, String birthYear) {
        super(type, name, birthYear);
    }

    @Override
    public void swim() {
        System.out.println("Arabian horse can swimm");
}

}
