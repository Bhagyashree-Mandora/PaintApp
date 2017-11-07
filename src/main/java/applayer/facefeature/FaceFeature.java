package main.java.applayer.facefeature;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FaceFeature extends JComponent {

  private Point location;
  private float scale;
  private volatile int screenX = 0;
  private volatile int screenY = 0;
  private volatile int myX = 0;
  private volatile int myY = 0;

  public FaceFeature() {
    setBounds(0, 0, 100, 100);
    setOpaque(false);

    addMouseListener(new MouseAdapter() {

      @Override
      public void mousePressed(MouseEvent e) {
        getParent().dispatchEvent(e);

        screenX = e.getXOnScreen();
        screenY = e.getYOnScreen();

        myX = getX();
        myY = getY();
      }
    });

    addMouseMotionListener(new MouseMotionListener() {

      @Override
      public void mouseDragged(MouseEvent e) {
        int deltaX = e.getXOnScreen() - screenX;
        int deltaY = e.getYOnScreen() - screenY;

        setLocation(myX + deltaX, myY + deltaY);
      }

      @Override
      public void mouseMoved(MouseEvent e) { }

    });
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (isOpaque()) {
      g.setColor(getBackground());
      g.fillRect(0, 0, getWidth(), getHeight());
    }
  }
}