package Data.Models;

import java.time.LocalDate;

public class AccessCode {
    private String token;
    private long id;
    private LocalDate creationDate;
    private LocalDate expirationDate;
    private boolean active;
    private Visitors visitor;

    public void setToken(String token) {
        this.token = token;
    }
    public String getToken() {
        return token;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }
    public void setCreationDate() {
        this.creationDate = LocalDate.now();
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }
    private void setExpirationDate() {
        this.expirationDate = this.creationDate.plusDays(3);
    }
    public LocalDate getExpirationDate() {
        return expirationDate;
    }
    public boolean isActive() {
        return active;
    }
    public void isUsed(Visitors visitor) {
        this.active = false;
        this.visitor = visitor;
    }
    public Visitors getVisitor() {
        return visitor;
    }

}
