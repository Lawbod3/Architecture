package Data.Models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AccessCode {
    private String token;
    private long id;
    private LocalDate creationDate;
    private LocalDate tenderDate;
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
    public String getCreationDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return creationDate.format(formatter);
    }
    private void setExpirationDate() {
        this.expirationDate = this.creationDate.plusDays(3);
    }
    public String getExpirationDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return this.expirationDate.format(formatter);
    }
    private void setTenderDate() {
        this.tenderDate = LocalDate.now();
    }
    public String getTenderDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return this.tenderDate.format(formatter);
    }

    public boolean isActive() {
        return active;
    }
    public void used(Visitors visitor) {
        this.active = false;
        this.setTenderDate();
        this.visitor = visitor;
    }
    public Visitors getVisitor() {
        return visitor;
    }

}
