/**
 * Takes in questions from the QandA.txt file
 * Demonstrates composition with QuizGenerator
 */

public class Question {
    private final int questionNumber;
    private final String questionText;
    private final Double questionAnswer;

    public Question(String questionNumberIn, String questionTextIn, String questionAnswerIn) {
        this.questionNumber = Integer.parseInt(questionNumberIn);
        this.questionText = questionTextIn;
        this.questionAnswer = Double.parseDouble(questionAnswerIn);
    }

    public int getQuestionNumber() {

        return questionNumber;
    }

    public String getQuestionText() {

        return questionText;
    }

    public double getQuestionAnswer() {

        return questionAnswer;
    }

    @Override
    public String toString() {
        return "Question{" + "Question Number=" + questionNumber + ", Question Text=" + questionText + ", Question Answer=" + questionAnswer + '}';
    }
    
}
