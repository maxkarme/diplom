package visualizer.visual.graph;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

public class DragAndDrop extends MouseAdapter {
    private final GraphJComponent graph;
    private Vertex target = null;

    private Point prevDrag = null;

    public DragAndDrop(GraphJComponent graph) {
        this.graph = graph;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        setTarget(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(target == null) return;
        if(prevDrag == null) return;
        int dx = e.getX() - prevDrag.x;
        int dy = e.getY() - prevDrag.y;

        prevDrag.setLocation(e.getX(), e.getY());
        boolean checkTarget = target.onDrag(graph.getSize(), dx, dy);

        if(checkTarget) setTarget(e);
        graph.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        prevDrag = null;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(target == null) return;
        prevDrag = new Point(e.getX(), e.getY());
    }

    private void setTarget(MouseEvent e) {
        if(target != null && target.cursorIn(e)) return;
        else if(target != null) {
            target.setHovered(false);
            target = null;

            graph.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            graph.repaint();
        }

        Iterator<Vertex> iter = graph.getVertexIter();

        while(iter.hasNext()) {
            Vertex current = iter.next();
            if(current.cursorIn(e)) {
                if(target != null)target.setHovered(false);
                target = current;
                target.setHovered(true);

                graph.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                graph.repaint();
            }
        }
    }
}
