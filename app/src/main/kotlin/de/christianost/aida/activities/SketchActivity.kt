package de.christianost.aida.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout

import de.christianost.aida.R
import de.christianost.aida.sketch.Sketch
import de.christianost.aida.sketch.processing.ProcessingSketch
import processing.android.CompatUtils
import processing.android.PFragment

class SketchActivity : AppCompatActivity() {

    private var sketch: Sketch? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sketch)

        val frame = findViewById<FrameLayout>(R.id.sketchFrame)
        frame.id = CompatUtils.getUniqueViewId()

        sketch = ProcessingSketch(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        val fragment = PFragment(sketch as ProcessingSketch?)
        fragment.setView(frame, this)
    }

    override fun onPause() {
        super.onPause()

        // TODO: save shit here
    }

    fun onSaveSketch(view: View) {}

    fun onGoBack(view: View) {
        // TODO: save image here first in case people want to restore it
        finish()
    }
}
