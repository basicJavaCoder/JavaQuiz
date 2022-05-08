import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

/**
 * This is the main driver class of the Quiz
 * It will launch the Intro screen to ask the user their name
 * then launch the questions via QuizUIJOP.java which can handle the rest
 */

public class QuizDriver {

    public static void main(String[] args) throws IOException {

        //Produce the introduction screen that asks the user for their name
        JFrame quizIntro = new JFrame();
        quizIntro.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Set title and make it visible
        quizIntro.setTitle("Welcome to the Math Quiz!");
        quizIntro.setSize(900,500);
        //quizIntro.setLayout(new BorderLayout());
        quizIntro.setVisible(true);

        //Create a label introducing the user to the Quiz then add it to the frame and set visible true
        JLabel welcomeLabel = new JLabel("Java Math Quiz!");
        Font userFont = new Font(Font.SANS_SERIF, Font.PLAIN, 64);
        welcomeLabel.setFont(userFont);
        welcomeLabel.setSize(600,40);
        welcomeLabel.setBounds(200,200,200,40);
        welcomeLabel.setVisible(true);
        quizIntro.add(welcomeLabel,BorderLayout.CENTER);

        //Add a button to start
        JButton start = new JButton("Press to start Quiz!");
        start.setBackground(Color.green);
        start.setSize(200,100);
        start.setVisible(true);
        quizIntro.add(start,BorderLayout.SOUTH);

        //Make actionListener to check for start button press and to run AskUser.ask();
        //It then hides the main menu
        start.addActionListener((ActionEvent e) -> {

            quizIntro.setVisible(false);

            try {
                AskUser.ask();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        } );

    }

    //This is run when the quiz results dialog has been closed.
    public static void goodbye() {

        //Produce the introduction screen that asks the user for their name
        JFrame quizBye = new JFrame();
        quizBye.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Set title and make it visible
        quizBye.setTitle("Java Math Quiz!");
        quizBye.setSize(900,500);
        quizBye.setLayout(new BorderLayout());
        quizBye.setVisible(true);

        //Create a label introducing the user to the Quiz then add it to the frame and set visible true
        JLabel welcomeLabel = new JLabel("Thanks for playing the Maths Quiz");
        Font userFont = new Font(Font.SANS_SERIF, Font.PLAIN, 48);
        welcomeLabel.setFont(userFont);
        welcomeLabel.setSize(600,40);
        welcomeLabel.setBounds(200,200,200,40);
        welcomeLabel.setVisible(true);
        quizBye.add(welcomeLabel,BorderLayout.CENTER);

        //Add a button to quit
        JButton quitButton = new JButton("Exit!");
        quitButton.setBackground(Color.green);
        quitButton.setSize(200,100);
        quitButton.setVisible(true);
        quizBye.add(quitButton,BorderLayout.SOUTH);

        quitButton.addActionListener((ActionEvent e) -> System.exit(0));
    }

}
