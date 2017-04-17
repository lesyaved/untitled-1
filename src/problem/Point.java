package problem;

/**
 * Created by vedoa.18 on 17.04.2017.
 */
public class Point {

        double x;
        double y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        Point() {
            x = 0;
            y = 0;
        }
    }
