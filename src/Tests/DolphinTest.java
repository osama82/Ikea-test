package Tests;

import animals.com.Dolphin;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class DolphinTest {

    Dolphin dol=new Dolphin();
    @Before
    void init() {
        Dolphin dol =new Dolphin();
    }

    @Test
    void tester() {
        assert(equals(dol));
    }

}