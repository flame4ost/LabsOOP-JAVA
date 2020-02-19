package game;

public interface HangmanGameInterface   {

	/*
	 * Guess a character. letter may be an uppercase or lowercase character
	 * from A to Z. Returns a boolean value indicating whether the guess was
	 * correct, i.e. the letter was found in the word and has not been guessed 
	 * before.
	 */
	public abstract boolean guess(char letter);

	/*
	 * Returns the current state of the guessed word. Contains placeholders for
	 * non-guessed letters and uppercase-letters for the correctly guessed
	 * letters. Examples: "----", "--LL", "B-LL", "BALL"
	 */
	public abstract String getPartlyGuessedWord();
	
	/*
	 * Returns the complete word that the user should guess, without placeholders.
	 * May be used for testing purposes, or to show the correct solution if the
	 * game is lost. String should be uppercase
	 */
	public abstract String getHangmanWord();

	/* 
	 * returns a String containing all *unique* letters in the order they were
	 * guessed. Example: guessed: X-A-X-B -> "XAB" 
	 */
	public abstract String getGuessedLetters();

	/* 
	 * returns true if the user has guessed incorrectly 9 or more times
	 */
	public abstract boolean isGameLost();
	/* 
	 * returns true if the user has guessed all letters appearing in the word 
	 * with less than 9 incorrect guesses 
	 */
	public abstract boolean isGameWon();
	/* 
	 * returns number of guesses left until losing the game 
	 */
	public abstract int getGuessesLeft();
	/* 
	 * returns number of incorrect guesses.
	 * getGuessesLeft() + getIncorrectGuesses == 9
	 */
	public abstract int getIncorrectGuesses();
	
	/* 
	 * returns number of correct guesses so far.
	 */
	public abstract int getCorrectGuesses();


}