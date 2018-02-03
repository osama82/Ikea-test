package animals.com;

/**
 * @author osama
 * @Project Ikea test
 */
public class Chicken extends Animal  {

        public Chicken(){
            this.setType("Chicken");
        }

        public Chicken( String name, String birthYear) {
            super( name, birthYear);
            this.setType("Chicken");

        }



    }


