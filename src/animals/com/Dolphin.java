package animals.com;

public class Dolphin extends Animal implements Swimmer {

    public Dolphin(){
        this.setType("Dolphin");
    }

    public Dolphin( String name, String birthYear) {
        super( name, birthYear);

    }

    @Override
    public void swim() {
        System.out.println("Dolphin can swimm very fast");
    }

}

