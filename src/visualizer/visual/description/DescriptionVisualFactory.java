package visualizer.visual.description;

import visualizer.StateAdapter;
import visualizer.selector.Selector;
import visualizer.visual.VisualComponent;
import visualizer.visual.VisualFactory;
import visualizer.visual.description.adapter.DescriptionAdapterFactory;

import javax.swing.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class DescriptionVisualFactory implements VisualFactory {
    @Override
    public VisualComponent buildComponent(Object instance, Field field, ArrayList<Selector> selectors, Annotation annotation) {
        field.setAccessible(true);

        try {
            String text = (String) field.get(instance);
            StringBuilder textWithNewLines = new StringBuilder();

            textWithNewLines.append("<html>");

            int cnt = 0;

            for(int i = 0; i < text.length(); ++i) {
                if(cnt > 100 && text.charAt(i) == ' ') {
                    textWithNewLines.append("<br>");
                    cnt = 0;
                    continue;
                }

                textWithNewLines.append(text.charAt(i));
                cnt++;
            }

            StateAdapter adapter = DescriptionAdapterFactory.getAdapter(field, instance);

            return new DescriptionVisual(instance, field, adapter);
//            JLabel res = new JLabel(textWithNewLines.toString());
//            return res;
        } catch(Exception ex) {
            System.out.println("Error in DescriptionVisualFactory");
        }

        return null;
    }
}
