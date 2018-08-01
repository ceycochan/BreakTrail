package com.nshane.breaktrail.bean;

/**
 * Created by bryan on 2018-7-26.
 */

public class Person {
    private int age;
    private String name;
    private String gender;

    public Person(int age, String name, String gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }


    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }


    public Person(int age) {
        this.age = age;
    }


    public Person(String name) {
        this.name = name;
    }
}
