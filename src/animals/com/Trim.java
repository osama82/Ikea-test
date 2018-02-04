package animals.com;

/**
 * @author osama
 * @Project Ikea test
 */
public class Trim {
    public static void main(String[] args) {
        String F="golden retriver,luci,2017 ";
        F=F.replaceAll("\\s","");
        System.out.println(F);
    }
}
