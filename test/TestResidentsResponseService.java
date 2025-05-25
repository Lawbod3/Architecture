import Data.Models.Resident;
import Data.Respository.Residents;
import Dtos.Requests.LoginRequest;
import Dtos.Requests.RegisterResidentRequest;
import Dtos.Responses.RegisterResidentResponse;
import Services.RequestServiceImpl;
import Services.ResidentsServices;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.Assert.*;

public class TestResidentsResponseService {
    private  Residents residents ;
   private  ResidentsServices services ;
   private  RegisterResidentRequest resident ;


    @Before
    public void setup() {
         residents = new Residents();
         services = new RequestServiceImpl();
         resident = new RegisterResidentRequest();
        resident.setFullName("lawal");
        resident.setAddress("123 Lawal");
        resident.setPhoneNumber("555-555-5555");
        resident.setEmail("lawal@gmail.com");

    }


    @Test
    public void testResidentResponseService() {

        RegisterResidentResponse response = services.register(resident);
        assertEquals("lawal", response.getResidentFullName());
        assertEquals(1, residents.count());


    }

    @Test
    public void testLoginResponseService() {
        services.register(resident);
        LoginRequest loginRequest = new LoginRequest(1, "lawal@gmail.com");
        Resident myResident = services.login(loginRequest).get();
        assertEquals("lawal", myResident.getFullName());


    }






}
