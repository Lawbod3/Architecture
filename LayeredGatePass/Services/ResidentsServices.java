package Services;

import Data.Models.Resident;
import Data.Respository.ResidentRepository;
import Dtos.Requests.LoginRequest;
import Dtos.Requests.RegisterResidentRequest;
import Dtos.Responses.RegisterResidentResponse;

import java.util.Optional;

public interface ResidentsServices {


   RegisterResidentResponse register(RegisterResidentRequest resident);
   Optional<Resident> login(LoginRequest loginRequest);
}
