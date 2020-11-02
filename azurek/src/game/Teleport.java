package game;

import src.CreatureAction;
public class Teleport extends CreatureAction{
    Teleport(String name, Creature owner){
        System.out.println("Teleport name: " + name);
    }
}