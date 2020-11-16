package com.wenfengtou.fluttermixdemo

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var helloTextView : TextView = findViewById<TextView>(R.id.hello_tv)
        helloTextView.setOnClickListener {
            /*
            startActivity(
                FlutterActivity
                    .withCachedEngine("my_engine_id")
                    .backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.transparent)
                    .build(this)
            )
             */
            var intent: Intent = Intent(MainActivity@ this, WebViewActivity::class.java)
            startActivity(intent)
        }
        val intent: Intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
        startActivityForResult(intent, 1)

    }
}