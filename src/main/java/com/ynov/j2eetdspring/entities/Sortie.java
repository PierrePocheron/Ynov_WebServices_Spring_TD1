package com.ynov.j2eetdspring.entities;

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
    @Column(name = "id_address")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "street")
    private String street;

    @Column(name = "desc")
    private String desc;

    @Column(name = "date")
    private Date date;

    @Column(name = "duration")
    private Timestamp duration;

    @Column(name = "complexity")
    private Complexity complexity;

    @Column(name = "place")
    private String place;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "framing", referencedColumnName = "id_user")
    private User framing;

    @Column(name = "participating")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "participating")
    private List<User> participating = new ArrayList<User>();

    public Sortie(String name, String street, String desc, Date date, Timestamp duration, Complexity complexity, String place, User framing, List<User> participating) {
        this.name = name;
        this.street = street;
        this.desc = desc;
        this.date = date;
        this.duration = duration;
        this.complexity = complexity;
        this.place = place;
        this.framing = framing;
        this.participating = participating;
    }

    public Sortie() {

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public User getFraming() {
        return framing;
    }

    public void setFraming(User framing) {
        this.framing = framing;
    }

    public List<User> getParticipating() {
        return participating;
    }

    public void setParticipating(List<User> participating) {
        this.participating = participating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sortie sortie = (Sortie) o;
        return Objects.equals(id, sortie.id) && Objects.equals(name, sortie.name) && Objects.equals(street, sortie.street) && Objects.equals(desc, sortie.desc) && Objects.equals(date, sortie.date) && Objects.equals(duration, sortie.duration) && complexity == sortie.complexity && Objects.equals(place, sortie.place) && Objects.equals(framing, sortie.framing) && Objects.equals(participating, sortie.participating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, street, desc, date, duration, complexity, place, framing, participating);
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
