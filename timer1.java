package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.NumberFormat;

public class timer1 extends JFrame implements ItemListener {


    JLabel jltime;
    JLabel jl;
    JComboBox<Integer> jcb;
    JButton start;
    JButton reset;
    NumberFormat format;

    public Timer timer;
    public long initial;
    public long ttime2;
    public String ttime;
    public long remaining;


    public timer1() {

        JPanel timePanel = new JPanel();

        timePanel.setBackground(Color.black);
        //timePanel.setSize(200,200);

        jltime = new JLabel("00:00");
        jltime.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        jltime.setBorder(BorderFactory.createBevelBorder(1));
        jltime.setOpaque(true);
        jltime.setFont(new Font("Arial",Font.PLAIN,80));
        jltime.setBackground(new Color(212, 175, 55));
        jltime.setForeground(Color.black);
        timePanel.add(jltime);


        JPanel jp1 = new JPanel();
        jp1.setBackground(Color.black);
      //  jp1.setSize(200,200);
        jp1.setLayout(new FlowLayout());


        jl = new JLabel("TOTAL TIME (min):");
        jl.setFont(new Font("Arial",Font.PLAIN,20));
        jl.setForeground(new Color(212, 175, 55));

        jp1.add(jl);

        jcb = new JComboBox<Integer>();
        jl.setFont(new Font("Arial",Font.PLAIN,20));
        jcb.setBackground(new Color(212, 175, 55));
        jcb.setForeground(Color.black);
        for (int i = 60; i > 0; i--) {
            jcb.addItem(Integer.valueOf(i));
        }
        jcb.setSelectedIndex(0);
        ttime = "60";
        jp1.add(jcb);

        start = new JButton("START");
        jl.setFont(new Font("Arial",Font.PLAIN,20));
        start.setBackground(new Color(212, 175, 55));
        start.setForeground(Color.black);
        jp1.add(start);

        reset = new JButton("RESET");
        jl.setFont(new Font("Arial",Font.PLAIN,20));




        getContentPane().add(jp1, BorderLayout.NORTH);
        getContentPane().add(timePanel, BorderLayout.CENTER);



    Event e = new Event();
        start.addActionListener(e);
        reset.addActionListener(e);

        jcb.addItemListener(this);


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Timer");
        pack();
        setLocationByPlatform(true);
        setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new timer1();
            }

        });
    }
    Timeclass tc;

    void updateDisplay() {

        tc = new Timeclass(ttime);
        timer = new Timer(1000, tc);
        initial = System.currentTimeMillis();
        timer.start();
    }

    public class Event implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String bname = e.getActionCommand();
            if (bname.equals("START")) {
                if(timer!=null)timer.stop();
                timer =null;
                updateDisplay();
            }  else if( bname.equals("RESET") ){
                timer.stop();
                timer = null;
                jltime.setText(ttime+ ":00");

            }else{
                jltime.setText("00:00");
                timer.stop();

                remaining = convertTimer();
            }
        }
    }

    public class Timeclass implements ActionListener {
        private String tt;

        public Timeclass(String t) {
            tt =t;
        }
        public void actionPerformed(ActionEvent e) {

            remaining = convertTime();
            long current = System.currentTimeMillis();
            long elapsed = current - initial;
            remaining -= elapsed;

            format = NumberFormat.getNumberInstance();
            format.setMinimumIntegerDigits(2);

            if (remaining < 0)
                remaining = (long) 0;
            int minutes = (int) (remaining / 60000);
            int seconds = (int) ((remaining % 60000) / 1000);
            jltime.setText(format.format(minutes) + ":"
                    + format.format(seconds));

            if (remaining == 0) {
                jltime.setText("STOP");
                timer.stop();
            }
        }

        public long convertTime() {

            ttime2 = Long.parseLong(tt);
            long converted = (ttime2 * 60000) + 1000;
            return converted;
        }
    }

    public void itemStateChanged(ItemEvent ie) {

        ttime = (String) jcb.getSelectedItem().toString();
    }

    public long convertTimer() {
        ttime = (String) jcb.getSelectedItem().toString();
        ttime2 = Long.parseLong(ttime);
        long converted = (ttime2 * 60000) + 1000;
        return converted;
    }
}