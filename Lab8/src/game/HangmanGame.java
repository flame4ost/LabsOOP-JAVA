package game;

import lexicon.LexiconInterface;

import java.lang.StringBuffer;

public class HangmanGame implements HangmanGameInterface {

	int triesNumber = 9;

	int incorrectGuesses = 0;
	int correctGuesses = 0;
	int tries;

	boolean rightGuess;

    char[] oneWord;
	StringBuffer guessedLetters;
	StringBuffer usedLetters;

//	List<String[]> WORDS = new ArrayList();

	boolean win;
	boolean loose;


	public HangmanGame(LexiconInterface lexicon) {
		this.oneWord = lexicon.getRandomWord().toCharArray();
		this.guessedLetters = new StringBuffer();
		this.usedLetters = new StringBuffer();
	}

    @Override
    public boolean guess(char letter) {
        for (char realLetter:this.oneWord) {
            if (realLetter == Character.toUpperCase(letter) && this.guessedLetters.indexOf(String.valueOf(Character.toUpperCase(letter))) == -1) {
                this.correctGuesses++;
				rightGuess=true;
                tries++;
                if (this.guessedLetters.indexOf(String.valueOf(Character.toUpperCase(letter))) == -1) {
                    this.guessedLetters.append(Character.toUpperCase(letter));
                }
                return true;
            }
        }
        this.incorrectGuesses++;
		rightGuess=false;
        tries++;
        return false;
    }

	@Override
	public String getPartlyGuessedWord() {
        StringBuffer partlyGuessedWord = new StringBuffer();

        for (char letter: this.oneWord) {
            if (this.guessedLetters.indexOf(String.valueOf(letter)) == -1) {
                partlyGuessedWord.append("-");
            } else {
                partlyGuessedWord.append(letter);
            }
        }
        return partlyGuessedWord.toString();
	}

	@Override
	public String getHangmanWord() {
		return new String(this.oneWord);
	}

	@Override
	public String getGuessedLetters() {
		return guessedLetters.toString();
	}

	@Override
	public boolean isGameLost() {
		loose = this.incorrectGuesses == triesNumber;
		return loose;
	}
//	if(tries==9){
//		loose = this.incorrectGuesses == triesNumber;
//	}
//	return loose;

	@Override
	public boolean isGameWon() {
		if(rightGuess == true){
				win = this.getHangmanWord().equals(this.getPartlyGuessedWord());
		}
		return win;
	}

	@Override
	public int getGuessesLeft() {
		return triesNumber-incorrectGuesses;
	}

	@Override
	public int getIncorrectGuesses() {
		return incorrectGuesses;
	}

	@Override
	public int getCorrectGuesses() {
		return correctGuesses;
	}




}
