package com.example.demo.service;
import com.example.demo.model.Student;
import java.util.List;
import java.util.ArrayList;
public class Studentservice {

    private List<Student> students=new ArrayList<>();

    public List<Student> getAllStudents(){
        return students;
    }
    public Student getStudentbyId(int id){
        for(Student stu:students){
            if(stu.getId()==id){
                return stu;
            }
        }
        return null;
    }
    public void addStudent(int id,String name,String email,String course){
        int new_id=id;
        String new_name=name,new_email=email,new_course=course;
        Student s=new Student(new_id,new_name,new_email,new_course);
        students.add(s);
    }

    public Student deleteStudent(int id){
        Student ans=null;
        for(Student stu:students){
            if(stu.getId()==id){
                students.remove(stu);
                ans=stu;
            }
        }
        return  ans;
    }

}
