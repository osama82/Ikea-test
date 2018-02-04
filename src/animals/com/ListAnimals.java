package animals.com;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.ArrayList;

@XmlRootElement(name = "animals")
public class ListAnimals {
    private List<Animal> animalslist = new ArrayList<>();

    public ListAnimals(List<Animal> animalslist) {

        this.animalslist = animalslist;
    }

    public ListAnimals() {

    }

    @XmlElement(name = "animal", required = true)
    public List<Animal> getAnimalslist() {

        return animalslist;
    }

    public void setAnimalslist(List<Animal> animalslist) {

        this.animalslist = animalslist;
    }
}
