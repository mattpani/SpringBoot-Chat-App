package sk.plaut.ChatApp.data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Table
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Roles> roles = new HashSet<>();


    public Users() {
    }

    public Users(String username, Set<Roles> roles) {
        this.username = username;
        this.roles = roles;
    }

    public Users(Long id, String username, Set<Roles> roles) {
        this.userId = id;
        this.username = username;
        this.roles = roles;
    }

    public Long getId() {
        return userId;
    }

    public void setId(Long id) {
        this.userId = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles.add(roles);
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + userId +
                ", username='" + username + '\'' +
                ", roles=" + roles +
                '}';
    }
}

