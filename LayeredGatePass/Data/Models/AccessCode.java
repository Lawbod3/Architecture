package Data.Models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AccessCode {
    private long accessCode;
    private long id;
    private LocalDateTime creationDate;
    private LocalDate expirationDate;
    private boolean active;

    public void setAccessCode(long accessCode) {
        this.accessCode = accessCode;
    }
    public long getAccessCode() {
        return accessCode;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    public void setExpirationDate() {
        this.expirationDate = this.creationDate.toLocalDate().plusDays(3);
    }
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

}
