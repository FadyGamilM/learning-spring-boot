package com.backend.customer.models;

import java.util.Objects;

public class Customer {
    // fields
    private int id;
    private String name = "";
    private String email = "";
    private String password = "";
    private int age;

    //  constructors
  //  public Customer() {}
    public Customer(int id, int age, String name, String email, String password) {
        setAge(age);
        setEmail(email);
        setId(id);
        setName(name);
        setPassword(password);
    }

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public int getAge() {
        return age;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return getId() == customer.getId() &&
                getAge() == customer.getAge() &&
                getName().equals(customer.getName()) &&
                getEmail().equals(customer.getEmail()) &&
                getPassword().equals(customer.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getPassword(), getAge());
    }



    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}