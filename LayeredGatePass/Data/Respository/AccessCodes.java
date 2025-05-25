package Data.Respository;

import Data.Models.AccessCode;
import Data.Models.Resident;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public List<AccessCode> findByCreationDate(String date) {
        List<AccessCode> result = new ArrayList<>();
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDate localDate = LocalDate.parse(date, formatter);
            for(AccessCode accessCode : accessCodes) {
              LocalDate creationDate = LocalDate.parse(accessCode.getCreationDate(), formatter);
              if(creationDate.equals(localDate)) result.add(accessCode);
            }

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public List<AccessCode> findAll() {
        List<AccessCode> allAccessCode = new ArrayList<>();
        allAccessCode.addAll(accessCodes);
        return allAccessCode;
    }

    @Override
    public List<AccessCode> findById(long id) {
        List<AccessCode> result = new ArrayList<>();
        for (AccessCode accessCode : accessCodes) {
            if (accessCode.getId() == id) result.add(accessCode);
        }
        return result;
    }

    @Override
    public Optional<AccessCode> findByToken(String token) {
        for (AccessCode accessCode : accessCodes) {
            if (accessCode.getToken().equals(token)) return Optional.of(accessCode);
        }
        return Optional.empty();
    }

    @Override
    public AccessCode save(Resident resident, AccessCode accessCode) {
        accessCode.setId(resident.getId());
        accessCode.setCreationDate();
        accessCode.setToken(tokenGenerator());
        accessCodes.add(accessCode);

        return accessCode;
    }

    @Override
    public List<AccessCode> findByResident(Resident resident) {
        long id = resident.getId();
        return this.findById(id);
    }

    private static String tokenGenerator() {
        Random random = new Random();
        int number = random.nextInt(900)+100;
        String token = "Pass" + number;
         token += tokenGenerator++;
         return token;
    }
}
