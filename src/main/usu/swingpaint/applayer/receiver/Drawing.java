package main.usu.swingpaint.applayer.receiver;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import main.usu.swingpaint.applayer.facefeature.FaceFeature;
import main.usu.swingpaint.applayer.facefeature.FaceFeatureExtrinsicState;
import main.usu.swingpaint.applayer.facefeature.FaceFeatureFactory;
import main.usu.swingpaint.applayer.facefeature.FaceFeatureWithAllStates;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Drawing {
    public static final String FILE_NAME = "savedDrawing";
    private JPanel canvas;
    private List<FaceFeature> faceFeatures = new ArrayList<>();

    public Drawing(JPanel canvas) {
        this.canvas = canvas;
    }

    public void add(FaceFeature faceFeature) {
        faceFeatures.add(faceFeature);
        canvas.add(faceFeature);
        canvas.repaint();
    }

    public void remove(FaceFeature faceFeature) {
        if (faceFeature != null) {
            faceFeatures.remove(faceFeature);
            canvas.remove(faceFeature);
        }
        canvas.repaint();
    }

    public void save() {
        List<FaceFeatureExtrinsicState> extrinsicStates = new ArrayList<>();

        for (FaceFeature faceFeature : faceFeatures) {
            FaceFeatureWithAllStates faceFeatureWithAllStates = (FaceFeatureWithAllStates) faceFeature;
            FaceFeatureExtrinsicState fac = faceFeatureWithAllStates.getExtrinsicState();
            fac.setLocation(faceFeatureWithAllStates.getLocation());
            extrinsicStates.add(faceFeatureWithAllStates.getExtrinsicState());
        }

        Gson gson = new Gson();
        File file = new File(FILE_NAME);
        file.delete();
        try {
            Writer osWriter = new OutputStreamWriter(new FileOutputStream(FILE_NAME));
            gson.toJson(extrinsicStates, osWriter);
            osWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load() {
        Gson gson = new Gson();
        Type typeOfListOfObjects = new TypeToken<List<FaceFeatureExtrinsicState>>() {
        }.getType();

        List<FaceFeatureExtrinsicState> loadedList = null;
        try {
            Reader inputStreamReader = new InputStreamReader(new FileInputStream((FILE_NAME)));
            loadedList = Collections.synchronizedList(
                    (List<FaceFeatureExtrinsicState>) gson.fromJson(inputStreamReader, typeOfListOfObjects)
            );
            inputStreamReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FaceFeatureFactory faceFeatureFactory = new FaceFeatureFactory();
        for (FaceFeatureExtrinsicState extrinsicState : loadedList) {
            System.out.println(extrinsicState.getLocation());
            FaceFeatureWithAllStates face = faceFeatureFactory.create(extrinsicState);
            this.add(face);
        }
    }

    public void clearAll() {
        for (FaceFeature faceFeature : faceFeatures) {
//            faceFeatures.remove(faceFeature);
            this.remove(faceFeature);
        }
//        canvas.repaint();
    }
}