import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Panel {
    private JFrame frame;
    private JFrame frame1;
    private JPanel panel;
    private JPanel panel1;
    private JPanel lastPanel;
    private JButton btn;
    private JLabel info;
    private JTextField letter;
    private JTextField position;
    private int positionSymbol;
    private char symbol;
    private String rules;
    private Game convert;

    Panel() {
        this.frame = new JFrame();
        this.frame1 = new JFrame();
        this.panel = new JPanel();
        this.panel1 = new JPanel();
        this.btn = new JButton("Play");
        this.letter = new JTextField();
        this.position = new JTextField();
        Words words = new Words();
        this.convert = new Game(words.getWord(0));
        this.info = new JLabel();
        this.buildPanel();
    }

    private void buildPanel() {
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.letter.setPreferredSize(new Dimension(30, 20));
        this.position.setPreferredSize(new Dimension(30, 20));

        this.panel.add(new JLabel("Encrypted word it is: " + this.convert.a + "  " + "word: " + this.convert.b));
        this.panel.add(new JLabel("Words: "));
        this.panel.add(this.letter);
        this.panel.add(new JLabel("Position: "));
        this.panel.add(this.position);
        this.panel.add(this.btn);
        this.panel.add(this.info);
        this.panel1.add(new JLabel("<html>Rules<br>1) You get the encrypted word in the form of '***' <br> 2) You must enter in the first text field the letter a in the second position of this letter in the word -1 <br> 3) If you entered the correct data then this letter will be replaced with '*' to the correct one. <br> 4) You have the opportunity to enter the data 10 times incorrectly, after which the game will be completed. <br> 5) The game is played until the whole word is guessed.</html>"));
        this.frame1.setContentPane(this.panel1);
        this.frame.setContentPane(this.panel);
        this.frame.setSize(340, 150);
        this.frame.setVisible(true);

        this.frame1.setSize(650, 150);
        this.frame1.setVisible(true);

        this.btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String someText = letter.getText();
                symbol = someText.charAt(0);
                positionSymbol = Integer.parseInt(position.getText());
                convert.convert(symbol, positionSymbol);
                info.setText(convert.getInfo());
                if (convert.result == true){
                    buildOverTheGame();
                }
            }
        });
    }

    private void buildOverTheGame() {
        this.lastPanel = new JPanel();
        this.lastPanel.add(new JLabel("Game Over:  " + this.convert.gameOver()));
        this.frame.setContentPane(this.lastPanel);
        this.frame.setSize(300,150);
    }
}


