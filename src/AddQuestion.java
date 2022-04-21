import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class AddQuestion {

    //path to question file as a relative path so this code has the ability
    // to be run on any system without the need to modify the file paths
    static String questionFilePath = "../JavaQuiz/src/QandA.txt";

    public static void createQuestion() throws IOException {

        //Variables for use in this class
        String questionText = "";
        double questionAnswer = 0;
        int questionNumber = 0;

        //Call method to get next number, this value is NOT the index of the question in the array
        questionNumber = getNextQuestionNumber();

        //Ask user for their question and the answer for the question
        questionText = JOptionPane.showInputDialog("Please enter the question for Q" + questionNumber + ":");
        questionAnswer = Double.parseDouble(JOptionPane.showInputDialog("Please enter the answer for Q" + questionNumber + ":"));

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
    public static int getNextQuestionNumber() throws IOException {

        int nextQuestionNumber = 0;
        int lastArrayIndex = 0;
        String lastLine = "";

        //Make arrayList of Question object to store the arraylist returned by getData()
        ArrayList<Question> arrayOfQuestions = new ArrayList();
        QuizGenerator getArray = new QuizGenerator();

        //Call getData() from QuizGenerator.java
        arrayOfQuestions = getArray.getData(questionFilePath);
        lastArrayIndex = arrayOfQuestions.size() - 1;

        //This takes the string from the last index in the arraylist
        lastLine = arrayOfQuestions.get(lastArrayIndex).toString();

        //Split the last line into parts separated by & and convert the first part into an int
        //Then add 1 to get the next value to be used for the question the user is adding currently
        String[] parts = lastLine.split("&");
        nextQuestionNumber = arrayOfQuestions.get(lastArrayIndex).getQuestionNumber() + 1;

        //Return the value to be used for new question
        return nextQuestionNumber;

    }
}
