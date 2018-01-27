package animals.com;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name="Animal")
public class Animal {
    private String type;
    private String name;
    private String birthYear;
    //private ArrayList<? extends Animal> animals;

    public Animal(String type, String name, String birthYear) {
        this.type = type;
        this.name = name;
        this.birthYear = birthYear;
    }

    public Animal() {
    }

    @XmlElement
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public String toString(){

        return getType()+"  "+ getName()+"  "+ getBirthYear();
}
}

