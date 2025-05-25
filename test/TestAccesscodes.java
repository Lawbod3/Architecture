import Data.Models.AccessCode;
import Data.Models.Resident;
import Data.Respository.AccessCodes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class TestAccesscodes {
    private AccessCodes accessCodes;
    private AccessCode accessCode;
    private Resident resident;
    @BeforeEach
    public void setUp(){
         accessCodes = new AccessCodes();
         accessCode = new AccessCode();
         resident = new Resident();
        accessCodes.clear();
    }

    @Test
    public void testAccessCodesISZeroByCount() {
        assertEquals(0, accessCodes.count());
    }

    @Test
    public void testAccessCodesISOneByCount() {
        accessCodes.save(resident, accessCode );
        assertEquals(1, accessCodes.count());

    }






}
