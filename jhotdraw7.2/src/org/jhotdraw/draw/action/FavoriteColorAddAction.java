/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;

import java.awt.Color;
import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import org.jhotdraw.color.FavoriteColors;
import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.gui.FavoriteColorsPopupButton;
import org.jhotdraw.samples.svg.SVGDrawingPanel;
import org.jhotdraw.samples.svg.gui.AbstractToolBar;

/**
 *
 * @author Kap
 */
public class FavoriteColorAddAction extends AttributeAction {
    protected AttributeKey<Color> key;
    
    /** Creates a new instance. */
    public FavoriteColorAddAction(DrawingEditor editor, AttributeKey<Color> key) {
        this(editor, key, null, null);
    }

    /** Creates a new instance. */
    public FavoriteColorAddAction(DrawingEditor editor, AttributeKey<Color> key, Icon icon) {
        this(editor, key, null, icon);
    }

    /** Creates a new instance. */
    public FavoriteColorAddAction(DrawingEditor editor, AttributeKey<Color> key, String name) {
        this(editor, key, name, null);
    }

    public FavoriteColorAddAction(DrawingEditor editor, final AttributeKey<Color> key, String name, Icon icon) {
        this(editor, key, name, icon, new HashMap<AttributeKey, Object>());
    }

    public FavoriteColorAddAction(DrawingEditor editor, final AttributeKey<Color> key, String name, Icon icon,
            Map<AttributeKey, Object> fixedAttributes) {
        super(editor, fixedAttributes, name, icon);
        this.key = key;
        putValue(AbstractAction.NAME, name);
        putValue(AbstractAction.SMALL_ICON, icon);
        setEnabled(true);
    }
    
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        System.out.println("Added color");
        Color initialColor = getInitialColor();
        FavoriteColors.getInstance().addFavoriteColor(new ColorIcon(initialColor));
        
    }
    
    protected Color getInitialColor() {
        Color initialColor = (Color) getEditor().getDefaultAttribute(key);
        if (initialColor == null) {
            initialColor = Color.red;
        }
        return initialColor;
    }
}
