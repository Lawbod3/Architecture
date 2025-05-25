import Data.Models.AccessCode;
import Data.Models.Resident;
import Data.Respository.AccessCodes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;
import java.util.Optional;

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
         resident.setiD(1);
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

    @Test
    public void testAccessCodeCanBeGetById(){
        AccessCode save =  accessCodes.save(resident, accessCode );
        List<AccessCode> newAccessCode = accessCodes.findById(resident.getId());
        assertTrue(newAccessCode.contains(save));

    }

    @Test
    public void testAccessCodesCanBeGetByToken(){
        AccessCode accessCodeOne =  accessCodes.save(resident, accessCode );
        Optional<AccessCode> accessCodeTwo = accessCodes.findByToken(accessCodeOne.getToken());
        assertTrue(accessCodeTwo.get().equals(accessCodeOne));

    }

    @Test
    public void testAccessCodesCanBeGetByResident(){
        AccessCode accessCodeOne =  accessCodes.save(resident, accessCode );
        List<AccessCode> accessCodeTwo = accessCodes.findByResident(resident);
        assertTrue(accessCodeTwo.contains(accessCodeOne));
    }

    @Test
    public void testAccessCodsCanBeReturnAllAccessCode(){
        accessCodes.save(resident, accessCode );
        List<AccessCode> allAccessCode = accessCodes.findAll();
        assertTrue(allAccessCode.contains(accessCode));
        assertEquals(allAccessCode.size(), accessCodes.count());
    }

    @Test
    public void testAccessCodsCanBeFindFindByCreationDate(){
        AccessCode result = accessCodes.save(resident, accessCode );
        List<AccessCode> all = accessCodes.findByCreationDate("05/25/2025");
        assertTrue(all.contains(result));
    }
    @Test
    public void testAccessCodsCanBeFindByExpirationDate(){
        AccessCode result = accessCodes.save(resident, accessCode );
        List<AccessCode> all = accessCodes.findByExpirationDate("05/28/2025");
        assertTrue(all.contains(result));
    }






}
