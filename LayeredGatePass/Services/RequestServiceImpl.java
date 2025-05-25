package Services;

import Data.Models.Resident;
import Data.Respository.ResidentRepository;
import Data.Respository.Residents;
import Dtos.Requests.LoginRequest;
import Dtos.Requests.RegisterResidentRequest;
import Dtos.Responses.RegisterResidentResponse;
import Exceptions.ServiceExceptions;
import Utils.Mapper;

import java.util.Optional;

import static Utils.Mapper.map;

public class RequestServiceImpl implements ResidentsServices{

    private final ResidentRepository residentRepository = new Residents();

    

    @Override
    public RegisterResidentResponse register(RegisterResidentRequest request) {
        ServiceExceptions.raiseOn(request);
       Resident newResident = residentRepository.save(map(request));
        return map(newResident);

    }

    @Override
    public Optional<Resident> login(LoginRequest request) {
        ServiceExceptions.raiseOn(request);
        return Mapper.mapLogin(request);
    }
}