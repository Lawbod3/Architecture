package Data.Respository;

import Data.Models.Resident;

import java.util.List;
import java.util.Optional;


    public interface AccessCodeRepository {
        long count();
        void delete(Resident resident);
        void delete(long id);

        List<Resident> findByFullNameName(String fullNameName);
        List<Resident> findAll();
        Optional<Resident> findById(long id);
        Resident save(Resident resident);



}
