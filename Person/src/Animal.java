/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author munya
 */
class Animals{
    void makeSound(){
        System.out.println("Animal make sound! ");
    }
    
}
class Dog extends Animals{
    @Override
    void makeSound(){
        System.out.println("Dog Barks");
    }
    public static void main(String[] args){
        Dog d = new Dog();
         d.makeSound();
    }
}
