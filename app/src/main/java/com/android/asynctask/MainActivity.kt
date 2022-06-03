package com.android.asynctask

import android.app.DownloadManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        editText = findViewById(R.id.input)
        button  = findViewById(R.id.download)
        button.setOnClickListener {
            val url = editText.text.toString()
            val request = DownloadManager.Request(Uri.parse(url))
                .setTitle("file")
                .setDescription("Downloading.....")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                .setAllowedOverMetered(true)

            val dm = getSystemService(DOWNLOAD_SERVICE) as DownloadManager

            dm.enqueue(request)
        }
    }
}