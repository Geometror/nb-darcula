package com.revivius.nb.darcula.ui;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import java.awt.*;

/**
 * A minor re-write of DarculaButtonUI to prevent painting background when
 * content area filled property is set to false on button and painting a
 * noticable background if button is selected.
 *
 * Adapted from modified DarculaButtonUI.
 *
 * @author Revivius
 */
public class ContentAreaAwareToggleButtonUI extends ContentAreaAwareButtonUI {

    public static ComponentUI createUI(JComponent c) {
        return new ContentAreaAwareToggleButtonUI();
    }

    @Override
    protected Paint getBackgroundPaint(JComponent c) {
        JToggleButton b = (JToggleButton) c;
        if (b.isSelected()) {
            return getButtonColor();
        }
        return getButtonColor();
    }

    @Override
    public void update(Graphics g, JComponent c) {
        super.update(g, c);
    }

    protected Color getButtonColor() {
        return UIManager.getColor("Button.darcula.color");
    }

}
