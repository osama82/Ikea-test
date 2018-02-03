package animals.com;

public class Fish extends Animal implements  Swimmer{

    public  Fish(){
    this.setType("fish");
    }

    public Fish( String name, String birthYear) {
        super( name, birthYear);
    }

    @Override
    public void swim() {
        System.out.println("fish can swimm fast");
    }
}
