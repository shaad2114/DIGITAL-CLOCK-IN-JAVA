package com.company;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

class Calendar1 extends JFrame implements ItemListener
{
    JPanel p1, p2;
    JComboBox month;
    JComboBox year;
    int days[]={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    String weekdays[] = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    public Calendar1(String calendar) {
        super();
       // setTitle(title);
        p1 = new JPanel();
        p1.setSize(200, 50);
        //p1.setLayout(new FlowLayout());
        month = new JComboBox();
        for(int i=0;i< months.length;i++)
        {
            month.addItem(months[i]);
        }
        month.addItemListener(this);
        year = new JComboBox();
        for(int i=1980;i<=2099;i++)
        {
            year.addItem(i);
        }
        year.addItemListener(this);
        p1.add(month);
        p1.add(year);
        p2 = new JPanel();
        p2.setSize(200,50);
        p2.setLayout(new GridLayout(0,7,6,6));
        Date date = new Date();
        drawCalendar(months[date.getMonth()], (1900+date.getYear()));
        year.setSelectedItem((1900+date.getYear()));
        month.setSelectedItem(months[date.getMonth()]);
        Container c=getContentPane();
        c.setLayout(new FlowLayout());
        add(p1);
        add(p2);
        c.setBackground(Color.black);
        p1.setBackground(new Color(212, 175, 55));
        p1.setForeground(Color.black);
        p2.setBackground(new Color(212, 175, 55));
        p2.setForeground(Color.black);
        setVisible(true);
        setBounds(200, 100, 350, 300);
        setSize(300,260);
        setBackground(Color.black);
        setBackground(Color.black);
        // setSize(400,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String args[])
    {
        Calendar1 frame = new Calendar1("Calendar");
        frame.setBackground(Color.BLACK);
    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {
        if(e.getStateChange() == ItemEvent.SELECTED)
        {
            drawCalendar((String)month.getSelectedItem(), (Integer)year.getSelectedItem());
        }
    }

    public void drawCalendar(String inputMonth, int inputYear)
    {
        p2.removeAll();
        for(int i=0;i< weekdays.length;i++)
        {
            JLabel label = new JLabel(weekdays[i]);
            label.setHorizontalAlignment(SwingConstants.RIGHT);
            p2.add(label);
        }
        Date date = new Date("01-"+inputMonth+"-"+inputYear);
        int noOfDaysInMonth = days[date.getMonth()];
        if(date.getYear()%4==0 && date.getMonth()==1)
        {
            noOfDaysInMonth = 29;
        }

        for(int i=1, day=1;day<=noOfDaysInMonth;i++)
        {
            for(int j=0;j<7;j++)
            {
                if(day==1)
                {
                    if(j==date.getDay())
                    {
                        JLabel label = new JLabel(String.valueOf(day));
                        label.setHorizontalAlignment(SwingConstants.RIGHT);
                        p2.add(label);
                        day++;
                    }
                    else
                    {
                        JLabel label = new JLabel("");
                        p2.add(label);
                    }
                }
                else
                {
                    JLabel label = new JLabel(String.valueOf(day));
                    label.setHorizontalAlignment(SwingConstants.RIGHT);
                    p2.add(label);
                    day++;
                }
                if(day>noOfDaysInMonth)
                {
                    break;
                }
            }
        }
        p2.validate();
        setTitle("CALENDER");
    }
}

