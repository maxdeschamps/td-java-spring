package com.j2ee.tdspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @Column(name = "username")
    @NotNull
    @NotEmpty
    private String username;

    @Column(name = "firstname")
    @NotNull
    @NotEmpty
    private String firstname;

    @Column(name = "lastname")
    @NotNull
    @NotEmpty
    private String lastname;

    @Column(name = "telephone")
    @NotNull
    @NotEmpty
    private String telephone;

    @ManyToMany(mappedBy = "participants")
    @JsonIgnore
    private List<Sortie> sorties;

    @Column(name = "role")
    private String role;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Sortie> getSorties() {
        return sorties;
    }

    public void setSorties(List<Sortie> sorties) {
        this.sorties = sorties;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
