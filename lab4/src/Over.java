import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Games {
    private char[][] WORDS = { { 't', 'h', 'i', 's'}, { 'i', 's'}, {'a'}, {'j', 'a', 'v', 'a'},
            {'p', 'r', 'o', 'g','r', 'a', 'm','i', 'n', 'g'},{'l', 'a', 'n', 'g','u', 'a', 'e'}    };
    char[][] CODE = { { '*', '*', '*', '*'}, { '*', '*'}, {'*'}, {'*', '*', '*', '*'},
            {'*', '*', '*', '*','*', '*', '*', '*', '*', '*'},{'*', '*', '*', '*', '*', '*', '*'} };

    private int size = WORDS.length;
    private	int min = 0;
    private	int max = size;
    private	int randomNumber = min + (int)(Math.random() * max);
    private	int positionElement = randomNumber;
    private final int NUMBER_OF_ATTEMPTS = 10;

    Boolean result = false;
    Boolean answer;
    String a = new String(CODE[positionElement]);
    String b = new String(WORDS[positionElement]);
    String lastMessage;
    int count ;

    void convert(char l, int p) {
        if (WORDS[positionElement][p] == l) {
            CODE[positionElement][p] = WORDS[positionElement][p];

            if (Arrays.equals(WORDS[positionElement],CODE[positionElement])){
                result = true;
                answer = true;
            }

        } else {
            count ++;
            if (count == NUMBER_OF_ATTEMPTS){
                result = true;
                answer = false;
            }
        }
    }

    String getInfo() {
        return String.format("The word is: %s , Not a successful attempt: %s ", String.valueOf(CODE[positionElement]) , count);
    }



    String gameOver() {
        if (answer) {
            lastMessage = "The word is decrypted";
        } else{
            lastMessage = "Attempts are over, you have lost";
        }
        return lastMessage;
    }
}

