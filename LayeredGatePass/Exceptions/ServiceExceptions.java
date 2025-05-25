package Exceptions;

import Data.Models.Resident;
import Data.Respository.Residents;
import Dtos.Requests.LoginRequest;
import Dtos.Requests.RegisterResidentRequest;

public class ServiceExceptions {
    public  static void raiseOn(RegisterResidentRequest request){
        if(request == null) throw new NullPointerException("RegisterResidentRequest is null");
        if(request.getEmail() == null || request.getEmail().trim().isEmpty() ) throw new NullPointerException("RegisterResidentRequest email is null");
       if(request.getAddress() == null || request.getAddress().trim().isEmpty()) throw new NullPointerException("RegisterResidentRequest address is null");
       if(request.getFullName() == null || request.getFullName().trim().isEmpty()) throw new NullPointerException("RegisterResidentRequest fullName is null");
       if(request.getPhoneNumber() == null || request.getPhoneNumber().trim().isEmpty()) throw new NullPointerException("RegisterResidentRequest phoneNumber is null");
    }
    public  static void raiseOn(LoginRequest loginRequest){
        if(loginRequest == null) throw new NullPointerException("LoginRequest is null");
        if(loginRequest.getEmail() == null || loginRequest.getEmail().trim().isEmpty()) throw new NullPointerException("LoginRequest email is null");
    }

}
