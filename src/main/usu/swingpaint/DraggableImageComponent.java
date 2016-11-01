package main.usu.swingpaint;

import java.awt.*;
import java.awt.image.ImageObserver;

public class DraggableImageComponent extends DraggableComponent
    implements ImageObserver {
  private Image image;
  private boolean autoSize = false;
  private Dimension autoSizeDimension = new Dimension(0, 0);

  public enum Part {
    EYE("eye"),
    NOSE("nose"),
    EAR("ear"),
    LIPS("lips");

    private String value;

    Part(String value) {
      this.value = value;
    }
  }

  public DraggableImageComponent() {
    super();
    setLayout(null);
    setBackground(Color.black);
  }

  public void setImage(final Image image) {
    this.image = image;
  }

  public void setAutoSizeDimension(final Dimension dimension) {
    this.autoSizeDimension = dimension;
  }

  public void setAutoSize(final boolean autoSize) {
    this.autoSize = autoSize;
  }

  @Override
  protected void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    g2.clearRect(0, 0, getWidth(), getHeight());
    if (image != null) {
      //setAutoSizeDimension();
      g2.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    } else {
      g2.setColor(getBackground());
      g2.fillRect(0, 0, getWidth(), getHeight());
    }
  }

  public boolean imageUpdate(Image img, int infoFlags,
      int x, int y, int w, int h) {
    if (infoFlags == ALLBITS) {
      repaint();
      //setAutoSizeDimension();
      return false;
    }
    return true;
  }
}