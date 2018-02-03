package animals.com;

/**
 * @author osama
 * @Project Ikea test
 */
public class BengalCat extends Animal {
    public BengalCat() {

        this.setType("BengalCat");
    }

    public BengalCat(String name, String yearBirth) {
        super(name, yearBirth);
        this.setType("BengalCat");
    }
}
