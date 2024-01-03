package com.DesktopSwingApp.app.GUI;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Canvas extends JPanel {
    private int prevX, prevY;
    private int currentX, currentY;
    private boolean drawing;

    public Canvas() {
        setDoubleBuffered(false);
        setBackground(Color.white);

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent e) {
                prevX = e.getX();
                prevY = e.getY();
                drawing = true;
            }

            public void mouseReleased(java.awt.event.MouseEvent e) {
                drawing = false;
            }
        });

        addMouseMotionListener(new java.awt.event.MouseAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent e) {
                if (drawing) {
                    currentX = e.getX();
                    currentY = e.getY();

                    if (getGraphics() != null) {
                        Graphics2D g2 = (Graphics2D) getGraphics();
                        g2.drawLine(prevX, prevY, currentX, currentY);
                        prevX = currentX;
                        prevY = currentY;
                    }
                }
            }
        });
    }
}