package com.ynov.j2eetdspring.entities;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(name = "sortie")
public class Sortie {

    public enum Complexity {
        TRES_FACILE,
        FACILE,
        MOYENNE,
        DIFFICILE,
        TRES_DIFFICILE;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sortie")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "street")
    private String street;

    @Column(name = "description")
    private String desccription;

    @Column(name = "date")
    private Date date;

    @Column(name = "duration")
    private Timestamp duration;

    @Column(name = "complexity")
    private Complexity complexity;

    @Column(name = "place")
    private String place;

    @ManyToMany
    @JoinColumn(name = "sorties")
    private List<User> participating;

    public Sortie(Long id, String name, String street, String desccription, Date date, Timestamp duration, Complexity complexity, String place, List<User> participating) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.desccription = desccription;
        this.date = date;
        this.duration = duration;
        this.complexity = complexity;
        this.place = place;
        this.participating = participating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDesccription() {
        return desccription;
    }

    public void setDesccription(String desccription) {
        this.desccription = desccription;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Timestamp getDuration() {
        return duration;
    }

    public void setDuration(Timestamp duration) {
        this.duration = duration;
    }

    public Complexity getComplexity() {
        return complexity;
    }

    public void setComplexity(Complexity complexity) {
        this.complexity = complexity;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public List<User> getParticipating() {
        return participating;
    }

    public void setParticipating(List<User> participating) {
        this.participating = participating;
    }

    public Sortie() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
