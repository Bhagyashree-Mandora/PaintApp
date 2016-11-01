package main.usu.swingpaint;

import java.awt.image.BufferedImage;

public interface Command {
    BufferedImage execute();
}