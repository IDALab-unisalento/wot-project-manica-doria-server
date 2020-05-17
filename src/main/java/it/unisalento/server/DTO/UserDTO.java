package it.unisalento.server.DTO;

import it.unisalento.server.entities.User;

public class UserDTO {

    int id;
    String name;
    String surname;
    String role;
    String email;
    String password;
    String passwordVerify;
    String serialNumber;

    public UserDTO() {
    }

    public UserDTO(int id, String name, String surname, String role, String email, String password, String passwordVerify, String serialNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.email = email;
        this.serialNumber = serialNumber;
        this.password = password;
        this.passwordVerify = passwordVerify;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getPasswordVerify() {
        return passwordVerify;
    }

    public void setPasswordVerify(String passwordVerify) {
        this.passwordVerify = passwordVerify;
    }

    @Override
    public String toString() {
        return "{" +
                "name: " + this.name +
                ",\nsurname: " + this.surname +
                ",\nemail: " + this.email +
                ",\nrole: " + this.role +
                ",\nserialNumber: " + this.serialNumber +
                "}";

    }

    public static UserDTO cvtUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setRole(user.getRole());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
}
