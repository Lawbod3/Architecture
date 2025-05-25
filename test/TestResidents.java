import Data.Models.Resident;
import Data.Respository.Residents;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestResidents {

    


    @Test
    public void TestResidentsIsZeroByCount() {
        Residents residents = new Residents();
        residents.clear();
        assertEquals(0, residents.count());

    }
    @Test
    public void TestResidentsIsOneByCount() {
        Residents residents = new Residents();
        residents.clear();
        Resident resident = new Resident();
        residents.save(resident);
        assertEquals(1, residents.count());

    }

    @Test
    public void TestResidentsCanFindById() {
        Residents residents = new Residents();
        residents.clear();
        Resident resident = new Resident();
        Resident savedResident = residents.save(resident);
        Resident foundResident = residents.findById(savedResident.getId()).get();
        assertEquals(savedResident, foundResident);

    }

    @Test
    public void TestResidents_haveDifferentIds() {
        Residents residents = new Residents();
        residents.clear();
        Resident firstResident = new Resident();
        Resident secondResident = new Resident();
        residents.save(firstResident);
        residents.save(secondResident);
        assertEquals(1, firstResident.getId());
        assertEquals(2, secondResident.getId());

    }

    @Test
    public void TestResidents_haveSameIdsAreEqual() {
        Residents residents = new Residents();
        residents.clear();
        Resident firstResident = new Resident();
        Resident secondResident = new Resident();
        residents.save(firstResident);
        secondResident.setiD(firstResident.getId());
        residents.save(secondResident);
        assertEquals(1, residents.count());

    }

    @Test
    public void TestResidents_canBeUpdated() {
        Residents residents = new Residents();
        residents.clear();
        Resident firstResident = new Resident();
        Resident secondResident = new Resident();
        secondResident.setFullName("LAWAL OLABODE");
        residents.save(firstResident);
        long id = firstResident.getId();
        secondResident.setiD(firstResident.getId());
        residents.save(secondResident);
        Resident foundResident = residents.findById(id).get();
        assertEquals("LAWAL OLABODE", foundResident.getFullName());


    }

    @Test
    public void TestResidents_canBeDeleted() {
        Residents residents = new Residents();
        residents.clear();
        Resident firstResident = new Resident();
        Resident secondResident = new Resident();
        residents.save(firstResident);
        residents.save(secondResident);
        assertEquals(2, residents.count());
        residents.delete(firstResident);
        assertEquals(1, residents.count());
        Resident thirdResident = new Resident();
        residents.save(thirdResident);
        residents.delete(secondResident);
        assertEquals(1, residents.count());

    }
    @Test
    public void TestResidents_canIdentifyObjectById() {
        Residents residents = new Residents();
        residents.clear();
        Resident firstResident = new Resident();
        Resident secondResident = new Resident();
        residents.save(firstResident);
        secondResident.setiD(firstResident.getId());
        residents.save(secondResident);
        residents.delete(firstResident);
        assertEquals(1, residents.count());

    }

    @Test
    public void TestResidents_canGetResidentsByFullName() {
        Residents residents = new Residents();
        residents.clear();
        Resident firstResident = new Resident();
        Resident secondResident = new Resident();
        Resident thirdResident = new Resident();
        firstResident.setFullName("LAWAL OLABODE");
        secondResident.setFullName("ELETU OLABODE");
        thirdResident.setFullName("LAWAL OLABODE");
        residents.save(firstResident);
        residents.save(secondResident);
        residents.save(thirdResident);
        assertEquals(2, residents.findByFullNameName("LAWAL OLABODE").size());


    }

}
