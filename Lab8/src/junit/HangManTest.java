package junit;

import org.junit.Test;
import static org.junit.Assert.*;
import game.HangmanGame;


public class HangManTest{
	
	/* 
	 * guessLetters can be modified to test different letters  
	 * however, no letter must appear twice, 
	 * do not include 'X' - it is used for 'wrong' guesses.
	 */
	
	private final static String guessLetters = "wUrSt"; 
	private final static String testString = guessLetters.toUpperCase() + guessLetters.toUpperCase();
	private final static int numGuesses = 9;
	
	@Test
	public void stringLoadedCorrectly(){
		HangmanGame hg = new HangmanGame(new TestLexicon(testString));
		assertEquals(testString, hg.getHangmanWord());	
	}
	
	@Test
	public void remainingGuessesDecreasedCorrectly(){
		HangmanGame hg = new HangmanGame(new TestLexicon(testString));
		assertEquals(numGuesses, hg.getGuessesLeft());
		for (int i = numGuesses; i >= 0; i--){
			assertEquals(i, hg.getGuessesLeft());
			assertFalse(hg.guess('X')); // always wrong
		}
	}
	
	@Test
	public void correctGuessesIncreasedCorrectly(){
		HangmanGame hg = new HangmanGame(new TestLexicon(testString));
		assertEquals(0, hg.getCorrectGuesses());
		for (int i = 0; i < guessLetters.length(); i++){
			assertEquals(i, hg.getCorrectGuesses());
			assertTrue(hg.guess(guessLetters.charAt(i))); 
		}
	}

	@Test
	public void gameWonWhenAllLettersGuessed(){
		HangmanGame hg = new HangmanGame(new TestLexicon(testString));
		assertFalse(hg.isGameWon());
		for (int i = 0; i < guessLetters.length(); i++){
			assertFalse(hg.isGameWon());
			assertTrue(hg.guess(guessLetters.charAt(i))); 
		}
		assertTrue(hg.isGameWon());
	}

	@Test
	public void gameLostWhenAllLettersGuessedIncorrectly(){
		HangmanGame hg = new HangmanGame(new TestLexicon(testString));
		assertFalse(hg.isGameLost());
		for (int i = 0; i < numGuesses; i++){
			assertFalse(hg.isGameLost());
			assertFalse(hg.guess('X')); // always wrong
		}
		assertTrue(hg.isGameLost());
	}
	
	@Test
	public void placeHoldersCorrect(){
		String placeHolderString;
		HangmanGame hg = new HangmanGame(new TestLexicon(testString));
		for (int i = 0; i < guessLetters.length(); i++){
			placeHolderString = new String(testString);
			for (int j = guessLetters.length() - 1; j >= i; j--){
				placeHolderString = placeHolderString.replaceAll(""+guessLetters.toUpperCase().charAt(j), "-");
			}
			assertEquals(placeHolderString, hg.getPartlyGuessedWord());
			char ch = guessLetters.charAt(i);
			assertTrue(hg.guess(ch));
		}
		assertEquals(testString, hg.getPartlyGuessedWord());
	}
	
	@Test
	public void guessedLettersCorrect(){
		String guessedLetters = "";
		HangmanGame hg = new HangmanGame(new TestLexicon(testString));
		assertEquals(guessedLetters, hg.getGuessedLetters());
		for (int i = 0; i < guessLetters.length(); i++){
			char ch = guessLetters.charAt(i);
			assertTrue(hg.guess(ch));
			guessedLetters += ch;
			assertEquals(guessedLetters.toUpperCase(), hg.getGuessedLetters());
		}
	}
	
	@Test
	public void onlyThreeCorrectGuesses(){
		String placeHolderString;
		HangmanGame hg = new HangmanGame(new TestLexicon(testString));
		for (int i = 0; i < 3; i++){
			placeHolderString = new String(testString);
			for (int j = guessLetters.length() - 1; j >= i; j--){
				placeHolderString = placeHolderString.replaceAll(""+guessLetters.toUpperCase().charAt(j), "-");
			}
			assertEquals(placeHolderString, hg.getPartlyGuessedWord());
			char ch = guessLetters.charAt(i);
			assertTrue(hg.guess(ch));
			assertFalse(hg.guess('X'));
			assertFalse(hg.guess('X'));
			assertFalse(hg.isGameLost());
			assertFalse(hg.isGameWon());
			assertEquals(i+1, hg.getCorrectGuesses());
			assertEquals((i+1)*2, hg.getIncorrectGuesses());
		}
		assertFalse(hg.guess('X'));
		assertFalse(hg.guess('X'));
		assertFalse(hg.guess('X'));
		assertFalse(hg.isGameWon());
		assertTrue(hg.isGameLost());
	}
	
	@Test
	public void guessedSameCorrectLetter(){
		HangmanGame hg = new HangmanGame(new TestLexicon(testString));
		for (int i = 0; i < 10; i++){
			char ch = guessLetters.charAt(0);
			hg.guess(ch); // only returns true the first time
			assertEquals(1, hg.getCorrectGuesses());
			assertEquals(i, hg.getIncorrectGuesses());
		}
	}
}



