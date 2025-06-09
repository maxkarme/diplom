package visualizer.visual.graph;

import visualizer.selector.Selector;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GraphJComponent extends JComponent {
    private static Map<Integer, Color> colors = new HashMap();

    static {
        colors.put(0, new Color(0, 0, 0));
        colors.put(1, new Color(200, 0, 0));
        colors.put(2, new Color(0, 0, 200));
        colors.put(6, new Color(0, 200, 0));
    }
    private final ArrayList<Vertex> vertexList = new ArrayList<Vertex>();
    private final Font font = new  Font(Font.SANS_SERIF, Font.PLAIN, 16);
    private final ArrayList<Selector> selectors;
    private ArrayList<Boolean> used;
    private final Graph graphAnnotation;

    private Object value;

    public ArrayList<Integer>[] getGraph() {
        try {
            ArrayList<Integer> graph[] = (ArrayList<Integer>[]) value;
            return graph;
        }
        catch (Error err) {
            System.out.println("Error in GraphJComponent");
        }

        return null;
    }

    private Set<Point> slots = new HashSet<>();

    private ArrayList<Integer> graph[];

    private void setSlots(int v, int x, int y) {
        if(used.get(v)) return;
        used.set(v, true);

        while(slots.contains(new Point(x, y))) {
            x++;
        }

        slots.add(new Point(x, y));
        vertexList.add(new Vertex(v, 70 * x + 15, 70 * y + 15));

        for(int i = 0; i < graph[v].size(); ++i) {
            setSlots(graph[v].get(i), x + i, y + 1);
        }
    }

    public GraphJComponent(Graph _graphAnnotation, ArrayList<Selector> _selectors, Object _value) {
        selectors = _selectors;
        graphAnnotation= _graphAnnotation;
        value = _value;

        graph = getGraph();

        Collections.sort(selectors, (s1, s2) -> Integer.compare(s2.getPriority(), s1.getPriority()));

        used = new ArrayList<>();

        for(int i = 0; i < graph.length; ++i) {
            used.add(false);
        }

        DragAndDrop listener = new DragAndDrop(this);
        addMouseListener(listener);
        addMouseMotionListener(listener);

        for(int i = 0; i < graph.length; ++i) {
            setSlots(i, i, 0);
        }

        Collections.sort(vertexList, Comparator.comparingInt(Vertex::getIndex));

        for(int i = 0; i < graph.length; ++i) {
            for(Integer e : graph[i]) {
                vertexList.get(i).addEdge(new Edge(vertexList.get(i), vertexList.get(e)));
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); //сглаживание
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);


        for(Vertex v : vertexList) {
            int color = 0;
            for (Selector s : selectors) {
                if(color != 0) break;
                color = s.isSelected(v.getIndex());
            }

            v.draw(g2, colors.get(color), graphAnnotation.isOriented());
        }
    }

    public Iterator<Vertex> getVertexIter() {
        return vertexList.iterator();
    }
}
