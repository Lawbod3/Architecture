import Dtos.Requests.LoginRequest;
import Dtos.Requests.RegisterResidentRequest;
import Services.RequestServiceImpl;
import Services.ResidentsServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class TestExceptions {
        private RegisterResidentRequest registerResidentRequest;
        private ResidentsServices services;
        private LoginRequest loginRequest;


        @BeforeEach
        public void setUp(){
            registerResidentRequest = new RegisterResidentRequest();
            services = new RequestServiceImpl();
            loginRequest = new LoginRequest(1, "");
        }
        @Test
        public void testRegisterResidentEmptyEmail(){
            registerResidentRequest.setEmail("");
           assertThrows(NullPointerException.class, () -> { services.register(registerResidentRequest);});
        }

    @Test
    public void testRegisterResidentEmptyAddress(){
            registerResidentRequest.setEmail("Olabode@gmail.com");
            registerResidentRequest.setAddress(" ");
        assertThrows(NullPointerException.class, () -> { services.register(registerResidentRequest);});
    }

    @Test
    public void testRegisterResidentEmptyFullName(){
        registerResidentRequest.setEmail("Olabode@gmail.com");
        registerResidentRequest.setAddress("312, herbert, macaulay");
        registerResidentRequest.setFullName(" ");
        assertThrows(NullPointerException.class, () -> { services.register(registerResidentRequest);});
    }
    @Test
    public void testRegisterResidentEmptyPhoneNumber(){
            registerResidentRequest.setEmail("Olabode@gmail.com");
            registerResidentRequest.setAddress("312, herbert, macaulay");
            registerResidentRequest.setFullName("Olabode");
            registerResidentRequest.setPhoneNumber("   ");
            assertThrows(NullPointerException.class, () -> { services.register(registerResidentRequest);});
    }

    @Test
    public void testLoginRequestEmptyEmail(){
            assertThrows(NullPointerException.class, () -> { services.login(loginRequest);});
    }





}

