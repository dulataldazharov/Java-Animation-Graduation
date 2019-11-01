import java.awt.Font;
import java.awt.Graphics2D;
import java.util.*;

public class Common {
    public UniversityMap map;
    public boolean finished;
    public int counter = 0;
    public int createCount = 0;
    public List<Academician> academicians;
    public List<Speaker> speakers;
    public List<Student> students;
    public List<Assessment> assessments;
    public Common(){
        finished = false;
        this.map = new UniversityMap();
        academicians = new ArrayList<>();
        assessments = new ArrayList<>();
        students = new ArrayList<>();
        speakers = new ArrayList<>();
        Speaker Tokayev = new Speaker();
        Tokayev.position.x = 480;
        Tokayev.position.y = 400;
        Tokayev.name = "Tokayev";
        Speaker Nazarbayev = new Speaker();
        Nazarbayev.name = "Nazarbayev";
        Nazarbayev.position.x = 600;
        Nazarbayev.position.y = 400;
        speakers.add(Tokayev);
        speakers.add(Nazarbayev);
        Academician tmp = new Academician();
        tmp.name = "Temizer";
        academicians.add(tmp);
        tmp = new Academician();
        tmp.name = "Neville";
        academicians.add(tmp);
        tmp = new Academician();
        tmp.name = "Katsu";
        academicians.add(tmp);
        tmp = new Academician();
        tmp.name = "Tourassis";
        academicians.add(tmp);
        for (int i=0; i<academicians.size(); i++){
            academicians.get(i).position.x = randomInt(0, 750);
            academicians.get(i).position.y = randomInt(0, 450);
            giveRandomState(academicians.get(i));
        }
        String[] studentNames = {"Dulat", "Bakdauren", "Asem", "Ayzhan", "Aqyl", "Marat", "Madiyar", "Madi", "Eldos", "Nazym"};
        for (int i=0; i<10; i++){
            Student newStudent = new Student();
            newStudent.name = studentNames[i];
            newStudent.position.x = randomInt(0, 750);
            newStudent.position.y = randomInt(0, 450);
            giveRandomState(newStudent);
            students.add(newStudent);
        }
    }
    public Vector2D findClosest(Entity e, List<Assessment> assessments){
        double min=800*800;
            double x = 0;
            double y = 0;
            for (int i=0; i<assessments.size(); i++){
                if (assessments.get(i).isVisible == false)
                    continue;
                double cand = e.position.distanceTo(assessments.get(i).position);
                if (cand<min){
                    min=cand;
                    x=assessments.get(i).position.x;
                    y=assessments.get(i).position.y;
                }
            }
        Vector2D res = new Vector2D();
        res.x = x;
        res.y = y;
        return res;
    }
    public void giveRandomState(Entity e){
        int rand = randomInt(0, 3);
        if (rand==0){
            ZigZag zz = new ZigZag();
            e.state = zz;
            e.stateName = "ZigZag";
        }
        if (rand==1){
            Rest rst = new Rest();
            e.state = rst;
            e.stateName = "Rest";
        }
        if (rand==2) {
        GotoXY goXY = new GotoXY();
        goXY.x = randomInt(50, 750);
        goXY.y = randomInt(50, 450);
        e.stateName = "GoToXY";
        e.state = goXY;
        }
        if (rand==3) {
            Closest closest = new Closest();
            e.stateName = "Closest";
            Vector2D closestVector = findClosest(e, assessments);
            closest.x = (int) closestVector.x;
            closest.y = (int) closestVector.y;
            e.state = closest;
        }
    }
    public int randomInt(int from, int to){
        Random rand = new Random();
        int range = to-from;
        return from+rand.nextInt(range+1);
    }
    public void stepAllEntities(){
        for (int i=0; i<students.size(); i++){
            if (students.get(i).stateName.equals("Closest")){
                Vector2D res;
                res = findClosest(students.get(i), assessments);
                Closest cl = new Closest();
                cl.x = (int)res.x;
                cl.y = (int)res.y;
                students.get(i).state = cl;
            }
        }
        for (int i=0; i<students.size(); i++){
            for (int j=0; j<assessments.size(); j++){
                if (assessments.get(j).isVisible==false){
                    continue;
                }
                double studentX = students.get(i).position.x+20;
                double studentY = students.get(i).position.y+20;
                double assessX = assessments.get(j).position.x+10;
                double assessY = assessments.get(j).position.y+10;
                double difX = studentX-assessX;
                double difY = studentY-assessY;
                if (difX<0) difX=difX*(-1);
                if (difY<0) difY=difY*(-1);
                if (difX<40 && difY<30){
                    assessments.get(j).isVisible=false;
                    students.get(i).grade=students.get(i).grade+assessments.get(j).points;
                }
            }
        }    
        for (int i=0; i<academicians.size(); i++){
            academicians.get(i).step();
        }
        for (int i=0; i<students.size(); i++){
            students.get(i).step();
        }
        counter++;
        createCount++;
        if (counter==50){
            for (int i=0; i<academicians.size(); i++){
                String currentState = academicians.get(i).stateName;
                giveRandomState(academicians.get(i));
                while (academicians.get(i).stateName.equals("Closest") || currentState.equals(academicians.get(i).stateName))
                    giveRandomState(academicians.get(i));
            }
            for (int i=0; i<students.size(); i++){
                String currentState = students.get(i).stateName;
                while (currentState.equals(students.get(i).stateName))
                    giveRandomState(students.get(i));
            }
            counter=0;
        }
        if (createCount==10){
            createCount=0;
            for (int i=0; i<academicians.size(); i++){
                if (academicians.get(i).stateName.equals("Rest")){
                    continue;
                }
                Assessment newA = academicians.get(i).createAssessment();
                assessments.add(newA);
            }
        }
        int countReady = 0;
        for (int i=0; i<students.size(); i++){
            if (students.get(i).grade>=100){
                if (students.get(i).position.x==540 && students.get(i).position.y==385){
                    countReady++;
                    Stationary statState = new Stationary();
                    students.get(i).state = statState;
                    students.get(i).stateName = "Stationary";
                }
                else {
                    GotoXY gotoXY = new GotoXY();
                    gotoXY.x = 540;
                    gotoXY.y = 385;
                    students.get(i).state = gotoXY;
                    students.get(i).stateName = "GotoXY";
                }
            }
        }
        if (countReady==students.size()){
            finished = true;
            for (int i=0; i<academicians.size(); i++)
                academicians.get(i).position.y=300;
            academicians.get(0).position.x = 400;
            academicians.get(1).position.x = 500;
            academicians.get(2).position.x = 600;
            academicians.get(3).position.x = 700;
            for (int i=0; i<academicians.size(); i++)
                academicians.get(i).stateName="Stationary";
            for (int i=0; i<speakers.size(); i++){
                speakers.get(i).isVisible=true;
            }
            for (int i=0; i<assessments.size(); i++)
                assessments.get(i).isVisible = false;
        
        }
    }
    public void drawAllEntities(Graphics2D g2d){
        this.map.draw(g2d);
        Font boldFont = new Font("Serif", Font.BOLD, 14);
        g2d.setFont(boldFont);
        if (finished == true){
            g2d.drawString("NU Graduation", 540, 480);
        }
        for (int i=0; i<assessments.size(); i++){
            if (assessments.get(i).isVisible==true)
                assessments.get(i).draw(g2d);
        }
        for (int i=0; i<students.size(); i++){
            students.get(i).draw(g2d);
        }
        for (int i=0; i<academicians.size(); i++){
            academicians.get(i).draw(g2d);
        }
        for (int i=0; i<speakers.size(); i++){
            speakers.get(i).draw(g2d);
        }
    }
    
}
