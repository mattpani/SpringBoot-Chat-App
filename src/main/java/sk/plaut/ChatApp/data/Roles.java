package sk.plaut.ChatApp.data;

import javax.persistence.*;

@Entity
@Table
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;
    private String name;

    public Roles(Integer roleId, String name) {
        this.roleId = roleId;
        this.name = name;
    }

    public Roles(String name) {
        this.name = name;
    }

    public Roles() {
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "name='" + name + '\'' +
                '}';
    }
}
