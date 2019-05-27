package com.revivius.nb.darcula;

import com.bulenkov.iconloader.util.GraphicsConfig;
import com.bulenkov.iconloader.util.GraphicsUtil;

import javax.swing.*;
import java.awt.*;

/**
 * Copy paste from o.n.swing.plaf.
 * @author Revivius
 */
public final class ToolbarXP extends JPanel {

    /** Width of grip. */
    private static final int GRIP_WIDTH = 7;
    /** Minimum size. */
    private final Dimension dim;
    /** Maximum size. */
    private final Dimension max;

    public ToolbarXP() {
        dim = new Dimension(GRIP_WIDTH, GRIP_WIDTH);
        max = new Dimension(GRIP_WIDTH, Integer.MAX_VALUE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color col = UIManager.getColor("controlShadow"); //NOI18N
        Graphics2D g2d = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(2,BasicStroke.CAP_ROUND,BasicStroke.JOIN_BEVEL,0);
        GraphicsConfig config = GraphicsUtil.setupAAPainting(g);
        g.setColor(col);
        g2d.setStroke(stroke);


        g.drawLine(1, 1, 1, getHeight() - 1);
        config.restore();
    }

    /**
     * @return minimum size
     */
    @Override
    public Dimension getMinimumSize() {
        return dim;
    }

    @Override
    public Dimension getMaximumSize() {
        return max;
    }

}
