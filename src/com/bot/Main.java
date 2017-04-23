package com.bot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Point> points = new ArrayList<Point>();
    private static ArrayList<Line> lines = new ArrayList<Line>();
    public static void createGUI() {
        final JFrame frame = new JFrame("Testframe");
	    frame.setPreferredSize(new Dimension(700,700));
	    JPanel panel = new JPanel(new BorderLayout());
        Panel butPanel = new Panel();
        butPanel.setLayout(null);
        butPanel.setPreferredSize(new Dimension(250,700));
        final Panel pointpane   = new Panel();
        pointpane.setLayout(null);
        //pointpane.setPreferredSize(new Dimension(350,700));

	    JLabel addPointwithCoords = new JLabel("Добавить точку по координатам");
	    addPointwithCoords.setBounds(2,2,300,25);
	    butPanel.add(addPointwithCoords);
	    JLabel addRandomPoints = new JLabel("Добавить рандомное количество точек");
	    addRandomPoints.setBounds(2,50,300,25);
	    butPanel.add(addRandomPoints);
        JLabel X = new JLabel("X:");
        X.setBounds(2,25,15,25);
        butPanel.add(X);
        JLabel Y = new JLabel("Y:");
        Y.setBounds(45,25,15,25);
        butPanel.add(Y);

        JLabel X1 = new JLabel("X1:");
        X1.setBounds(2,250,90,25);
        butPanel.add(X1);
        JLabel Y1= new JLabel("Y1:");
        Y1.setBounds(82,250,90,25);
        butPanel.add(Y1);
        JLabel X2 = new JLabel("X2:");
        X2.setBounds(2,280,90,25);
        butPanel.add(X2);
        JLabel Y2 = new JLabel("Y2:");
        Y2.setBounds(82,280,90,25);
        butPanel.add(Y2);
        JLabel X3 = new JLabel("X3:");
        X3.setBounds(2,310,90,25);
        butPanel.add(X3);

        JLabel Y3 = new JLabel("Y3:");
        Y3.setBounds(82,310,90,25);
        butPanel.add(Y3);


        JLabel N = new JLabel("NUM:");
        N.setBounds(2,70,30,25);
        butPanel.add(N);

        final JTextField x = new JTextField();
        x.setBounds(17,25, 25,25);
        butPanel.add(x);
        final JTextField y = new JTextField();
        y.setBounds(60,25, 25,25);
        butPanel.add(y);
        final JTextField n = new JTextField();
        n.setBounds(35,70,25,25);
        butPanel.add(n);
        final JTextField x1 = new JTextField();
        x1.setBounds(22,250,25,25);
        butPanel.add(x1);
        final JTextField y1 = new JTextField();
        y1.setBounds(102,250,25,25);
        butPanel.add(y1);
        final JTextField x2 = new JTextField();
        x2.setBounds(22,280,25,25);
        butPanel.add(x2);
        final JTextField x3 = new JTextField();
        x3.setBounds(22,310,25,25);
        butPanel.add(x3);
        final JTextField y2 = new JTextField();
        y2.setBounds(102,280,25,25);
        butPanel.add(y2);
        final JTextField y3 = new JTextField();
        y3.setBounds(102,310,25,25);
        butPanel.add(y3);





        JButton button1 = new JButton("Добавить точку");
        button1.setBounds(2,100,160,40);
        butPanel.add(button1);
        button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int X = (!x.getText().equals("")?Integer.parseInt(x.getText()):0);
                int Y= (!y.getText().equals("")?Integer.parseInt(y.getText()):0);
                int N = (!n.getText().equals("")?Integer.parseInt(n.getText()):0);
                if ((X>0)&&(Y>0)) {
                    Point b = new Point(X, Y);
                    points.add(b);
                    b.setBounds(b.x,b.y,b.x+3,b.y+3);
                    pointpane.add(b);
                    pointpane.revalidate();
                    pointpane.repaint();
                }
                else {
                    if (N>0){
                        for (int i=0;i<N;i++){
                            Point b = new Point((int)(Math.random()*(frame.getWidth()-250)), (int)(Math.random()*frame.getHeight()));
                            points.add(b);
                            b.setBounds(b.x,b.y,b.x+3,b.y+3);
                            pointpane.add(b);
                            pointpane.revalidate();
                            pointpane.repaint();
                        }
                    }
                }

            }
        });
        JButton button2 = new JButton("очистить");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0;i<points.size();i++){
                    while(points.size() > 0) {
                        int index = points.size() - 1;
                        Point point = points.remove(index);
                        pointpane.remove(point);
                        pointpane.repaint();
                        pointpane.revalidate();
                    }
                }
            }
        });
        button2.setBounds(2,150,160,40);
        butPanel.add(button2);
        panel.add(pointpane,BorderLayout.CENTER);
        panel.add(butPanel,BorderLayout.EAST);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JButton button3 = new JButton("Добавить треугольник");
        button3.setBounds(2,200,180,40);
        butPanel.add(button3);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int X1 = (!x1.getText().equals("")?Integer.parseInt(x1.getText()):0);
                int Y1= (!y1.getText().equals("")?Integer.parseInt(y1.getText()):0);
                int X2 = (!x2.getText().equals("")?Integer.parseInt(x2.getText()):0);
                int Y2= (!y2.getText().equals("")?Integer.parseInt(y2.getText()):0);
                int X3 = (!x3.getText().equals("")?Integer.parseInt(x3.getText()):0);
                int Y3= (!y3.getText().equals("")?Integer.parseInt(y3.getText()):0);
                if ((X3-X1)/(X2-X1)!=(Y3-Y1)/(Y2-Y1)){

                    Point c = new Point(X1, Y1);
                    points.add(c);
                    c.setBounds(c.x,c.y,c.x+3,c.y+3);
                    pointpane.add(c);
                    pointpane.revalidate();
                    pointpane.repaint();
                    Point d = new Point(X2, Y2);
                    points.add(d);
                    d.setBounds(d.x,d.y,d.x+3,d.y+3);
                    pointpane.add(d);
                    pointpane.revalidate();
                    pointpane.repaint();
                    Point f = new Point(X3, Y3);
                    points.add(f);
                    f.setBounds(f.x,f.y,f.x+3,f.y+3);
                    pointpane.add(f);
                    
                    pointpane.revalidate();
                    pointpane.repaint();
                    Line Line1=new  Line(c,d);
                   lines.add(Line1);
                    Line1.setBounds(2, 2, frame.getWidth(), frame.getHeight());
                    pointpane.add(Line1);
                    pointpane.revalidate();
                    pointpane.repaint();

                    Line Line2= new Line(f, d);
                    lines.add(Line2);
                    Line2.setBounds(2, 2, frame.getWidth(), frame.getHeight());
                    pointpane.add(Line2);
                    pointpane.revalidate();
                    pointpane.repaint();

                    Line Line3= new Line(f,c);

                    lines.add(Line3);
                    Line3.setBounds(2, 2, frame.getWidth(), frame.getHeight());
                    pointpane.add(Line3);
                    pointpane.revalidate();
                    pointpane.repaint();



                System.out.println("Добавлен треугольник");
                System.out.println("Точка 1: x1="+x1.getText()+"  y1="+y1.getText());

                System.out.println("Точка 2: x2="+x2.getText()+"  y2="+y2.getText());
                System.out.println("Точка 3: x3="+x3.getText()+"  y3="+y3.getText());}
                else{
                    System.out.println("Такого треугольника не существует");
                }


            }
        });
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                createGUI();
            }
        });
    }
}
