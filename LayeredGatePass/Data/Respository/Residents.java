package Data.Respository;

import Data.Models.Resident;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Residents implements ResidentRepository{
    private static int idGenerator = 0;
   private  static   List<Resident> residents = new ArrayList<Resident>();
    @Override
    public long count() {
        return residents.size();
    }

    @Override
    public void delete(Resident resident) {
        residents.remove(resident) ;

    }

    public void clear(){
        idGenerator = 0;
        residents.clear();
    }

    @Override
    public void delete(long id) {
        delete(findById(id).get()); ;

    }

    @Override
    public List<Resident> findByFullNameName(String fullNameName) {
        List<Resident> result = new ArrayList<>();
        for (Resident resident : residents) {
            if (resident.getFullName().equals(fullNameName)) result.add(resident);

        }
        return result;
    }


    @Override
    public List<Resident> findAll() {
        return List.of((Resident) residents);
    }

    @Override
    public Optional<Resident> findById(long id) {
        for (Resident resident : residents) {
            if (resident.getId() == id) {
                return Optional.of(resident);
            }
        }

        return Optional.empty();
    }

    @Override
    public Resident save(Resident resident) {
        if(isNew(resident))saveResident(resident); else update(resident);

        return resident;
    }

    private void update(Resident resident) {
        delete( findById(resident.getId()).get());
        residents.add(resident);
    }

    private void saveResident(Resident resident) {
        resident.setiD(generateId());
        residents.add(resident);
    }

    private boolean isNew(Resident resident) {
        if (resident.getId()  == 0)  return true;
        return false;
    }

    private long generateId() {
        return ++idGenerator;
    }
}
