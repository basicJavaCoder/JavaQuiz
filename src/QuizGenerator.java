//Takes items from the QandA.txt file and sends into an array

import java.io.*;
import java.util.ArrayList;

public class QuizGenerator extends GenericQuizGenerator {

    /**
     *
     * @return questionsFromFile
     */
    public static ArrayList<Question> createQuiz()
    {
        QuizGenerator quiz = new QuizGenerator(); //this will be unnecessary when you access QuizGenerator from quizGUI

        ArrayList<Question> questionsFromFile = quiz.getData("../JavaQuiz/src/QandA.txt");

        return questionsFromFile;
    }

    /**
     * getData takes in the filename of where questions are stored, retrieves
     * them and then returns an ArrayList of Questions
     *
     * @param fileName
     * @return Questions
     */
    public ArrayList<Question> getData(String fileName) {

        ArrayList<Question> questions = new ArrayList();

        String[] line = new String[3]; // Each line contains 3 values. (question number, question, answer)

        File f = new File(fileName);

        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            /*
            The while loop now keep spreading until it finds a blank line i.e.
            the end of the file. 
             */
            while (line != null) {
                // The BufferedReader object is then broken into an array
                line = br.readLine().split("&"); // Splits the line into relevant parts

                // Now write parts of line into temp vars to make it understandable
                String tempQuestionNo = line[0];
                String tempQuestionText = line[1];
                String tempQuestionAnswer = line[2];

                // Create a Question object and use the constructor that
                // looks for the Q.No, Text and Answer
                Question question = new Question(tempQuestionNo, tempQuestionText, tempQuestionAnswer);
                // Add  the individual question to the questions Arraylist
                questions.add(question);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found Exception ");
        } catch (IOException e) {
            System.out.println("IO Exception");
        }

        finally {
            return questions; // return the ArrayList
        }
    } //end of getData

}
