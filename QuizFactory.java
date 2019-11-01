import java.util.Random;
public class QuizFactory extends AssessmentFactory{
    @Override
    public Assessment createAssessment(Vector2D position){
        Quiz newQuiz = new Quiz();
        newQuiz.position.x = position.x;
        newQuiz.position.y = position.y;
        Random rand = new Random();
        newQuiz.points=3+rand.nextInt(3);
        return newQuiz;
    }
}
