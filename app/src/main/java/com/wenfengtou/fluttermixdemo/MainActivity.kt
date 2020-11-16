package com.wenfengtou.fluttermixdemo

import android.content.Intent
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
            /*
            startActivity(
                FlutterActivity
                    .withCachedEngine("my_engine_id")
                    .backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.transparent)
                    .build(this)
            )
             */
            var intent: Intent = Intent(MainActivity@this, WebViewActivity::class.java)
            startActivity(intent)
        }

    }
}