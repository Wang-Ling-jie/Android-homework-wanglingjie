package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        var dog_name_extra=intent.getStringExtra("dog_name")
        var dog_image_extra=intent.getIntExtra("dog_image",100)
        var dog_region_extra=intent.getStringExtra("dog_region")
        var dog_contact_extra=intent.getStringExtra("dog_contact")
        var dog_age_extra=intent.getIntExtra("dog_age",100)

        var dogname=findViewById<TextView>(R.id.name)
        var dogimage=findViewById<ImageView>(R.id.image)
        var dogregion=findViewById<TextView>(R.id.region)
        var dogcontact=findViewById<TextView>(R.id.contact)
        var dogage=findViewById<TextView>(R.id.age)

        dogname.text=dog_name_extra
        dogimage.setImageResource(dog_image_extra)
        dogregion.text="region:$dog_region_extra"
        dogcontact.text="contact:$dog_contact_extra"
        dogage.text="age:$dog_age_extra years old"

    }
}