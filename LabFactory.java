import java.util.Random;

public class LabFactory extends AssessmentFactory{
    @Override
    public Assessment createAssessment(Vector2D position){
        Lab newLab = new Lab();
        newLab.position.x = position.x;
        newLab.position.y = position.y;
        Random rand = new Random();
        newLab.points=2+rand.nextInt(3);
        return newLab;
    }
}
