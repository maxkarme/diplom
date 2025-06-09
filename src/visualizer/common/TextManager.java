package visualizer.common;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class TextManager {
    public static void drawCenter(Graphics2D g2, String str, int x, int y, int width, int height) {
        Rectangle2D metrics = g2.getFontMetrics().getStringBounds(str, g2);
        g2.drawString(str, x + width / 2 - (int)metrics.getWidth() / 2, y + height / 2 - (int)metrics.getY() - (int)metrics.getHeight() / 2);
    }

    public static Rectangle2D getTextBounds(Graphics2D g2, String str) {
        return g2.getFontMetrics().getStringBounds(str, g2);
    }
}
