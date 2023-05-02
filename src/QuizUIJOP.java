/*
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
    private final ArrayList<Question> quizQuestions = QuizGenerator.createQuiz();

    QuizUIJOP() {

        int qNum;
        String answerInput;
        double userAnswer;


        //Ask user for their name, so it can be used later to store results
        userName = JOptionPane.showInputDialog("Welcome to the Math Quiz! Please type your name to start the quiz: ");


        //loop through arraylist of question (quizQuestions) and display the UI each round
        for(qNum = 0; qNum < quizQuestions.size(); qNum++) {

            //userAnswer = 0;

           answerInput = JOptionPane.showInputDialog("Question " + (qNum + 1) + ": " + quizQuestions.get(qNum).getQuestionText());

            //Added input validation via try catch to only allow input that can be converted to double
           try {
               userAnswer = Double.parseDouble(answerInput);
           }
           catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(
                       null,
                       "Invalid input. All answers must be a number.",
                       "Error", JOptionPane.ERROR_MESSAGE
               );
               qNum--;
               continue;
           }

           //If the user types the right answer then add one to the total score counter (ansCorrect)
           if(userAnswer == (quizQuestions.get(qNum).getQuestionAnswer())) {

               ansCorrect++;
           }
        }

        //Thank you message to the user, showing their number of correct answers
        JOptionPane.showMessageDialog(
                null,
                "Thanks for taking the Quiz, " + userName + "! \n You got " + ansCorrect +  " out of " + (quizQuestions.size()) + " questions correct!",
                "Results!",JOptionPane.PLAIN_MESSAGE
        );

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


    //Write username, correct answers and total amount of questions they answered to results.txt
    private void writeResults(String userName, int ansCorrect, double percent) throws IOException
    {
        File out = new File("../JavaQuiz/src/results.txt");

        //Reference https://www.journaldev.com/881/java-append-to-file#java-append-to-file-using-filewriterfor appending
        FileWriter fw = new FileWriter(out, true);

        //Setting the second parameter to true makes the text append to the file instead of overwriting
        try (BufferedWriter bw = new BufferedWriter(fw)) {

            //writing to file
            bw.write("UserName: " + userName + ", " + "Number of Questions correct: " + ansCorrect + ", Number of Questions: "
                    + (quizQuestions.size()) + ", Percentage: " + percent);
            bw.write(System.lineSeparator()); //To make a newline in the file
            bw.flush();
        }
    } //end writeResults();
} //end quizUIJOP