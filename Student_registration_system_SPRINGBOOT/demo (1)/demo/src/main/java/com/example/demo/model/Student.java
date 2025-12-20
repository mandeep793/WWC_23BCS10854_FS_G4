package com.example.demo.model;

public class Student {
    private int id;
    private String name;
    private String email;
    private String course;
    public Student(int id,String name,String email,String course){
        this.id=id;
        this.name=name;
        this.email=email;
        this.course=course;
    }
    public void setID(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setEmail(String email){
        this.email=email;
    }

    public String getEmail(){
        return email;
    }
    public void setCourse(String course){
        this.course=course;
    }
    public String getCourse(String course){
        return course;
    }
} 
