import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyFrame extends JFrame{
    public Display display;
    public MyFrame(){
        super();
        setTitle("NU Graduation");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        display = new Display();
        ActionListener listener = new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    repaint();
                }
            };
        Timer myTimer = new Timer(40, listener);
        myTimer.start();
        display.setPreferredSize(display.getPreferredSize());
        cp.add(display);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
