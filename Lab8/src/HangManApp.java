import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.HangmanGame;
import lexicon.HangmanLexicon;

public class HangManApp  {

	private static final int WIDTH = 400;
	private static final int HEIGHT = 200;

	private HangmanGame hangmanGame;

	private JTextField letter;

	private JLabel word;
	private JLabel guessesLeft;
	private JLabel guessesLeftLabel;

	HangManApp(){

		this.buildMainPanel();
		this.restart();
		this.refreshWord();
	}
	private void buildMainPanel() {
		JFrame mainFrame = new JFrame("Guess a word game");

		mainFrame.setSize(new Dimension(HangManApp.WIDTH, HangManApp.HEIGHT));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);

		JPanel mainPanel = new JPanel();

		mainPanel.add(new JLabel("Letter: "));

		this.letter = new JTextField();
		this.letter.setPreferredSize(new Dimension(100, 20));
		mainPanel.add(this.letter);

		JButton check = new JButton("Check");
		mainPanel.add(check);

		mainPanel.add(new JLabel("Word: "));

		this.word = new JLabel();
		mainPanel.add(this.word);

		JPanel optionsPanel = new JPanel();

		JButton restart = new JButton("Restart");
		optionsPanel.add(restart);
		JButton showWord = new JButton("Show Real Word");
		optionsPanel.add(showWord);

		optionsPanel.add(new JLabel("Tries left: "));
		this.guessesLeftLabel = new JLabel();
		optionsPanel.add(this.guessesLeftLabel);

		this.guessesLeft = new JLabel();
		optionsPanel.add(this.guessesLeft);

		mainFrame.setLayout(null);
		mainFrame.add(mainPanel);
		mainPanel.setBounds(1,1 ,380,40);
		mainFrame.add(optionsPanel);
		optionsPanel.setBounds(1,41 ,380,100);

		mainFrame.getContentPane().setVisible(false);
		mainFrame.getContentPane().setVisible(true);

		check.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkLetter();
				letter.setText("");
			}
		});
		restart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				restart();
				refreshWord();
			}
		});

		showWord.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,hangmanGame.getHangmanWord());
			}
		});
	}

	private void restart() {

		this.hangmanGame = new HangmanGame(new HangmanLexicon());
	}

	private void refreshWord() {
		this.word.setText(this.hangmanGame.getPartlyGuessedWord());
		this.guessesLeft.setText(String.valueOf(this.hangmanGame.getGuessesLeft()));
	}

	private void checkLetter() {
		this.hangmanGame.guess(this.letter.getText().charAt(0));

		if (this.hangmanGame.isGameWon()) {
			JOptionPane.showMessageDialog(null,"You won");
			this.restart();
		} else if (this.hangmanGame.isGameLost()) {
			JOptionPane.showMessageDialog(null,"You lost");
			this.restart();
		}
		this.refreshWord();
	}

}


