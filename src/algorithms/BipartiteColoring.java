package algorithms;

import visualizer.Visualizer;
import visualizer.selector.multi.MultiSelectorAnnotation;
import visualizer.selector.single.SingleSelectorAnnotation;
import visualizer.visual.description.DescriptionAlgorithm;
import visualizer.visual.graph.Graph;

import java.util.ArrayList;

public class BipartiteColoring implements Runnable {
    @DescriptionAlgorithm
    public String description = "Начало";

    @Graph(name="graph")
    public ArrayList<Integer> graph[] = new ArrayList[13];

    @MultiSelectorAnnotation(name="graph")
    private ArrayList<Integer> colors = new ArrayList<>();

    public BipartiteColoring() {
        for(int i = 0; i < graph.length; ++i) {
            graph[i] = new ArrayList<>();
            colors.add(0);
        }

        graph[0].add(1);
        graph[0].add(2);
        graph[0].add(3);
        graph[1].add(4);
        graph[2].add(5);
        graph[2].add(6);
        graph[3].add(7);
        graph[3].add(8);
        graph[4].add(9);
        graph[4].add(10);
        graph[5].add(11);
        graph[5].add(12);
    }

    @SingleSelectorAnnotation(name="graph")
    public Integer vertex = -1;

    private boolean dfs(int v, int color) {
        if(colors.get(v) != 0 && colors.get(v) != color) {
            description = "Граф не является двудольным";
            return false;
        }

        if(colors.get(v) != 0 && colors.get(v) == color) {
            return true;
        }

        colors.set(v, color);

        vertex = v;
        description = "Заход в следующую вершину";
        Visualizer.yield();

        for(Integer e : graph[v]) {
            boolean res = dfs(e, color == 1 ? 2 : 1);
            if(!res) return false;
            vertex = v;
            description = "Выход наверх";
            Visualizer.yield();
        }

        return true;
    }

    @Override
    public void run() {
        dfs(0, 1);
    }
}
