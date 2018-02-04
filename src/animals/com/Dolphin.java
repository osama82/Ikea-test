package animals.com;

public class Dolphin extends Animal implements Swimmer {

    public Dolphin(){
        this.setType("Dolphin");
    }

    public Dolphin( String name, String yearBirth) {
        super( name, yearBirth);
        this.setType("dolphin");

    }

    @Override
    public void swim() {
        System.out.println("Dolphin can swimm very fast");
    }

}

