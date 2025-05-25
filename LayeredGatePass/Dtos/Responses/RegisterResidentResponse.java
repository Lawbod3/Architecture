package Dtos.Responses;

import Data.Models.Resident;

public class RegisterResidentResponse {
    private Resident resident;
    private String residentFullName;
    private String residentEmail;
    private String residentPhoneNumber;
    private String residentAddress;

    public String getResidentFullName() {
        return residentFullName;
    }

    public void setResidentFullName(String residentFullName) {
        this.residentFullName = residentFullName;
    }

    public String getResidentEmail() {
        return residentEmail;
    }

    public void setResidentEmail(String residentEmail) {
        this.residentEmail = residentEmail;
    }

    public String getResidentPhoneNumber() {
        return residentPhoneNumber;
    }

    public void setResidentPhoneNumber(String residentPhoneNumber) {
        this.residentPhoneNumber = residentPhoneNumber;
    }

    public String getResidentAddress() {
        return residentAddress;
    }

    public void setResidentAddress(String residentAddress) {
        this.residentAddress = residentAddress;
    }
}
