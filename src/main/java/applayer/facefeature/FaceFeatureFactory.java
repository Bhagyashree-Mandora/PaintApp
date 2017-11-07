package main.java.applayer.facefeature;

import java.util.HashMap;

public class FaceFeatureFactory {

    private static HashMap<String, FaceFeatureWithIntrinsicState> commonFaceFeatureState = new HashMap<>();

    public static FaceFeatureWithAllStates create(FaceFeatureExtrinsicState extrinsicState) {
        FaceFeatureWithIntrinsicState faceFeatureIntrinsic;
        String featureType = extrinsicState.getFeatureType();

        if(commonFaceFeatureState.containsKey(featureType)) {
            faceFeatureIntrinsic = commonFaceFeatureState.get(featureType);
        } else {
            faceFeatureIntrinsic = new FaceFeatureWithIntrinsicState();
            faceFeatureIntrinsic.loadImage(featureType);
            commonFaceFeatureState.put(featureType, faceFeatureIntrinsic);
        }

        return new FaceFeatureWithAllStates(faceFeatureIntrinsic, extrinsicState);
    }
}
