package com.wenfengtou.fluttermixdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.android.FlutterActivityLaunchConfigs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var helloTextView : TextView = findViewById<TextView>(R.id.hello_tv)
        helloTextView.setOnClickListener {
            startActivity(
                FlutterActivity
                    .withNewEngine()
                    .initialRoute("route2")
                    .backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.transparent)
                    .build(this)
            )
        }

    }
}