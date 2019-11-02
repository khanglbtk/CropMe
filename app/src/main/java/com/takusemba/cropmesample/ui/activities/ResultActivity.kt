package com.takusemba.cropmesample.ui.activities

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.takusemba.cropmesample.R
import com.takusemba.cropmesample.clients.ImageClient
import kotlin.concurrent.thread

class ResultActivity : AppCompatActivity() {

  private val imageClient: ImageClient by lazy { ImageClient(this) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_result)

    findViewById<View>(R.id.back).setOnClickListener { finish() }

    thread {
      val bitmap = imageClient.getBitmap()
      runOnUiThread {
        findViewById<ImageView>(R.id.image).setImageBitmap(bitmap)
      }
    }
  }
}
