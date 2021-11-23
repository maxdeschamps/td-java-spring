package com.j2ee.tdspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sortie")
public class Sortie implements Serializable {
    @Id
    @Column(name = "identifiant")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer identifiant;

    @NotNull
    @NotEmpty
    @Column(name = "nom")
    private String nom;

    @Column(name = "description")
    private String description;

    @Column(name = "date_sortie")
    private Date dateSortie;

    @Column(name = "duree")
    private Integer duree;

    @Column(name = "complexite")
    private Integer complexite;

    @Column(name = "lieu")
    private String lieu;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "participations",
            joinColumns = @JoinColumn(name = "identifiant"),
            inverseJoinColumns = @JoinColumn(name = "username"))
    private List<User> participants;

    public Integer getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(Integer identifiant) {
        this.identifiant = identifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public Integer getComplexite() {
        return complexite;
    }

    public void setComplexite(Integer complexite) {
        this.complexite = complexite;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void addParticipant(User user) {
        if (!participants.contains(user)) {
            this.participants.add(user);
        }
    }

    public void removeParticipant(User user) {
        this.participants.remove(user);
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

}
