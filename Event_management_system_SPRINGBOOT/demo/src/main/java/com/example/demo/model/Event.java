package demo.src.main.java.com.example.demo.model;

public class Event {
     //schema of event

     private int id;
     private String name;
     private String location;


     public Event(){
     }

     public Event(int id,String name,String location){
          this.id=id;
          this.name=name;
          this.location=location;
     }

     public int getId(){
        return id;
     }

     public void setId(int id){
        this.id=id;
     }

     public String getName(){
        return name;
     }

     public void setName(String name){
        this.name=name;
     }

     public String getlocation(){
        return location;
     }
     public void setlocation(String location){
        this.location=location;
     }



}
