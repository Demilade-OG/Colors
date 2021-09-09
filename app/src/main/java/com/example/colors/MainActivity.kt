package com.example.colors

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.create_the_color)?.setOnClickListener {
           /** assigns text input edit text id to variables **/
            var red = findViewById<TextInputEditText>(R.id.red_channel)?.text.toString()
            var green = findViewById<TextInputEditText>(R.id.green_channel)?.text.toString()
            var blue = findViewById<TextInputEditText>(R.id.blue_channel)?.text.toString()
            /** check if the whole boxes have been filled **/
                if (red.isEmpty() or
                        green.isEmpty()
                        or blue.isEmpty()) {
                    Toast.makeText(this, "All Values are required",
                            Toast.LENGTH_LONG).show()
                } else {
                    /** if only one entry was entered it should be added again **/
                    if (red.length == 1) red = red.plus(red)
                    if (green.length == 1) green = green.plus(green)
                    if (blue.length == 1) blue = blue.plus(blue)

                    /** This changes the hex code to something the computer can understand **/
                    val resultCreateColor = red.plus(green).plus(blue)
                    val colorAsInt = Color.parseColor("#".plus(resultCreateColor))
                    findViewById<TextView>(R.id.result_create_color)?.setBackgroundColor(colorAsInt)
                }

            }
        }

    }
