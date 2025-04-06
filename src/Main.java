// Byron Manuel
// 04-04-25
// AP Comp Sci
// Mr. Costantino

import java.util.*;     // Imports all known libraries in Java

class Character {       // Character class initializes basic character creation for DnD
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
    protected ArrayList<String> feats;      // All variables label different parts of a character

    public Character(){     // For character initialization
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

    public Character(String name, int level){       // Used by subclasses to base out of
        this.name = name;
        this.level = level;
        calculateHitPoints();
        calculateArmorClass();

        stth = calcStats();     // Function calcStats() offers a random sum for ability scores
        dex = calcStats();
        con = calcStats();
        intl = calcStats();
        wis = calcStats();
        cha = calcStats();
        feats = new ArrayList<String>();
    }

    public int calcStats(){     // Takes the biggest three out of four "dice-rolls" (random integer out of 6) and sums them
        Random rand = new Random();

        int fDie = rand.nextInt(6);
        int sDie = rand.nextInt(6);
        int tDie = rand.nextInt(6);
        int foDie = rand.nextInt(6);

        int[] compare = {fDie, sDie, tDie, foDie};

        for (int i = 0; i < compare.length; i++){
            for (int j = 1; j < compare.length-1; j++){
                if ( compare[i] < compare[j] ){     // Sorts though the list to make sure the three biggest nums are in the front
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
                sum += num; // Adds the first three integers
            }

        }

        return sum;

    }

    public void calculateHitPoints(){       // Calculate how much health a character has based on added modifiers
        if (level == 1){
            hp += (10 + getAbilityModifier(con));
        }
        else{
            hp += ((level - 1) * (6 + getAbilityModifier(con)));
        }
    }

    public void calculateArmorClass(){          // Calculates armor based on added modifiers
        ac += (10 + getAbilityModifier(dex));
    }


    public int getAbilityModifier(int score){       // Checks whether there are changes made on the current ability sum
        return (int) Math.floor((double) (score - 10) / 2);
    }

    public void levelUp(){          // Increments a character's level, health, and armorclass
        level+=1;

        calculateHitPoints();
        calculateArmorClass();



    }

    public void addFeat(String feat){       // Adds a string into the arrayList
        feats.add(feat);
    }


}

class Paladin extends Character {       // Subclass uses the given superclass (Character) and inherits variables and functions

    public Paladin(String name, int level){     // Based on the Character() function, takes the name and level from character
        super(name, level);

        stth+=2;
                    // Adds the class modifiers
        cha+=1;

    }

    @Override
    public String toString() {      // Formats output for clearer perspective
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
        Paladin myPal = new Paladin("Ty", 4);       // Test 1, creates Paladin subclass

        myPal.addFeat("Divine Smite");
        myPal.addFeat("Aura of Protection");        // Adds into arraylist using the addFeat method

        System.out.println(myPal);

        myPal.levelUp();        // Testing level-up function to ensure the calculations work

        System.out.println("\n" + myPal);

        Paladin myPal2 = new Paladin("Fyne", 9);

        myPal2.addFeat("Divine Smite");
        myPal2.addFeat("Aura of Protection");

        System.out.println("\n" + myPal2);
    }
}
