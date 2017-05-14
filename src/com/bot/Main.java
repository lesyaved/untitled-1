package com.bot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Point m1 = new Point();
    private static Point m2 = new Point();
    private static Point m3 = new Point();
    private static int m = 0;

    private static ArrayList<Point> points = new ArrayList<Point>();
    private static ArrayList<Line> lines = new ArrayList<Line>();
    static JFrame frame = new JFrame("Testframe");
    static Panel pointpane   = new Panel();
    static JLabel Answer = new JLabel("Ответ:");
    static JLabel Answer1= new JLabel("");
    static JLabel Answer2 = new JLabel("");
    static JLabel Answer3 = new JLabel("");


    public static void createGUI() {

	    frame.setPreferredSize(new Dimension(700,700));
	    JPanel panel = new JPanel(new BorderLayout());
        final Panel butPanel = new Panel();
        butPanel.setLayout(null);
        butPanel.setPreferredSize(new Dimension(250,700));

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

        Answer.setBounds(2,410,200,70);
        butPanel.add(Answer);
        Answer1.setBounds(2,430,200,70);
        butPanel.add(Answer1);
        Answer2.setBounds(2,450,200,70);
        butPanel.add(Answer2);
        Answer3.setBounds(2,470,200,70);
        butPanel.add(Answer3);






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

        JButton button6 = new JButton("убрать треугольник");
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0;i<lines.size();i++){
                    while(lines.size() > 0) {
                        int index = lines.size() - 1;
                        Line line =lines.remove(index);
                        pointpane.remove(line);
                        pointpane.repaint();
                        pointpane.revalidate();
                        Answer.setText("");
                        butPanel.repaint();
                        butPanel.revalidate();
                        Answer1.setText("");
                        butPanel.repaint();
                        butPanel.revalidate();
                        Answer2.setText("");
                        butPanel.repaint();
                        butPanel.revalidate();
                        Answer3.setText("");
                        butPanel.repaint();
                        butPanel.revalidate();
                    }
                }
            }
        });
        button6.setBounds(2,300,160,40);
        butPanel.add(button6);
        panel.add(pointpane,BorderLayout.CENTER);
        panel.add(butPanel,BorderLayout.EAST);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JButton button3 = new JButton("Чтение из файла");
        button3.setBounds(2,200,180,40);
        butPanel.add(button3);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (Scanner in = new Scanner(new File("input.txt"))) {
                int n = in.nextInt();
                Point[] q = new com.bot.Point[n];
                for (int i = 0; i < n; i++) {
                    q[i] = new com.bot.Point(in.nextInt(), in.nextInt());
                    points.add(q[i]);
                    q[i].setBounds(q[i].x,q[i].y,q[i].x+3,q[i].y+3);
                    pointpane.add(q[i]);
                    pointpane.revalidate();
                    pointpane.repaint();}
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                    System.out.print("IOError");
                }

            }}
        );


        JButton button4 = new JButton("Решить задачу");
        button4.setBounds(2,250,180,40);
        butPanel.add(button4);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {int max = 0;
                Point max1 = new Point();
                Point max2 = new Point();
                Point max3 = new Point();
                int n = points.size();
                for (int i = 0; i <  n; i++) {
                    for (int j = i+1; j  <  n; j++) {
                        for (int k = i+2; k  <   n; k++) {
                            int Contest = 0;
                            Triangle t = new Triangle(points.get(i), points.get(j), points.get(k));
                            if (t.checkTriangle() == true) {
                                for (int m = 0; m < n; m++) {
                                    if (t.checkPoint(points.get(m)))
                                        Contest++;
                                }
                                if (Contest > max) {
                                    max = Contest;
                                    max1 = new Point(t.a.x, t.a.y);
                                    max2 = new Point(t.b.x, t.b.y);
                                    max3 = new Point(t.c.x, t.c.y);
                                }
                            }

                        }
                    }

                }
                System.out.println(max1);
                System.out.println(max2);
                System.out.println(max3);
                System.out.println("Количество точек:"+max);
                paintTriangle(max1.x,max2.x,max3.x,max1.y,max2.y,max3.y);
                Answer.setText("Вершина 1: "+ max1);
                Answer1.setText("Вершина 2: "+ max2);
                Answer2.setText("Вершина 3: "+ max3);
                Answer3.setText("Количество точек: "+ max);
                m1.x = max1.x;
                m1.y = max1.y;
                m2.x = max2.x;
                m2.y = max2.y;
                m3.x = max3.x;
                m3.y = max3.y;
                m=max;


            }}
            );

        JButton button5 = new JButton("Вывод в файл");
        button5.setBounds(2,350,180,40);
        butPanel.add(button5);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { try (PrintWriter out = new PrintWriter(new File("output.txt"))) {
                out.println(m1);
                out.println(m2);
                out.println(m3);
                out.println(m );
                System.out.println("Ответ выведен в файл");
            } catch (Exception e1) {
                System.out.print("Error");
            }

            }}
        );

    }



    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                createGUI();
            }
        });
    }

    public static void paintTriangle(int X1,int X2,int X3,int Y1,int Y2,int Y3){
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
           /*System.out.println("Точка 1: x1="+x1.getText()+"  y1="+y1.getText());

            System.out.println("Точка 2: x2="+x2.getText()+"  y2="+y2.getText());
            System.out.println("Точка 3: x3="+x3.getText()+"  y3="+y3.getText());*/

            }

    }

}
