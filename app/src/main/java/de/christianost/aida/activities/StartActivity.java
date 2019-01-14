package de.christianost.aida.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import de.christianost.aida.R;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    /**
     * Handles clicking the "Create New Sketch" button.
     *
     * @param view
     */
    public void onCreateNewSketch(View view) {
        Intent intent = new Intent(this, SketchActivity.class);
        startActivity(intent);
    }
}
