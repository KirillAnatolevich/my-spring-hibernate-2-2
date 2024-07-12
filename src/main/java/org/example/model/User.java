package org.example.model;


import org.springframework.context.annotation.Scope;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    // cascade = CascadeType.ALL - означает, что мы удаляем дочерний класс вместе с основным автоматически
    // fetch - определяет как целевой объект извлекается из бд (FetchType.EAGER (загружается сразу с помощью объекта-владельца) FetchType.LAZY (загружается по запросу при доступе))
    // mappeby - установка владельца связи (без нее связь однонаправленная)
    // optional (не обязательно) - если optional = true то объект для связи должен быть всегда (по умолчанию false)
    // orphanRemoval - следует ил применять операцию удаления к объектам, которые были удалены из отношения и каскадировать операцию удаления этих объектов
    // targetEntity - класс сущности, который является целью операции

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

    public User(String firstName, String lastName, String email, Car car) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.car = car;
    }
    public Car getCar() {
        return car;
    }public void setCar(Car car) {
        this.car = car;
    }
    public User() {}

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
