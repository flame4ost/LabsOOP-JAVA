package lexicon;

public interface LexiconInterface {
	
	/*
	 * returns number of words in this lexicon
	 */
	public abstract int getWordCount();
	/* 
	 * returns n-th word from lexicon 
	 */
	public abstract String getWord(int index);
	/* 
	 * returns a random word from the lexicon
	 */
	public abstract String getRandomWord();
}

