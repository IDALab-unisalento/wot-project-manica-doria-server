package it.unisalento.server.entities;

import it.unisalento.server.DTO.UserDTO;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;
    String surname;
    String serialNumber;
    String email;
    String password;
    String role;

    public User() {
    }

    @OneToMany(mappedBy = "user")
    List<Maintenance> maintenanceList;

    public static User cvtUser(UserDTO userDTO){
        User user = new User();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setSerialNumber(userDTO.getSerialNumber());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        return user;
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
