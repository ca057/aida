package de.christianost.aida.hardware

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener

class AccelerometerListener : SensorEventListener {
    private var ax = 0f
    private var ay = 0f
    private var az = 0f

    override fun onSensorChanged(event: SensorEvent) {
        ax = event.values[0]
        ay = event.values[1]
        az = event.values[2]
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // TODO("not implemented")
    }

    fun getLatestValues() : Array<Float> {
        return arrayOf(ax, ay, az)
    }
}