package main;

import scene.Dialog;

import java.util.ArrayList;
import java.util.Random;

/**
 * A játékban megadott randomizálásnak függően generál random számot
 */
public class RandomNumber {
    static public boolean isRandomEnabled = true;

    /**
     * Reseteli a kezdő isRandomEnabled defaultra, ami true.
     */
    public static void resetAutoIncrement(){
        isRandomEnabled = true;
    }
    /**
     * visszatér egy számmal a randomizálásnak megfelelően, 0 <= x < maxNum
     * @param maxNum ennél csak kisebb számokkal tér vissza
     * @return a megadott szám
     */
    static public int getNumber(int maxNum){
        if (isRandomEnabled) {
            return new Random().nextInt(maxNum);
        } else {
            ArrayList<String> numbers = new ArrayList<String>();
            for (int i = 0; i < maxNum; i++) {
                numbers.add(String.valueOf(i));
            }
            Dialog numberDialog = new Dialog("Manual random select", numbers);
            return numberDialog.ShowDialog();
        }
    }
}
