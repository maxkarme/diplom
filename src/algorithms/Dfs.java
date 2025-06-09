package algorithms;

import visualizer.Visualizer;
import visualizer.selector.multi.MultiSelectorAnnotation;
import visualizer.selector.single.SingleSelectorAnnotation;
import visualizer.visual.description.DescriptionAlgorithm;
import visualizer.visual.graph.Graph;

import java.util.ArrayList;

public class Dfs implements Runnable {
    @DescriptionAlgorithm
    public String description = "Начало";

    @Graph(name="graph")
    public ArrayList<Integer> graph[] = new ArrayList[13];

    @MultiSelectorAnnotation(name="graph")
    private ArrayList<Boolean> used = new ArrayList<>();

    public Dfs() {
        for(int i = 0; i < graph.length; ++i) {
            graph[i] = new ArrayList<>();
            used.add(false);
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

    private void dfs(int v) {
        if(used.get(v)) return;
        used.set(v, true);

        vertex = v;
        description = "Заход в следующую вершину";
        Visualizer.yield();

        for(Integer e : graph[v]) {
            dfs(e);
            vertex = v;
            description = "Выход наверх";
            Visualizer.yield();
        }
    }

    @Override
    public void run() {
        dfs(0);
    }
}
