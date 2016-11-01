package main.usu.swingpaint;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class SwingPaint {
    private static final String IMAGES_PATH = "/images/";
    private JButton clearBtn, removeBtn, duplicateBtn;
    private JButton eyeBtn, noseBtn, earBtn, lipsBtn;

    private DraggableImageComponent selectedImage = null;

    private JPanel canvas;

    private ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == clearBtn) {
                clear();
            } else if (event.getSource() == eyeBtn) {
                addFeature(new Eye());
            } else if (event.getSource() == noseBtn) {
                addFeature(new Nose());
            } else if (event.getSource() == earBtn) {
                addFeature(new Ear());
            } else if (event.getSource() == lipsBtn) {
                addFeature(new Lips());
            } else if (event.getSource() == removeBtn) {
                removeSelectedImage();
            } else if (event.getSource() == duplicateBtn) {
                duplicateSelectedImage();
            }
        }
    };

//    private void addEye() {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                addNewPhoto("image.png");
//            }
//        });
//    }
//
//    private void addNose() {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                addNewPhoto("image.png");
//            }
//        });
//    }

    private void addFeature(FaceFeature faceFeature) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                AddFaceFeature addFaceFeature = new AddFaceFeature(faceFeature);
                BufferedImage image = addFaceFeature.execute();

                DraggableImageComponent photo = new DraggableImageComponent();
                canvas.add(photo);
                photo.setImage(image);
                photo.setAutoSize(true);
                photo.setBorder(new LineBorder(Color.black, 1));

                canvas.repaint();
//        addNewPhoto("image.png");
            }
        });
    }
//
//    private void addLips() {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                addNewPhoto("image.png");
//            }
//        });
//    }

    private void removeSelectedImage() {
        if (selectedImage != null) {
            canvas.remove(selectedImage);
        }
        canvas.repaint();
    }

    private void duplicateSelectedImage() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                addNewPhoto("image.png");
            }
        });
    }

    void show() {
        JFrame frame = new JFrame("Swing paint");
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel controls = buildButtonPanel();
        frame.add(controls, BorderLayout.NORTH);

        buildCanvas();
        frame.add(canvas, BorderLayout.CENTER);
        loadImages();
    }

    private void buildCanvas() {
        canvas = new JPanel();
        canvas.setBackground(Color.darkGray);
        canvas.setLayout(null);
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getSource().getClass().equals(DraggableImageComponent.class)) {
                    selectedImage = (DraggableImageComponent) e.getSource();
                }
            }
        });
    }

    private void loadImages() {
        EventQueue.invokeLater(() -> addNewPhoto("image.png"));
        clear();
    }

    private JPanel buildButtonPanel() {
        JPanel controls = new JPanel();

        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(actionListener);
        eyeBtn = new JButton("Eye");
        eyeBtn.addActionListener(actionListener);
        noseBtn = new JButton("Nose");
        noseBtn.addActionListener(actionListener);
        earBtn = new JButton("Ear");
        earBtn.addActionListener(actionListener);
        lipsBtn = new JButton("Lips");
        lipsBtn.addActionListener(actionListener);
        removeBtn = new JButton("Remove");
        removeBtn.addActionListener(actionListener);
        duplicateBtn = new JButton("Duplicate");
        duplicateBtn.addActionListener(actionListener);

        controls.add(clearBtn);
        controls.add(eyeBtn);
        controls.add(noseBtn);
        controls.add(earBtn);
        controls.add(lipsBtn);
        controls.add(removeBtn);
        controls.add(duplicateBtn);

        return controls;
    }

    private void clear() {
        canvas.removeAll();
        canvas.repaint();
    }

    private void addNewPhoto(String fileName) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(this.getClass().getResource(IMAGES_PATH + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        DraggableImageComponent photo = new DraggableImageComponent();
        canvas.add(photo);
        photo.setImage(image);
        photo.setAutoSize(true);
        photo.setBorder(new LineBorder(Color.black, 1));

        canvas.repaint();
    }
}
