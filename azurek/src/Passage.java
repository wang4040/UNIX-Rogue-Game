package src;
public class Passage extends Structure{
    Passage(){
        System.out.println("Passage");
    }

    void setName(String s){
        System.out.println("setName s: " + s);
    }

    void setID(int room1, int room2){
        System.out.println("setID room1: " + room1 + " room2: " + room2);
    }
}