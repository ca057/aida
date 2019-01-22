package de.christianost.aida.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import de.christianost.aida.R

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
    }

    /**
     * Handles clicking the "Create New ProcessingSketch" button.
     *
     * @param view
     */
    fun onCreateNewSketch(view: View) {
        val intent = Intent(this, SketchActivity::class.java)
        startActivity(intent)
    }
}
