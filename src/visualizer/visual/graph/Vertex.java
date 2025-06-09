package visualizer.visual.graph;

import visualizer.common.TextManager;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Vertex {
    private final int index;
    private final Font font = new Font(Font.SANS_SERIF, Font.BOLD, 20);
    private final String name;
    private int x;
    private int y;
    private final int width = 40;
    private final int height = 40;
    private boolean isHovered = false;

    private ArrayList<Edge> edges = new ArrayList<>();

    public Vertex(int _index, int x, int y) {
        this.index = _index;
        this.name = _index + "";
        this.x = x;
        this.y = y;
    }

    public int getIndex() {
        return index;
    }

    public boolean cursorIn(MouseEvent e) {
        double r1 = (double)width / 2;
        double r2 = (double)height / 2;

        double centerX = x + r1;
        double centerY = y + r2;

        double check = (e.getX() - centerX) * (e.getX() - centerX) / (r1 * r1);
        check += (e.getY() - centerY) * (e.getY() - centerY) / (r2 * r2);

        return check <= 1;
    }

    public boolean onDrag(Dimension canvSize, int dx, int dy) {
        x += dx;
        y += dy;

        boolean checkTarget = false;

        if(x < 0) {
            x = 0;
            checkTarget = true;
        }
        if(y < 0) {
            y = 0;
            checkTarget = true;
        }

        if(x + width > canvSize.width) {
            x = canvSize.width - width;
            checkTarget = true;
        }

        if(y + height > canvSize.height) {
            y = canvSize.height - height;
            checkTarget = true;
        }

        return checkTarget;
    }

    public void draw(Graphics2D g2, Color color, boolean isOriented) {
        g2.setStroke(new BasicStroke(2));
        g2.setPaint(color);
        if(isHovered) {
            int red = Math.min(color.getRed() + 70, 255);
            int green = Math.min(color.getGreen() + 70, 255);
            int blue = Math.min(color.getBlue() + 70, 255);
            g2.setPaint(new Color(red, green, blue));
        }

        g2.fillOval(x, y, width, height);

        g2.setPaint(Color.white);
        TextManager.drawCenter(g2, name, x, y, width, height);

        for(Edge edge : edges) {
            edge.draw(g2, isOriented);
        }
    }

    public void setHovered(boolean hovered) {
        isHovered = hovered;
    }

    public Point getCoords() {
        return new Point(x, y);
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
