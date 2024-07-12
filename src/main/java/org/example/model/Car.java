package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "series")
    private int series;
    @Column(name = "model")
    private String model;
    // mappedBy - имя поля, которому принадлежит связь //,
    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    //@JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;
    public Car() {
    }

    public Car(int series, String model) {
        this.series = series;
        this.model = model;
    }

    public Car(int series, String model, User user) {
        this.series = series;
        this.model = model;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getId() {
        return id;
    }
}
