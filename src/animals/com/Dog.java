package animals.com;

public class Dog extends Animal implements Swimmer {

    public Dog(String type, String name, String birthYear) {
        super(type, name, birthYear);
    }

    @Override
    public void swim() {
        System.out.println("dogs can swimm");
    }
}
