package Data.Respository;

import Data.Models.AccessCode;
import Data.Models.Resident;
import Data.Models.Visitors;

import java.util.List;
import java.util.Optional;


    public interface AccessCodeRepository {
        long count();
        List<AccessCode> findByCreationDate(String date);
        List<AccessCode> findByExpirationDate(String date);
        List<AccessCode> findByUseDate(String date);
        List<AccessCode> findAllActiveToken();
        List<AccessCode> findAll();
        List<AccessCode> findById(long id);
        Optional<AccessCode> findByToken(String token);
        AccessCode save(Resident resident, AccessCode accessCode);
        List<AccessCode> findByResident(Resident resident);
    }
