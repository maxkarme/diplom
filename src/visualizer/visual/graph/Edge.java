package visualizer.visual.graph;

import visualizer.common.Geometry;

import java.awt.*;

public class Edge {
    private final Vertex from, to;

    public Edge(Vertex from, Vertex to) {
        this.from = from;
        this.to = to;
    }

    private Point getIntersection(Vertex v, int x1, int y1, int x2, int y2) {
        int a = v.getWidth() / 2;
        int b = v.getHeight() / 2;

        return Geometry.getIntersection(a, b, x1, y1, x2, y2);
    }

    protected double getAngle(int dx, int dy) {
        if(dx == 0 && dy > 0) return 3 * Math.PI / 2;
        if(dx == 0 && dy < 0) return Math.PI / 2;
        if(dy == 0 && dx > 0) return Math.PI;

        double res = Math.atan((double) dy / (double) dx);
        if(dx < 0 && dy >= 0) res += 2 * Math.PI;
        if(dx > 0 && dy <= 0) res += Math.PI;
        if(dx > 0 && dy >= 0) res += Math.PI;
        return res;
    }

    public void draw(Graphics2D g2, boolean isOriented) {
        g2.setStroke(new BasicStroke(2));
        g2.setPaint(Color.black);

        int x1 = from.getX() + from.getWidth() / 2;
        int y1 = from.getY() + from.getHeight() / 2;
        int x2 = to.getX() + to.getWidth() / 2;
        int y2 = to.getY() + to.getHeight() / 2;

        if(x1 - x2 == 0 && y1 - y2 == 0) return;

        Point beginIntersection = getIntersection(from, x2, y2, x1, y1);
        Point endIntersection = getIntersection(to, x1, y1, x2, y2);

        g2.drawLine(beginIntersection.x, beginIntersection.y, endIntersection.x, endIntersection.y);

        if(!isOriented) return;

        double angle = (getAngle(beginIntersection.x - endIntersection.x, endIntersection.y - beginIntersection.y));
        angle += Math.PI / 2;

        g2.translate(endIntersection.x, endIntersection.y);


        g2.rotate(-0.4 -angle);
        g2.drawLine(0, -15, 0, 0);
        g2.rotate(angle + 0.4);

        g2.rotate(0.4 -angle);
        g2.drawLine(0, -15, 0, 0);
        g2.rotate(angle - 0.4);

        g2.translate(-endIntersection.x, -endIntersection.y);
    }
}