package visualizer;

import visualizer.selector.Selector;
import visualizer.selector.SelectorCommonFactory;
import visualizer.visual.VisualCommonFactory;
import visualizer.visual.VisualComponent;

import javax.swing.*;
import java.awt.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

public class Visualizer {
    public static int Width = 700;
    public static int Height = 700;
    private final JFrame jFrame = getFrame();
    private static ArrayList<VisualComponent> components = new ArrayList<>();

    private final Runnable algoInstance;
    private JPanel componentsPane = new JPanel();

    private static HashMap<String, ArrayList<Selector>> selectorsMap = new HashMap<>();

    public static void yield() {
        for(ArrayList<Selector> arr : selectorsMap.values()) {
            for(Selector selector : arr) {
                selector.screenValue();
            }
        }

        for(VisualComponent comp : components) {
            comp.screenValue();
        }
    }

    public Visualizer(Class algo) throws InstantiationException, IllegalAccessException {
        Field[] fields = algo.getDeclaredFields();

        algoInstance = (Runnable) algo.newInstance();


        for(Field field : fields) {
            for(Annotation a : field.getAnnotations()) {
                Selector selector = SelectorCommonFactory.buildSelector(algoInstance, a, field);
                if(selector == null) continue;

                if(!selectorsMap.containsKey(selector.getName())) {
                    selectorsMap.put(selector.getName(), new ArrayList<>());
                }

                selectorsMap.get(selector.getName()).add(selector);
            }
        }

        for(Field field : fields) {
            for(Annotation a : field.getAnnotations()) {
                ArrayList<Selector> selectors = new ArrayList<>();

                if(selectorsMap.containsKey(field.getName())) {
                    selectors = selectorsMap.get(field.getName());
                }

                VisualComponent comp = VisualCommonFactory.buildComponent(algoInstance, a, field, selectors);
                if(comp != null) {
                    components.add(comp);
                    break;
                }
            }
        }

        componentsPane.setLayout(new GridBagLayout());

        for(int i = 0; i < components.size(); ++i) {
            GridBagConstraints constr = new GridBagConstraints();
            constr.fill = GridBagConstraints.BOTH;
            constr.gridx = 0;
            constr.gridy = i;
            constr.weightx = 1;
            constr.weighty = 1;

            componentsPane.add(components.get(i).getComponent(), constr);
        }
        GridBagConstraints nextConstr = new GridBagConstraints();
        nextConstr.gridx = 0;
        nextConstr.gridy = 1;


        GridBagConstraints componentsPaneConstr = new GridBagConstraints();
        componentsPaneConstr.fill = GridBagConstraints.BOTH;
        componentsPaneConstr.gridx = 0;
        componentsPaneConstr.gridy = 0;
        componentsPaneConstr.weightx = 1;
        componentsPaneConstr.weighty = 1;

        JPanel buttonsPane = new JPanel();
        JButton prev = new JButton("prev");
        JButton reset = new JButton("reset");
        JButton next = new JButton("next");

        buttonsPane.add(prev);
        buttonsPane.add(reset);
        buttonsPane.add(next);

        jFrame.add(buttonsPane, nextConstr);
        jFrame.add(componentsPane, componentsPaneConstr);
        jFrame.revalidate();
        jFrame.repaint();

        algoInstance.run();

        prev.addActionListener(e -> {
            StateComponent.changeIter(-1);

            jFrame.revalidate();
            jFrame.repaint();
        });

        reset.addActionListener(e -> {
            StateComponent.clearIter();

            jFrame.revalidate();
            jFrame.repaint();
        });

        next.addActionListener(e -> {
            StateComponent.changeIter(1);

            jFrame.revalidate();
            jFrame.repaint();
        });

    }

    private JFrame getFrame() {
        JFrame frame = new JFrame();
        frame.setLayout(new GridBagLayout());
        frame.setVisible(true);
        frame.setBounds(100, 100, Width, Height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }
}
