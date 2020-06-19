import javax.swing.*;
import java.io.IOException;

//This class simply gets run after the user presses the start button the intro screen.
//From here they have a choice to add their own question to the quiz or to skip this and do the quiz with the already existing questions

public class AskUser {

    public static void ask() throws IOException {

        String reply = JOptionPane.showInputDialog("Want to add your own question to the quiz? y/n");

        if(reply.equals("y")) {
            AddQuestion.createQuestion();
        } else {
            new QuizUIJOP();
        }
    }

}
