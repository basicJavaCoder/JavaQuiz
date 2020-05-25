/**
 * Takes in questions from the QandA.txt file
 * Demonstrates composition with QuizGenerator
 */

public class Question {
    private int questionNumber;
    private String questionText;
    private Double questionAnswer;

    public Question(String questionNumberIn, String questionTextIn, String questionAnswerIn) {
        this.questionNumber = Integer.parseInt(questionNumberIn);
        this.questionText = questionTextIn;
        this.questionAnswer = Double.parseDouble(questionAnswerIn);
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public double getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(Double questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    @Override
    public String toString() {
        return "Question{" + "Question Number=" + questionNumber + ", Question Text=" + questionText + ", Question Answer=" + questionAnswer + '}';
    }
    
    
    
    
    
    
    
}
