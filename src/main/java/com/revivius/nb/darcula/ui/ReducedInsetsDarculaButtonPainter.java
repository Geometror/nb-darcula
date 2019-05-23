package com.revivius.nb.darcula.ui;

import com.bulenkov.darcula.ui.DarculaButtonUI;
import com.bulenkov.iconloader.util.GraphicsConfig;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.InsetsUIResource;
import javax.swing.plaf.UIResource;
import java.awt.*;

/**
 * A minor re-write of DarculaButtonPainter to reduce border insets.
 * 
 * Mostly copy paste from DarculaButtonPainter.
 *
 * @author Revivius
 */
public class ReducedInsetsDarculaButtonPainter implements Border, UIResource {

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        boolean square = DarculaButtonUI.isSquare(c);

        final GraphicsConfig config = new GraphicsConfig(g);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_DEFAULT);

        if (c.hasFocus()) {
            ((Graphics2D) g).setPaint(getButtonSelectedBorderColor());
        } else {
            ((Graphics2D) g).setPaint(getButtonBorderColor());
        }

        int arc = 5;
        if (square) {
            arc = 3;
        }
        g.drawRoundRect(x + 1, y + 1, width - 2, height - 2, arc, arc);

        config.restore();

    }

    @Override
    public Insets getBorderInsets(Component c) {
        if (DarculaButtonUI.isSquare(c)) {
            return new InsetsUIResource(2, 0, 2, 0);
        }
        return new InsetsUIResource(4, 6, 4, 6);
    }

    protected Color getButtonBorderColor() {
        return UIManager.getColor("Button.darcula.bordercolor");
    }

    protected Color getButtonSelectedBorderColor() {
        return UIManager.getColor("Button.darcula.selectedbordercolor");
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }
}
