package de.christianost.aida.activities

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout

import de.christianost.aida.R
import de.christianost.aida.hardware.AccelerometerListener
import de.christianost.aida.sketch.Sketch
import de.christianost.aida.sketch.processing.ProcessingSketch
import processing.android.CompatUtils
import processing.android.PFragment

class SketchActivity : AppCompatActivity() {

    private var sketch: Sketch? = null
    private var manager: SensorManager? = null
    private var accelerometerSensor: Sensor? = null
    private var accelerometerListener: AccelerometerListener = AccelerometerListener()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sketch)

        // get frame to render the sketch in
        val frame = findViewById<FrameLayout>(R.id.sketchFrame)
        frame.id = CompatUtils.getUniqueViewId()

        // create sketch
        sketch = ProcessingSketch(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        val fragment = PFragment(sketch as ProcessingSketch?)
        fragment.setView(frame, this)

        // get manager and sensors
        manager = this.getSystemService(Context.SENSOR_SERVICE) as? SensorManager
        accelerometerSensor = manager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    }

    override fun onPause() {
        super.onPause()

        manager?.unregisterListener(accelerometerListener)
        // TODO("save shit here")
    }

    override fun onResume() {
        super.onResume()
        manager?.registerListener(accelerometerListener, accelerometerSensor, SensorManager.SENSOR_DELAY_GAME)
    }

    fun onSaveSketch(view: View) {}

    fun onGoBack(view: View) {
        // TODO: save image here first in case people want to restore it
        finish()
    }

}
