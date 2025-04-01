import java.util.ArrayList;
class Character {
    private int strength;
    private int dexterity;
    private int vitality;
    private int wisdom;
    private int charisma;
    private String name;
    private int level;
    private int health;
    private int defense;
    private ArrayList<String> feats;

    public Character(){
        strength = 10;
        dexterity = 10;
        vitality = 10;
        wisdom = 10;
        charisma = 10;
        name = "Player";
        level = 1;
        health = 10;
        defense = 10;
        feats = new ArrayList<>();

    }

    public Character(String name, int level){
        ;
    }

    public void calculateHitPoints(){
        if (level == 1){
            health += (10 + vitality);
        }
        else{
            health += ((level - 1) * (6 + vitality));
        }
    }

    public void calculateArmorClass(){
        defense += (10 + dexterity);
    }


    public int getAbilityModifier(int score){
        return score;
    }

    public void levelUp(){
        ;
    }

    public void addFear(String feat){
        ;
    }



}

public class Main {
    public static void main(String[] args){

    }
}
