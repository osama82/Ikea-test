package animals.com;

public class Dog extends Animal implements Swimmer {
    public Dog(){
    this.setType("dog");
    }

    public Dog(String type, String name, String birthYear) {

        super( name, birthYear);
    }

    @Override
    public void swim() {
        System.out.println("dogs can swimm");
    }
}
