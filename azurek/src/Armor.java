public class Armor extends Item{
    Armor(String name){
        System.out.println("Armor");
    }

    void setName(String s){
        System.out.println("setName Armor");
    }

    void setID(int room, int serial){
        System.out.println("SetID Armor");
    }
}