package Utils;

import Data.Models.Resident;
import Data.Respository.Residents;
import Dtos.Requests.LoginRequest;
import Dtos.Requests.RegisterResidentRequest;
import Dtos.Responses.RegisterResidentResponse;

import java.util.Optional;

public class Mapper {
    static Residents residents = new Residents();
    public static Resident map(RegisterResidentRequest request) {
        Resident resident = new Resident();
        resident.setEmail(request.getEmail());
        resident.setFullName(request.getFullName());
        resident.setPhoneNumber(request.getPhoneNumber());
        resident.setAddress(request.getAddress());
        residents.save(resident);
        return resident;


    }

    public static RegisterResidentResponse map(Resident resident) {
        RegisterResidentResponse registerResidentResponse = new RegisterResidentResponse();
        registerResidentResponse.setResidentFullName(resident.getFullName());
        registerResidentResponse.setResidentEmail(resident.getEmail());
        registerResidentResponse.setResidentPhoneNumber(resident.getPhoneNumber());
        return registerResidentResponse;

    }

    public static Optional<Resident> mapLogin(LoginRequest loginRequest) {
        Residents residents = new Residents();
        Optional<Resident> myResident = residents.findById(loginRequest.getId());
        if(myResident.isPresent() && loginRequest.getEmail().equals(myResident.get().getEmail()))return myResident;
        return  Optional.empty();
    }

}
