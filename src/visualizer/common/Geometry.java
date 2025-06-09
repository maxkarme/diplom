package visualizer.common;

import java.awt.*;

public class Geometry {
    public static double getDistance(Point p1, Point p2) {
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;

        return Math.sqrt(dx * dx + dy * dy);
    }

    public static Point getIntersection(int a, int b, int x1, int y1, int x2, int y2) {
        int sign = 1;
        if(y1 != y2) sign = Math.abs(y1 - y2) / (y1 - y2);
        double xIntersection = x2;
        double yIntersection = y2 + b * sign;

        if(x2 - x1 != 0) {
            double k = (double)(y1 - y2) / (x2 - x1);
            sign = Math.abs(x2 - x1) / (x2 - x1);

            xIntersection = sign * (a * b) / Math.sqrt(a * a * k * k + b * b);
            yIntersection = y2 + xIntersection * k;

            xIntersection = x2 - xIntersection;

        }

        return new Point((int)xIntersection, (int)yIntersection);
    }
}
