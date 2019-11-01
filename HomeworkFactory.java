import java.util.Random;
public class HomeworkFactory extends AssessmentFactory{
    @Override
    public Assessment createAssessment(Vector2D position){
        Homework newHomework = new Homework();
        newHomework.position.x = position.x;
        newHomework.position.y = position.y;
        Random rand = new Random();
        newHomework.points=1+rand.nextInt(3);
        return newHomework;
    }
}
