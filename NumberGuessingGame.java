import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGuessingGame {
    private int targetNumber;
    private int attempts;
    private JFrame frame;
    private JTextField inputField;
    private JButton guessButton;
    private JLabel messageLabel;

    public NumberGuessingGame() {
        Random rand = new Random();
        targetNumber = rand.nextInt(100) + 1;
        attempts = 0;
        
        frame = new JFrame("Number Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        JLabel instructionLabel = new JLabel("Guess a number between 1 and 100:");
        frame.add(instructionLabel);

        inputField = new JTextField(10);
        frame.add(inputField);

        guessButton = new JButton("Guess");
        guessButton.setBackground(Color.GREEN);
        frame.add(guessButton);

        messageLabel = new JLabel("Start guessing!");
        frame.add(messageLabel);
        
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
        JButton guessButton1 = new JButton("New");
        guessButton1.setBackground(Color.RED);
        frame.add(guessButton1);
        
        frame.setVisible(true);
    }

    private void checkGuess() {
        try {
            int guess = Integer.parseInt(inputField.getText());
            attempts++;
            if (guess < 1 || guess > 100) {
                messageLabel.setText("Please enter a number between 1 and 100.");
            } else if (guess < targetNumber) {
                messageLabel.setText("Too low! Try again.");
            } else if (guess > targetNumber) {
                messageLabel.setText("Too high! Try again.");
            } else {
                messageLabel.setText("Correct! You guessed it in " + attempts + " attempts.");
                guessButton.setEnabled(false);
            }
        } catch (NumberFormatException ex) {
            messageLabel.setText("Invalid input. Enter a number!");
        }
    }

    public static void main(String[] args) {
        new NumberGuessingGame();
    }
}