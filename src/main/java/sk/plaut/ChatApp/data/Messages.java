package sk.plaut.ChatApp.data;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String data;

    @Column(nullable = false,updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    public Messages() {
    }

    public Messages(Timestamp createAt, String data, Long userId) {
        this.createdAt = createAt;
        this.data = data;
        this.userId = userId;
    }

    public Messages(Long userId, String data) {
        this.userId = userId;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createAt) {
        this.createdAt = createAt;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


}

