package animals.com;

/**
 * Calss to make classes of animals
 * @ param  type
 */
public class AnimalFactory {
    static Animal t;

    public  static Animal getAnimal(String type){

    if(type.trim().equalsIgnoreCase("Dolphin"))
        return new Dolphin();
    else if(type.trim().equalsIgnoreCase("horse"))
        return new ArabianHorse();
    else if (type.trim().equalsIgnoreCase("chicken"))
        return new Chicken();
    else if (type.trim().equalsIgnoreCase("parakeet"))
        return new Parakeet();

    return null;
    }
}
