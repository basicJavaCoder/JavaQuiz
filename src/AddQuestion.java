import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class AddQuestion {

    //path to question file as a relative path so this code has the ability
    // to be run on any system without the need to modify the file paths
    static String questionFilePath = "../JavaQuiz/src/QandA.txt";

    public static void createQuestion() throws IOException {

        //Variables for use in this class

        //Call method to get next number, this value is NOT the index of the question in the array
        int questionNumber = getNextQuestionNumber();

        //Ask user for their question and the answer for the question
        String questionText = JOptionPane.showInputDialog("Please enter the question for Q" + questionNumber + ":");
        double questionAnswer = Double.parseDouble(JOptionPane.showInputDialog("Please enter the answer for Q" + questionNumber + ":"));

        //Declare file path and variable name to store the questions in
        File out = new File(questionFilePath);

        //Append so the current questions are not overwritten
        FileWriter fw = new FileWriter(out, true);

        //Setting the second parameter to true makes the text append to the file instead of overwriting
        try (BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write("\n" + questionNumber + "&" + questionText + "&" + questionAnswer);
            //bw.write(System.lineSeparator());
            bw.flush();
        }

        //Confirmation Message
        JOptionPane.showMessageDialog(null,"Your question has been added :D You can see it next time you play this quiz","Added Successfully",JOptionPane.INFORMATION_MESSAGE);

        //Start the quiz after adding custom question
        new QuizUIJOP();

    } //end writeResults();

    //A Method to get the last line of the QandA.txt file and the return that value + 1 to use as the next question number
    public static int getNextQuestionNumber() {

        //Make arrayList of Question object to store the arraylist returned by getData()
        QuizGenerator getArray = new QuizGenerator();

        //Call getData() from QuizGenerator.java
        ArrayList<Question> arrayOfQuestions = getArray.getData(questionFilePath);
        int lastArrayIndex = arrayOfQuestions.size() - 1;

        //Return the value to be used for new question
        return arrayOfQuestions.get(lastArrayIndex).getQuestionNumber() + 1;

    }
}
