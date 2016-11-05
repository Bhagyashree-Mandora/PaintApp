package main.usu.swingpaint;

import main.usu.swingpaint.applayer.command.Command;
import main.usu.swingpaint.applayer.command.CommandFactory;
import main.usu.swingpaint.applayer.command.Invoker;
import main.usu.swingpaint.applayer.receiver.Drawing;
import main.usu.swingpaint.applayer.facefeature.FaceFeatureWithAllStates;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SwingPaint {
    private JButton clearBtn, removeBtn, duplicateBtn, saveBtn, loadBtn, undoBtn;
    private JButton eyeBtn, noseBtn, earBtn, lipsBtn;
    private JPanel canvas;

    private Invoker invoker = new Invoker();
    private CommandFactory commandFactory;
    private FaceFeatureWithAllStates selectedImage = null;

    void show() {
        JFrame frame = new JFrame("Swing paint");
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel controls = buildButtonPanel();
        frame.add(controls, BorderLayout.NORTH);

        buildCanvas();
        frame.add(canvas, BorderLayout.CENTER);

        canvas.repaint();
        Drawing drawing = new Drawing(canvas);
        commandFactory = new CommandFactory(drawing);
    }


    private void buildCanvas() {
        canvas = new JPanel();
        canvas.setBackground(Color.darkGray);
        canvas.setLayout(null);
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getSource().getClass().equals(FaceFeatureWithAllStates.class)) {
                    selectedImage = (FaceFeatureWithAllStates) e.getSource();
                }
            }
        });
    }

    private JPanel buildButtonPanel() {
        JPanel controls = new JPanel();

        clearBtn = new JButton("clear");
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
        saveBtn = new JButton("Save");
        saveBtn.addActionListener(actionListener);
        loadBtn = new JButton("Load");
        loadBtn.addActionListener(actionListener);
        undoBtn = new JButton("undo");
        undoBtn.addActionListener(actionListener);

        controls.add(clearBtn);
        controls.add(eyeBtn);
        controls.add(noseBtn);
        controls.add(earBtn);
        controls.add(lipsBtn);
        controls.add(removeBtn);
        controls.add(duplicateBtn);
        controls.add(saveBtn);
        controls.add(loadBtn);
        controls.add(undoBtn);

        return controls;
    }

    private ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == eyeBtn) {
                Command command = commandFactory.create("add","eye");
                invoker.enqueueAndExecuteCommand(command);
            } else if (event.getSource() == noseBtn) {
                Command command = commandFactory.create("add","nose");
                invoker.enqueueAndExecuteCommand(command);
            } else if (event.getSource() == earBtn) {
                Command command = commandFactory.create("add", "ear");
                invoker.enqueueAndExecuteCommand(command);
            } else if (event.getSource() == lipsBtn) {
                Command command = commandFactory.create("add", "lips");
                invoker.enqueueAndExecuteCommand(command);
            } else if (event.getSource() == removeBtn) {
                Command command = commandFactory.create("remove", selectedImage);
                invoker.enqueueAndExecuteCommand(command);
            } else if (event.getSource() == duplicateBtn) {
                Command command = commandFactory.create("duplicate", selectedImage);
                invoker.enqueueAndExecuteCommand(command);
            } else if (event.getSource() == saveBtn) {
                Command command = commandFactory.create("save");
                invoker.enqueueAndExecuteCommand(command);
            } else if (event.getSource() == loadBtn) {
                Command command = commandFactory.create("load");
                invoker.enqueueAndExecuteCommand(command);
            } else if (event.getSource() == undoBtn) {
                invoker.undo();
            } else if (event.getSource() == clearBtn) {
//                Command command = commandFactory.create("clear");
//                invoker.enqueueAndExecuteCommand(command);
                clear();
            }
        }
    };

    private void clear() {
        canvas.removeAll();
        canvas.repaint();
    }
}