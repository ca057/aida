package de.christianost.aida.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import de.christianost.aida.R;
import de.christianost.aida.sketch.Sketch;
import de.christianost.aida.sketch.processing.ProcessingSketch;
import processing.android.CompatUtils;
import processing.android.PFragment;

public class SketchActivity extends AppCompatActivity {

    private Sketch sketch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sketch);

        FrameLayout frame = findViewById(R.id.sketchFrame);
        frame.setId(CompatUtils.getUniqueViewId());

        sketch = new ProcessingSketch(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        PFragment fragment = new PFragment((ProcessingSketch) sketch);
        fragment.setView(frame, this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // TODO: save shit here
    }

    public void onSaveSketch(View view) {
    }

    public void onGoBack(View view) {
        // TODO: save image here first in case people want to restore it
        finish();
    }
}
