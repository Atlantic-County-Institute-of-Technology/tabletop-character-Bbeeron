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
        calculateHitPoints();
        calculateArmorClass();
        feats = new ArrayList<String>();

    }

    public Character(String name, int level){
        this.name = name;
        this.level = level;
        calculateHitPoints();
        calculateArmorClass();

        stth = calcStats();
        dex = calcStats();
        con = calcStats();
        intl = calcStats();
        wis = calcStats();
        cha = calcStats();
        feats = new ArrayList<String>();
    }

    public int calcStats(){
        Random rand = new Random();

        int fDie = rand.nextInt(6);
        int sDie = rand.nextInt(6);
        int tDie = rand.nextInt(6);
        int foDie = rand.nextInt(6);

        int[] compare = {fDie, sDie, tDie, foDie};

        for (int i = 0; i < compare.length; i++){
            for (int j = 1; j < compare.length-1; j++){
                if ( compare[i] < compare[j] ){
                    int temp = compare[i];
                    compare[i] = compare[j];
                    compare[j] = temp;
                }
            }
        }
        int sum = 0;
        int count = 0;
        for ( int num : compare){
            count++;
            if (count == 4){
                break;
            }
            else{
                sum += num;
            }

        }

        return sum;

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

        calculateHitPoints();
        calculateArmorClass();



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
