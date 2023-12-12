/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package custom;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author HP
 */
public class JPanelCustom extends JPanel {

    public int getRoundTopLeft() {
        return roundTopLeft;
    }

    /**
     * @param roundTopLeft the roundTopLeft to set
     */
    public void setRoundTopLeft(int roundTopLeft) {
        this.roundTopLeft = roundTopLeft;
    }

    /**
     * @return the roundTopRight
     */
    public int getRoundTopRight() {
        return roundTopRight;
    }

    /**
     * @param roundTopRight the roundTopRight to set
     */
    public void setRoundTopRight(int roundTopRight) {
        this.roundTopRight = roundTopRight;
    }

    /**
     * @return the roundBottomLeft
     */
    public int getRoundBottomLeft() {
        return roundBottomLeft;
    }

    /**
     * @param roundBottomLeft the roundBottomLeft to set
     */
    public void setRoundBottomLeft(int roundBottomLeft) {
        this.roundBottomLeft = roundBottomLeft;
    }

    /**
     * @return the roundBottomRight
     */
    public int getRoundBottomRight() {
        return roundBottomRight;
    }

    /**
     * @param roundBottomRight the roundBottomRight to set
     */
    public void setRoundBottomRight(int roundBottomRight) {
        this.roundBottomRight = roundBottomRight;
    }
    
    private int roundTopLeft = 0;
    int roundTopRight = 0;
    int roundBottomLeft = 0;
    int roundBottomRight = 0;
    
    
    public JPanelCustom(){
        setOpaque(false);
    }
    
    @Override
    protected void paintComponent(Graphics graphic){
        Graphics2D g2 = (Graphics2D) graphic.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Area area = new Area(createRoundTopLeft());
        
        if(roundTopRight>0){
            area.intersect(new Area(createRoundTopRight()));
        }
        
        if(roundTopLeft>0){
            area.intersect(new Area(createRoundBottomLeft()));
        }
        
        if(roundBottomRight>0){
            area.intersect(new Area(createRoundBottomRight()));
        }
        
        g2.fill(area);
        g2.dispose();
        super.paintComponent(graphic);
    }

    private Shape createRoundTopLeft() {
        int width = getWidht();
        int height = getHeight();
        int roundX=Math.min(width, roundTopLeft);
        int roundY=Math.min(height, roundTopLeft);
        
        Area area = new Area(new RoundRectangle2D.Double(0,0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, width)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundBottomLeft() {
        int width = getWidht();
        int height = getHeight();
        int roundX=Math.min(width, roundBottomLeft);
        int roundY=Math.min(height, roundBottomLeft);
        
        Area area = new Area(new RoundRectangle2D.Double(0,0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundTopRight() {
        int width = getWidht();
        int height = getHeight();
        int roundX=Math.min(width, roundTopRight);
        int roundY=Math.min(height, roundTopRight);
        
        Area area = new Area(new RoundRectangle2D.Double(0,0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, width)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundBottomRight() {
        int width = getWidht();
        int height = getHeight();
        int roundX=Math.min(width, roundBottomRight);
        int roundY=Math.min(height, roundBottomRight);
        
        Area area = new Area(new RoundRectangle2D.Double(0,0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }

    private int getWidht() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
