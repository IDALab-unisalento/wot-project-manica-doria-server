package it.unisalento.server.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class UserDTO {

    private int id;
    private String name;
    private String surname;
    private String role;
    private String email;
    private String password;
    private String passwordVerify;
    private String serialNumber;

    @JsonIgnore
    List<MaintenanceDTO> maintenanceList;

    private UserDTO(int id, String name, String surname, String role, String email, String password, String passwordVerify, String serialNumber) {
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

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordVerify() {
        return passwordVerify;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public static class UserDTOBuilder {
        private int id;
        private String name;
        private String surname;
        private String role;
        private String email;
        private String password;
        private String passwordVerify;
        private String serialNumber;

        public UserDTOBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public UserDTOBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserDTOBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public UserDTOBuilder setRole(String role) {
            this.role = role;
            return this;
        }

        public UserDTOBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserDTOBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserDTOBuilder setPasswordVerify(String passwordVerify) {
            this.passwordVerify = passwordVerify;
            return this;
        }

        public UserDTOBuilder setSerialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        public UserDTO build() {
            return new UserDTO(id, name, surname, role, email, password, passwordVerify, serialNumber);
        }
    }
}
