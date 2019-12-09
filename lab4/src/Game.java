import java.util.*;

class Game {
    private char[] word, code;
    private int size;
    private	int min = 0;
    private	int max = size;
    private	int randomNumber = min + (int)(Math.random() * max);
    private	int positionElement = randomNumber;
    private final int NUMBER_OF_ATTEMPTS = 10;

    boolean result = false;
    boolean answer;
    String a;
    String b;
    String lastMessage;
    int count ;

    Game(char[] word) {
        this.word = word;
        size = word.length;
        code = new char[size];
        for (int i = 0; i < size; i++) {
            code[i] = '*';
        }
        a = new String(code);
        b = new String(word);
    }

    void convert(char l, int p) {
        if (word[p] == l) {
            code[p] = word[p];

            if (Arrays.equals(word,code)){
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
        return String.format("The word is: %s , Not a successful attempt: %s ", String.valueOf(code) , count);
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

