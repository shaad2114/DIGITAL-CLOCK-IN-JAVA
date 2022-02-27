package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class stopwatch1 implements ActionListener{

    JFrame frame = new JFrame();
    JButton startButton = new JButton("START");
    JButton resetButton = new JButton("RESET");
    JLabel timeLabel = new JLabel();
    int elapsedTime = 0;
    int seconds =0;
    int minutes =0;
    int hours =0;
    boolean started = false;
    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);

    Timer timer = new Timer(1000, new ActionListener() {

        public void actionPerformed(ActionEvent e) {

            elapsedTime=elapsedTime+1000;
            hours = (elapsedTime/3600000);
            minutes = (elapsedTime/60000) % 60;
            seconds = (elapsedTime/1000) % 60;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);

        }

    });


    stopwatch1(){

        timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
        timeLabel.setBounds(50,50,200,100);
        timeLabel.setFont(new Font("Arial",Font.PLAIN,35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        timeLabel.setBackground(new Color(212, 175, 55));
        timeLabel.setForeground(Color.black);

        startButton.setBounds(50,150,100,50);
        startButton.setFont(new Font("Arial",Font.PLAIN,20));
        startButton.setFocusable(false);
        startButton.addActionListener(this);
        startButton.setBackground(new Color(212, 175, 55));
        startButton.setForeground(Color.black);

        resetButton.setBounds(150,150,100,50);
        resetButton.setFont(new Font("Arial",Font.PLAIN,20));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        resetButton.setBackground(new Color(212, 175, 55));
        resetButton.setForeground(Color.black);

        frame.add(startButton);
        frame.add(resetButton);
        Component add = frame.add(timeLabel);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300,300);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.black);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==startButton) {

            if(started==false) {
                started=true;
                startButton.setText("STOP");
                start();
            }
            else {
                started=false;
                startButton.setText("START");
                stop();
            }

        }
        if(e.getSource()==resetButton) {
            started=false;
            startButton.setText("START");
            reset();
        }

    }

    void start() {
        timer.start();
    }

    void stop() {
        timer.stop();
    }

    void reset() {
        timer.stop();
        elapsedTime=0;
        seconds =0;
        minutes=0;
        hours=0;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
    }

    public static void main(String[] args) {
        stopwatch1 ss= new stopwatch1();
    }
}

