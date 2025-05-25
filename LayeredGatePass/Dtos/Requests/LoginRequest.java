package Dtos.Requests;

public class LoginRequest {
    private  long id;
    private  String email;

    public LoginRequest(long id, String email) {
        this.id = id;
        this.email = email;
    }
    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
