package it.unisalento.server.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String serialNumber;
    private String email;
    private String password;
    private String role;

    @OneToMany(mappedBy = "user")
    List<Maintenance> maintenanceList;

    public User() {
    }

    public User(int id, String name, String surname, String serialNumber, String email, String password, String role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.serialNumber = serialNumber;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public User setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setRole(String role) {
        this.role = role;
        return this;
    }

    public User setMaintenanceList(List<Maintenance> maintenanceList) {
        this.maintenanceList = maintenanceList;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public List<Maintenance> getMaintenanceList() {
        return maintenanceList;
    }
}
