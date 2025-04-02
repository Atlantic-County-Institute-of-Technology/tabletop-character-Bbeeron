import java.util.*;
class Character {
    private int stth;
    private int dex;
    private int con;
    private int intl;
    private int wis;
    private int cha;
    private String name;
    private int level;
    private int hp;
    private int ac;
    private ArrayList<String> feats;

    public Character(){
        stth = 10;
        dex = 10;
        con = 10;
        intl = 10;
        wis = 10;
        cha = 10;
        name = "Player";
        level = 1;
        hp = 10;
        ac = 10;
        feats = new ArrayList<String>();

    }

    public Character(String name, int level){
        ;
    }

    public void calculateHitPoints(){
        if (level == 1){
            hp += (10 + con);
        }
        else{
            hp += ((level - 1) * (6 + con));
        }
    }

    public void calculateArmorClass(){
        ac += (10 + dex);
    }


    public int getAbilityModifier(int score){
        return (int) Math.floor((double) (score - 10) / 2);
    }

    public void levelUp(){
        level+=1;

        hp += 1;

        ac += 1;



    }

    public void addFeat(String feat){
        feats.add(feat);
    }

    @Override
    public String toString() {
        return "Character: " + name + "Level: " + "Class" +
                "\nHP: " + hp + " | " + " AC: " + ac +
                "\nSTR: " + stth + " | " + " DEX: " + dex + " | " + " CON: " + con +
                "\nINT: " + intl + " | " + " WIS: " + wis + " | " + " CHA: " + cha +
                "\nFeats: " + feats;
    }
}

public class Main {
    public static void main(String[] args){

    }
}
