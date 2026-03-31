package com.example.socialspark

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This line connects this Kotlin file to the XML layout
        setContentView(R.layout.activity_main)


        val etTimeInput = findViewById<EditText>(R.id.etTimeInput)
        val btnGetSpark = findViewById<Button>(R.id.btnGetSpark)
        val btnReset    = findViewById<Button>(R.id.btnReset)
        val tvResult    = findViewById<TextView>(R.id.tvResult)

        // Tell the Get Spark button what to do when clicked
        btnGetSpark.setOnClickListener {

            // Get what the user typed, make it lowercase so "Morning" = "morning"
             val userInput = etTimeInput.text.toString().lowercase().trim()

            // Use Log.d to see what the user typed in the Logcat window
            Log.d("SocialSparks", "User typed: $userInput")


            // Check if the user typed anything
            if (userInput.isEmpty()) {
                Toast.makeText(this, "Please enter a time of day", Toast.LENGTH_SHORT).show()

            } else if (userInput.contains("mid-morning") || userInput.contains("mid morning")) {
                tvResult.text = "Send a thank you message to a colleague "
                Log.d("SocialSparks", "Spark shown: Mid-morning")

            } else if (userInput.contains("morning")) {
                tvResult.text = "Send a good morning text to a family member "
                Log.d("SocialSparks", "Spark shown: Morning")

            } else if (userInput.contains("snack")) {
                tvResult.text = "Send a thinking of you message "
                Log.d("SocialSparks", "Spark shown: Snack")

            } else if (userInput.contains("after dinner") || userInput.contains("night")) {
                tvResult.text = "Leave a comment on a friend's post "
                Log.d("SocialSparks", "Spark shown: Night")

            } else if (userInput.contains("dinner")) {
                tvResult.text = "Call someone for a quick catch-up "
                Log.d("SocialSparks", "Spark shown: Dinner")

            } else if (userInput.contains("afternoon")) {
                tvResult.text = "Share a meme with a friend "
                Log.d("SocialSparks", "Spark shown: Afternoon")

            } else {

                Toast.makeText(
                    this,
                    "Try something like Morning, Afternoon, dinner or Night",
                    Toast.LENGTH_LONG
                ).show()
                Log.d("SocialSparks", "No match found for: $userInput")
            }
        }

        // Tell the Reset button what to do when clicked
        btnReset.setOnClickListener {
            etTimeInput.text.clear()
            tvResult.text = ""
            Log.d("SocialSparks", "App was reset")
        }
    }
}
