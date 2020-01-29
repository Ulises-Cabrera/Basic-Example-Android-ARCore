package com.example.android;

import android.content.Context;

import com.google.ar.core.AugmentedImage;
import com.google.ar.core.Pose;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.math.Quaternion;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.ModelRenderable;

import java.util.concurrent.CompletableFuture;

class ArNode extends AnchorNode {

    private static CompletableFuture<ModelRenderable> modelRenderableCompletableFuture;

    ArNode(Context context, int modelID) {
        if (modelRenderableCompletableFuture == null) {
            modelRenderableCompletableFuture = ModelRenderable.builder()
                    .setRegistryId("model")
                    .setSource(context, modelID)
                    .build();
        }
    }

    void setImage(AugmentedImage image) {
        if (!modelRenderableCompletableFuture.isDone()) {
            CompletableFuture.allOf(modelRenderableCompletableFuture)
                    .thenAccept((Void aVoid) -> setImage(image)).exceptionally(throwable -> null);
        }

        setAnchor(image.createAnchor(image.getCenterPose()));
        Node node = new Node();
        Pose pose = Pose.makeTranslation(0.0f, 0.0f, 0.15f);

        node.setParent(this);
        node.setLocalPosition(new Vector3(pose.tx(), pose.ty(), pose.tz()));
        node.setLocalRotation(new Quaternion(pose.qx(), pose.qy(), pose.qz(), pose.qw()));
        node.setRenderable(modelRenderableCompletableFuture.getNow(null));
    }
}
