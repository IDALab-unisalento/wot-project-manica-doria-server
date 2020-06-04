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

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<UserMaintenance> userMaintenance;

    @OneToMany(mappedBy = "user")
    private List<Message> message;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<UserMaintenance> getUserMaintenance() {
        return userMaintenance;
    }

    public void setUserMaintenance(List<UserMaintenance> userMaintenance) {
        this.userMaintenance = userMaintenance;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }
}
