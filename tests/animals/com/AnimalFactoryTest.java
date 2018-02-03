package animals.com;


import org.junit.jupiter.api.*;


/**
 * @author osama
 * @Project Ikea test
 * testing the AnimalFactory class
 */
class AnimalFactoryTest {


    @Test
    void getAnimalTest() {
        Animal duck = AnimalFactory.getAnimal("duck");
        Assertions.assertTrue(duck instanceof Duck);
        Assertions.assertFalse(duck instanceof Dolphin);
        Assertions.assertEquals(null, AnimalFactory.getAnimal("tore"));
        Assertions.assertEquals("Duck".toUpperCase(), duck.getType().toUpperCase());
    }

    @Test
    void getAnimal8Test() throws InvalidAnimalException {
        Assertions.assertThrows(InvalidAnimalException.class, () -> {
            AnimalFactory.getAnimal8("run");
        });

    }


}