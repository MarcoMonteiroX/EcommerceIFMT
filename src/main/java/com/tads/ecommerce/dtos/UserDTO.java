package com.tads.ecommerce.dtos;

import com.tads.ecommerce.entities.User;

public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String birthDate;
    private String password;

    public UserDTO() {
    }

    public UserDTO(Long id, String name, String email, String phone, String birthDate, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.password = password;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.birthDate = user.getBirthDate();
        this.password = user.getPassword();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getPassword() {
        return password;
    }
}
