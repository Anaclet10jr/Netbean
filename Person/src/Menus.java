class Friday{
    String name;
    int age;
    Friday(String name,int age){
        this.name=name;
        this.age=age;
        System.out.println("Constructor is gonna be called up");
    }
}
class Sunday extends Friday{
    String Weight;
    Sunday(String name, int age, String newWeight){
        super(name,age);
        Weight=newWeight;
    }
    void display(){
        System.out.println("name: "+name);
        System.out.println("age: "+ age);
        System.out.println("weight: "+ Weight);
    }
}
public class Menus{
    public static void main(String args[]){
        Sunday s1= new Sunday("ana",21,"200");
        s1.display();
    }
}