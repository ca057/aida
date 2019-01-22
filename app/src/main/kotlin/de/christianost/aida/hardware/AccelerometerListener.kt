package de.christianost.aida.hardware

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener

class AccelerometerListener : SensorEventListener {
    private var ax = 0f;

    override fun onSensorChanged(event: SensorEvent) {
        ax = event.values[0]
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}