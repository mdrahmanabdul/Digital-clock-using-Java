//import statements which help us to import the whole package, which contain a group of classes in them
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.event.*;

public class clock
{
    public static void main(String[] args)
    {
        JFrame clock =new TextClockWindow();
        clock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clock.setVisible(true);
    }
    //JFrame is a class that will help us to create graphical Java applications
}


class TextClockWindow extends JFrame
{
    //Inheritance can be defined as the procedure or mechanism of acquiring all the properties and behavior of one class to anther.

    private JTextField timeField;
    // the private keyword is an access modifier used for attributes ,methods and constructors , making them onlu accessible within

    public TextClockWindow()
    {
        timeField = new JTextField(10);
        timeField.setFont(new Font("",Font.CENTER_BASELINE,50));

        Container content = this.getContentPane();
        content.setLayout(new GridLayout());
        content.add(timeField);

        this.setTitle("Rahman's Digital Clock");
        this.pack();

        //'this' : keyword in Java is a referance variable that refers to the current object of method or a constructor

        javax.swing.Timer t=new javax.swing.Timer(1000,
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Calendar calendar = new GregorianCalendar();
                        String am_pm;

                        Calendar now = Calendar.getInstance();
                        int h = now.get(Calendar.HOUR_OF_DAY);
                        int m = now.get(Calendar.MINUTE);
                        int s = now.get(Calendar.SECOND);

                        if (calendar.get(Calendar.AM_PM) == 0) {
                            am_pm = "AM";
                        } else {
                            am_pm="PM";
                        } //Code to Determine whether the time is AM or PM

                        timeField.setText(""+h+ ":"+m+":"+s+":"+am_pm);
                        timeField.setHorizontalAlignment(JTextField.CENTER);
                        //Center the text
                        timeField.getCaret().setVisible(false);
                        //Hide the Cursor in JTextField

                    }
                });
        t.start();
    }

}