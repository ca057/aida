package de.christianost.aida.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import de.christianost.aida.R;
import de.christianost.aida.sketch.Sketch;
import de.christianost.aida.sketch.processing.ProcessingSketch;

public class SketchActivity extends AppCompatActivity {

    private Sketch sketch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sketch);

        sketch = new ProcessingSketch();
    }

    @Override
    protected void onPause() {
        super.onPause();

        // TODO: save shit here
    }

    public void onSaveSketch(View view) {}

    public void onGoBack(View view) {
        // TODO: save image here first in case people want to restore it
        finish();
    }
}
