package com.sunilkumar.sqlite.usingsqlite;

/**
 * Created by Sunilkumar on 12-12-2016.
 */

public class Student {
    int id;
    String name;
    int age;
    float cgpa;

    public Student(int id, String name, int age, float cgpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.cgpa = cgpa;
    }

    public Student(String name, int age, float cgpa) {
        this.name = name;
        this.age = age;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }
}
