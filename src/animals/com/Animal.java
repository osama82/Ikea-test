package animals.com;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * /**
 * @author osama
 * @Project Ikea test
 * class Animal represents the Animal
 * Fields
 * type :breed of animal
 * name name :of animal
 * birthYear: the year of birth
 * every Animal is an Element in the representing XML file
 * which has three child elements @type @name @yearBirth
 *
*/


@XmlRootElement(name = "animal") // the root Element of the representing XML file
public  class Animal {

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
    public Animal(String name, String birthYear) {
        this.name=name;
        this.birthYear=birthYear;
    }

    // child Element of every Animal ,element @type
    @XmlElement(name = "type",required = true)
     String getType() {
        return type;
    }

     void setType(String type) {
        this.type = type;
    }


    // child Element of every Animal ,element @Name
    @XmlElement(name = "name",required = true)
     String getName() {
        return name;
    }

     void setName(String name) {
        this.name = name;
    }

    // child Element of every Animal, element @BirthYear


    int birth(){
        return Integer.valueOf(birthYear);
    }

    @XmlElement(name="age",required = true)
      String getBirthYear() {
        return birthYear;
    }

      void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public String toString(){

        return getType()+","+ getName()+","+ getBirthYear();
    }
}

