/**
 * This is the part of the program that deals with displaying the question and taking in user answers.
 * It also handles writing the results to the results.txt file for storing.
 */



//Reference https://www.jetbrains.com/help/idea/working-with-code-documentation.html for JavaDocs
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

    public class QuizUIJOP {
    static int ansCorrect ;
    String userName;

    //Generate an ArrayList of the questions
    private ArrayList<Question> quizQuestions = QuizGenerator.createQuiz();

    QuizUIJOP() {

        int qNum;
        String answerInput;
        double userAnswer;


        userName = JOptionPane.showInputDialog("Welcome to the Math Quiz! Please type your name to start the quiz: ");

        //loop through arraylist and display the UI each round

        for(qNum = 0; qNum < quizQuestions.size(); qNum++) {

           answerInput = JOptionPane.showInputDialog(quizQuestions.get(qNum).getQuestionText());

           userAnswer = Double.parseDouble(answerInput);

           if(userAnswer == (quizQuestions.get(qNum).getQuestionAnswer())) {

               ansCorrect++;
           }
        }

        //Thank you message to the user, showing their number of correct answers
        JOptionPane.showMessageDialog(null,"Thanks for taking the Quiz, " + userName + "! \n You got " + ansCorrect +  " out of " +
                (quizQuestions.size() + 1) + " questions correct!","Results!",JOptionPane.PLAIN_MESSAGE);

        QuizResult result = new QuizResult(userName, ansCorrect, qNum);
        double percent = result.percentCorrect();


        //Call method writeResults to send userName and ansCorrect to the results.txt file for storing users and their result
        try {
           writeResults(userName, ansCorrect, percent);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //call the Goodbye method in QuizDriver
        QuizDriver.goodbye();

    } //end quizUIJOP()

    /**
         *
         * @param userName
         * @param ansCorrect
         * @throws IOException
         */

    private void writeResults(String userName, int ansCorrect, double percent) throws IOException
    {
        File out = new File("../JavaQuiz/src/results.txt");

        //Reference https://www.journaldev.com/881/java-append-to-file#java-append-to-file-using-filewriterfor appending
        FileWriter fw = new FileWriter(out, true);

        //Setting the second parameter to true makes the text append to the file instead of overwriting
        try (BufferedWriter bw = new BufferedWriter(fw)) {

            //writing to file

            bw.write("UserName: " + userName + ", " + "Number of Questions correct: " + ansCorrect + ", Number of Questions: "
                    + (quizQuestions.size() +1) + ", Percentage: " + percent);
            bw.write(System.lineSeparator());
            bw.flush();
        }
    } //end writeResults();
} //end quizUIJOP