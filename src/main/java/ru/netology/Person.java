package ru.netology;

import java.util.Optional;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age = -1;
    protected String address = null;
    protected String nameChild;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setName(nameChild)
                .setSurname(this.surname)
                .setAddress(this.address);
    }

    public boolean hasAge() {
        return age != -1 ? true : false;
    }

    public boolean hasAddress() {
        return address != null ? true : false;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return hasAge() ? OptionalInt.of(age) : OptionalInt.empty();
    }

    public String getAddress() {
        return hasAddress() ? address : "";
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }

    @Override
    public String toString() {
        return "имя: " + name + " фамилия: " + surname + " возраст: " + age + " адрес: " + address;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (name != null ? name.hashCode() : 0);
        result = prime * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }
}
