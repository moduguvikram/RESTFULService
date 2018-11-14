package org.vik.rest.model;


import java.io.Serializable;


public class Student implements Serializable {



    private int id;


    private String name;


    private int age;

    public Student()
    {

    }
    public Student(String studentName, int age)
    {
        this.name = studentName;
        this.age = age;
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

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + age;
    }
}
