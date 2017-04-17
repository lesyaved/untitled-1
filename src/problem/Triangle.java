package problem;

/**
 * Created by vedoa.18 on 17.04.2017.
 */
public class Triangle {

        Point a;
        Point b;
        Point c;
        Triangle(Point a, Point b, Point c){
            this.a=a;
            this.b=b;
            this.c=c;
        }
        public boolean checkTriangle(){
            return ((c.x-a.x)/(b.x-a.x)!=(c.y-a.y)/(b.y-a.y)?true:false);
        }
        public  boolean checkPoint(Point p){
            double x1=a.x;
            double x2=b.x;
            double x3=c.x;
            double x0=p.x;
            double y1=a.y;
            double y2=b.y;
            double  y3=c.y;
            double y0=p.y;
            if (((((x1 - x0) * (y2 - y1) - (x2 - x1) * (y1 - y0))>0)&&(((x2 - x0) * (y3 - y2) - (x3 - x2) * (y2 - y0))>0)&&( (x3 - x0) * (y1 - y3) - (x1 - x3) * (y3 - y0))>0)||((((x1 - x0) * (y2 - y1) - (x2 - x1) * (y1 - y0))<0)&&((x2 - x0) * (y3 - y2) - (x3 - x2) * (y2 - y0))<0)&&((x3 - x0) * (y1 - y3) - (x1 - x3) * (y3 - y0))<0)
                return true;
            else
                return false ;




        }



    }

