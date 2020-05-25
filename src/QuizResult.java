/**
 * Implements Result and the method percentCorrect
 */

public class QuizResult implements Result {

    //private String userName;
    private int questionsCorrect;
    private int numQuestions;

    /**
     *
     * @return double
     */

    @Override
    public double percentCorrect()
    {
        return Double.parseDouble(String.format("%.2f",((double)questionsCorrect/(double)numQuestions) *100));
    }

    public QuizResult(String userName, int questionsCorrect, int numQuestions)
    {
        //this.userName = userName;
        this.questionsCorrect = questionsCorrect;
        this.numQuestions = numQuestions;
    }
}
