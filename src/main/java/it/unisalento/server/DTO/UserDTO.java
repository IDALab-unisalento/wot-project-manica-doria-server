package it.unisalento.server.DTO;

public class UserDTO {

    int id;
    String name;
    String surname;
    String type;
    String email;
    String password;
    String passwordVerify;

    public UserDTO() {
    }

    public UserDTO(int id, String name, String surname, String type, String email, String password, String passwordVerify) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.type = type;
        this.email = email;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}
