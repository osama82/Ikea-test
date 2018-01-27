package animals.com;

public class Fish extends Animal implements  Swimmer{

    public Fish(String type, String name, int birthYear) {
        super(type, name, birthYear);
    }

    @Override
    public void swim() {
        System.out.println("fish can swimm fast");
    }
}
