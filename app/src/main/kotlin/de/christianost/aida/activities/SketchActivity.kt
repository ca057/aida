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
import de.christianost.aida.sketch.processing.ProcessingSketch
import processing.android.CompatUtils
import processing.android.PFragment
import android.content.Intent


class SketchActivity : AppCompatActivity() {

    private var sketch: ProcessingSketch? = null
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
        sketch = ProcessingSketch(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, accelerometerListener)
        val fragment = PFragment(sketch as ProcessingSketch?)
        fragment.setView(frame, this)

        // get manager and sensors
        manager = this.getSystemService(Context.SENSOR_SERVICE) as? SensorManager
        accelerometerSensor = manager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        // TODO: needed?
        registerAccelerometerListener()
    }

    override fun onPause() {
        super.onPause()

        unregisterAccelerometerListener()
        // TODO("save shit here")
    }

    override fun onResume() {
        super.onResume()
        registerAccelerometerListener()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        sketch?.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onNewIntent(intent: Intent) {
        sketch?.onNewIntent(intent)
    }

    fun onSaveSketch(view: View) {}

    fun onGoBack(view: View) {
        // TODO: save image here first in case people want to restore it
        finish()
    }

    private fun unregisterAccelerometerListener() {
        manager?.unregisterListener(accelerometerListener)
    }

    private fun registerAccelerometerListener() {
        manager?.registerListener(accelerometerListener, accelerometerSensor, SensorManager.SENSOR_DELAY_GAME)
    }
}
