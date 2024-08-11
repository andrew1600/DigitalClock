import javax.swing.*;
import java.awt.*;
import java.util.*;

class Clock extends JFrame implements Runnable {
    JPanel panel;
    JLabel label;
    Font font;
    Calendar calendar;
    Date date;
    Thread thread;

    public Clock() {
        super("My Clock");
        panel = new JPanel();
        getContentPane().add(panel);
        label = new JLabel("01 : 01 : 01 AM");
        panel.setBackground(Color.BLUE);
        panel.add(label);
        font = new Font("Ubuntu", Font.BOLD, 44);
        label.setFont(font);
        setSize(350, 150);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        while(true) {
            calendar = new GregorianCalendar();
            date = new Date();
            calendar.setTime(date);

            int h = calendar.get(Calendar.HOUR);
            int m = calendar.get(Calendar.MINUTE);
            int s = calendar.get(Calendar.SECOND);
            int ampm = calendar.get(Calendar.AM_PM);
            String hr, mn, se, am_pm;

            hr = mn = se = am_pm = "";

            if (ampm == 0) {
                am_pm = "AM";
            }else {
                am_pm = "PM";
            }
            if( h < 10) {
                hr = "0"  + String.valueOf(h);
            }else {
                hr = String.valueOf(h);
            }
            if(m < 10) {
                mn = "0" + String.valueOf(m);
            }
            else {
                mn = String.valueOf(m);
            }
            if(s < 10) {
                se = "0" + String.valueOf(s);
            }
            else {
                se = String.valueOf(s);
            }
            String final_time = hr + " : " + mn + " : " + se + am_pm;
            label.setText(final_time);
            try {
                thread.sleep(1000);
            } catch(Exception e) {

            }



        }

    }

    public static void main(String[] args) {
        new Clock();
    }
}