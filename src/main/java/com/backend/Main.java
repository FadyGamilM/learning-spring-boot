package com.backend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.Objects;

@SpringBootApplication
@RestController
public class Main {
    // local Database
    public static List<Customer> customersDb = new ArrayList<Customer>();

    // initialize the database (seeding)
    static {
        var c1 = new Customer(1, 25, "fady gamil", "fady@gmail.com", "123456789");
        var c2 = new Customer(2, 25, "fady mokhtar", "fady@gmail.com", "852456753");
        var c3 = new Customer(3, 23, "samy samaan", "samy@gmail.com", "123456952");
        var c4 = new Customer(4, 20, "magy magdy", "magy@gmail.com", "159357654");
        var c5 = new Customer(5, 24, "ahmed ayman", "ahmed@gmail.com", "1zx4fas89");

        customersDb.addAll(List.of(c1, c2, c3, c4, c5));
        System.out.println("database seeding is done successfully !");
    }

    // => Entry point of the server
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("api/v1/customers")
    public List<Customer> GetCustomers() {
        return customersDb;
    }

    @GetMapping("/api/v1/customers/{customerId}")
    public Customer GetCustomerById (@PathVariable("customerId") Integer customerId){
        var customer = customersDb
                .stream()
                .filter(c -> c.id == customerId)
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("no customer with this id"));

        return customer;
    }

    @GetMapping("/")
    public Hello SayHello(){
        return new Hello("Hello From GET Request");
    }

    // the @RestController specifies that all methods will return json
    public record Hello(String msg){}

    // => CUSTOMER MODEL
    static class Customer {
        // fields
        private int id;
        private String name = "";
        private String email = "";
        private String password = "";
        private int age;

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

        public Customer() {}
        public Customer(int id, int age, String name, String email, String password) {
            setAge(age);
            setEmail(email);
            setId(id);
            setName(name);
            setPassword(password);
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
}
