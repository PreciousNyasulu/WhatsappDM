package com.example.whatsappdm

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onClick()
    }

    fun onClick() {
        val visitLink : Button = findViewById(R.id.visitlink)
        val number  = findViewById<EditText>(R.id.phoneNumber).text
        visitLink.setOnClickListener{
            try {
                val url = "https://api.whatsapp.com/send?phone=+$number"
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                startActivity(i)
                Toast.makeText(this,"Phononumber: " +number, Toast.LENGTH_SHORT).show()
            }catch(e : ExceptionInInitializerError){
                Toast.makeText(this,"Error: " + e.message.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }
}