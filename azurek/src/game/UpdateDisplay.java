import src.CreatureAction;

package src;
public class UpdateDisplay extends CreatureAction{
    UpdateDisplay(String name, Creature owner){
        System.out.println("UpdateDisplay name: " + name);
    }
}