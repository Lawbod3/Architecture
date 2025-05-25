package Data.Respository;

import Data.Models.AccessCode;
import Data.Models.Resident;
import Data.Models.Visitors;

import java.util.List;
import java.util.Optional;


    public interface AccessCodeRepository {
        long count();
        List<AccessCode> findByDate(String date);
        List<AccessCode> findAll();
        Optional<AccessCode> findById(long id);
        AccessCode save(Resident resident, AccessCode accessCode);

}
