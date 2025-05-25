package Data.Respository;

import Data.Models.AccessCode;
import Data.Models.Resident;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class AccessCodes implements AccessCodeRepository {
    private static List<AccessCode> accessCodes = new ArrayList<>();
    private  static long tokenGenerator = 0;



    public void clear() {
        accessCodes.clear();
    }

    @Override
    public long count() {
        return accessCodes.size();
    }

    @Override
    public List<AccessCode> findByDate(String date) {
        return List.of();
    }

    @Override
    public List<AccessCode> findAll() {
        return List.of();
    }

    @Override
    public Optional<AccessCode> findById(long id) {
        return Optional.empty();
    }

    @Override
    public AccessCode save(Resident resident, AccessCode accessCode) {
        accessCode.setId(resident.getId());
        accessCode.setCreationDate();
        accessCode.setToken(tokenGenerator());
        accessCodes.add(accessCode);

        return null;
    }

    private static String tokenGenerator() {
        Random random = new Random();
        int number = random.nextInt(900)+100;
        String token = "Pass" + number;
         token += tokenGenerator++;
         return token;
    }
}
