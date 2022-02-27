package com.company;

import javax.swing.*;
import java.awt.*;
import java.text.*;
import java.util.*;
class clock1 implements Runnable{
    JFrame f;
    Thread t=null;
    String timeString = "";
    JLabel b;
    JLabel c;

    clock1(){
        f=new JFrame();
        t = new Thread(this);
        t.start();

        b=new JLabel();
        b.setBounds(100,100,200,100);
        b.setFont(new Font("Arial",Font.PLAIN,45));
        b.setOpaque(true);
        b.setBorder(BorderFactory.createBevelBorder(1));
        b.setHorizontalAlignment(JTextField.CENTER);

        c=new JLabel();
        c.setBounds(100,200,200,60);
        c.setFont(new Font("Arial",Font.PLAIN,30));
        c.setOpaque(true);
        c.setBorder(BorderFactory.createBevelBorder(1));
        c.setHorizontalAlignment(JTextField.CENTER);

        f.add(b);
        f.add(c);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void run() {
        try {
            while (true) {

                Calendar cal = Calendar.getInstance();
                SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
                Date date = cal.getTime();
                timeString = formatter.format( date );
                printTime();
                t.sleep( 1000 );  // interval given in milliseconds

                Calendar now = Calendar.getInstance();
                int month = now.get(Calendar.MONTH);
                int day = now.get(Calendar.DAY_OF_MONTH);
                int year = now.get(Calendar.YEAR);
                c.setText("" + day + "/" + (month + 1) + "/" + year);

                Calendar cal1 = Calendar.getInstance();
                cal.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
                System.out.println("Hour = " + cal.get(Calendar.HOUR_OF_DAY));
                System.out.println("Minute = " + cal.get(Calendar.MINUTE));
                System.out.println("Second = " + cal.get(Calendar.SECOND));


            }
        }
        catch (Exception e) { }
    }

    public void printTime(){
        b.setText(timeString);
    }

    public static void main(String[] args) {
        new clock1();
    }
}