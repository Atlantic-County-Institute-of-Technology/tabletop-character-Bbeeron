import java.util.*;
class Character {
    protected int stth;
    protected int dex;
    protected int con;
    protected int intl;
    protected int wis;
    protected int cha;
    protected String name;
    protected int level;
    protected int hp;
    protected int ac;
    protected ArrayList<String> feats;

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
            hp += (10 + getAbilityModifier(con));
        }
        else{
            hp += ((level - 1) * (6 + getAbilityModifier(con)));
        }
    }

    public void calculateArmorClass(){
        ac += (10 + getAbilityModifier(dex));
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


}

class Paladin extends Character {

    public Paladin(String name, int level){
        super(name, level);

        stth+=2;

        cha+=1;

    }

    @Override
    public String toString() {
        String clas = "Paladin";
        return "Character: " + name + " Level: " + level + " Class: " + clas +
                "\nHP: " + hp + " | " + " AC: " + ac +
                "\nSTR: " + stth + "(+2) | " + " DEX: " + dex + " | " + " CON: " + con +
                "\nINT: " + intl + " | " + " WIS: " + wis + " | " + " CHA: " + cha + "(+1) " +
                "\nFeats: " + feats;
    }
}

public class Main {
    public static void main(String[] args){
        Paladin myPal = new Paladin("Ty", 4);

        myPal.addFeat("Divine Smite");
        myPal.addFeat("Aura of Protection");

        System.out.println(myPal);

        myPal.levelUp();

        System.out.println("\n" + myPal);

        Paladin myPal2 = new Paladin("Fyne", 9);

        myPal2.addFeat("Divine Smite");
        myPal2.addFeat("Aura of Protection");

        System.out.println("\n" + myPal2);
    }
}
