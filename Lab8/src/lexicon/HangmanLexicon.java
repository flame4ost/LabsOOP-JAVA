package lexicon;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangmanLexicon implements LexiconInterface {

	private ArrayList<String> wordsCollection = new ArrayList<>();

	public HangmanLexicon() {
		try {
			Scanner wordScanner = new Scanner(new File("C:\\Users\\User\\Desktop\\2course\\1sem\\OOP\\Lab-8\\Lexicon.txt"));

			while (wordScanner.hasNext()){
				this.wordsCollection.add(wordScanner.next().replaceAll("[^A-z]", "").trim().toUpperCase());
			}
			wordScanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	private Collection<String> getWordFromCollection()throws IOException{
//		FileReader getLexicon = new FileReader("C:\\Users\\User\\Desktop\\2course\\1sem\\OOP\\Lab-8\\Lexicon.txt");
//		Collection<String> wordsCollection = new ArrayList<>();
//		StringBuilder newString = new StringBuilder();
//		int i;
//		while((i=getLexicon.read()) != -1){
//			newString.append((char) i);
//		}
//		String[] differentStrings = newString.toString().split("\\s*(\\s|,|!|\\.)\\s*");
//		for(String string:differentStrings){
//			if(string.isEmpty()&& string.length()>3){
//				wordsCollection.add(string.replace("'","").trim());
//			}
//		}
//
//		return wordsCollection;
//	}

	@Override
	public int getWordCount() {
		return this.wordsCollection.size();
	}

	@Override
	public String getWord(int index) {
		return this.wordsCollection.get(index);
	}

	@Override
	public String getRandomWord() {
		Random randomWord = new Random();
		return this.getWord(randomWord.nextInt(this.getWordCount()));
		//return getWord((int) (Math.random()*(wordsCollection.size())));
	}


}
