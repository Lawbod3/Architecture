package Services;

import Data.Models.Resident;
import Data.Respository.ResidentRepository;
import Data.Respository.Residents;
import Dtos.Requests.LoginRequest;
import Dtos.Requests.RegisterResidentRequest;
import Dtos.Responses.RegisterResidentResponse;
import Utils.Mapper;

import java.util.Optional;

import static Utils.Mapper.map;

public class RequestServiceImpl implements ResidentsServices{

    private final ResidentRepository residentRepository = new Residents();

    

    @Override
    public RegisterResidentResponse register(RegisterResidentRequest resident) {
       Resident newResident = residentRepository.save(map(resident));
        RegisterResidentResponse result = map(newResident);
        return result;
    }

    @Override
    public Optional<Resident> login(LoginRequest loginRequest) {
        return Mapper.mapLogin(loginRequest);
    }
}