/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package person;

/**
 *
 * @author munya
 */
class Person {
    int age; String name;
    void introduce(){
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
    }}
 class Student extends Person{
     String courses;
     
     void study(){
         System.out.println("I study: "+courses);
     }
 

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        Student s = new Student();
        
        s.name="Anaclet";
        s.age=21;
        s.courses="IT";
        
        s.introduce();
        s.study();
        
        
    }
    
}
