package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class launchpage1 implements ActionListener, Runnable {

    JFrame frame = new JFrame();
    JButton myButton = new JButton("STOPWATCH");
    JButton myButton1 = new JButton("CALENDER");
    JButton myButton2 = new JButton("TIMER");
    JLabel newLabel = new JLabel("DIGITAL CLOCK");
    JLabel bb = new JLabel();
    JLabel cc = new JLabel();
    Thread t = null;
    String timeString = "";
    private Object clock1;

    public launchpage1() {
        bb = new JLabel();
        bb.setBounds(150, 150, 200, 100);
        bb.setFont(new Font("Arial", Font.PLAIN, 45));
        bb.setOpaque(true);
        bb.setBorder(BorderFactory.createBevelBorder(1));
        bb.setHorizontalAlignment(JTextField.CENTER);
        bb.setBackground(new Color(212, 175, 55));
        bb.setForeground(Color.black);
        frame.add(bb);

        cc = new JLabel();
        cc.setBounds(150, 250, 200, 60);
        cc.setFont(new Font("Arial", Font.PLAIN , 30));
        cc.setOpaque(true);
        cc.setBorder(BorderFactory.createBevelBorder(1));
        cc.setHorizontalAlignment(JTextField.CENTER);
        cc.setBackground(new Color(212, 175, 55));
        cc.setForeground(Color.black);
        frame.add(cc);

        myButton.setBounds(20, 370, 150, 40);
        myButton.setFocusable(false);
        myButton.addActionListener(this);
        myButton.setBackground(new Color(212, 175, 55));
        myButton.setForeground(Color.black);
        frame.add(myButton);

        myButton1.setBounds(170, 370, 150, 40);
        myButton1.setFocusable(false);
        myButton1.addActionListener(this);
        myButton1.setBackground(new Color(212, 175, 55));
        myButton1.setForeground(Color.black);
        frame.add(myButton1);

        myButton2.setBounds(320, 370, 150, 40);
        myButton2.setFocusable(false);
        myButton2.addActionListener(this);
        myButton2.setBackground(new Color(212, 175, 55));
        myButton2.setForeground(Color.black);
        frame.add(myButton2);

        newLabel.setBounds(80, 60, 320, 50);
        newLabel.setFont(new Font(" Open Sans", Font.BOLD | Font.ITALIC, 40));
        newLabel.setOpaque(true);
        newLabel.setBorder(BorderFactory.createBevelBorder(1));
        newLabel.setBackground(new Color(212, 175, 55));
        newLabel.setForeground(Color.black);
        frame.add(newLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 550);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.black);


        Thread Thread =new Thread(this);
        Thread.start();


    }

    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == myButton) {
        // System.exit(1000);
            stopwatch1 stopwatch = new stopwatch1();
        } else if (e.getSource() == myButton1) {
            //frame.dispose();
            Calendar1 calendar = new Calendar1("Calendar");
        } else if (e.getSource() == myButton2) {
            // frame.dispose();
            timer1 timer = new timer1();
        }
    }


    @Override
    public void run() {
        try {
            while (true) {

                Calendar cal = Calendar.getInstance();
                SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
                Date date = cal.getTime();
                timeString = formatter.format(date);
                printTime();
                t.sleep(1000);  // interval given in milliseconds

                Calendar now = Calendar.getInstance();
                int month = now.get(Calendar.MONTH);
                int day = now.get(Calendar.DAY_OF_MONTH);
                int year = now.get(Calendar.YEAR);
                cc.setText("" + day + "/" + (month + 1) + "/" + year);


            }
        } catch (Exception e) {
        }
    }

    public void printTime() {
        bb.setText(timeString);
    }
}

