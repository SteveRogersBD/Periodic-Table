package com.aniruddha.researchproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Retrieve the selected layout ID from the intent extras
        val selectedLayoutId = intent.getIntExtra("selectedLayoutId", -1)

        // Check if a valid layout ID is received
        if (selectedLayoutId != -1) {
            // Inflate the selected layout based on the ID
            setContentView(selectedLayoutId)

            // Find the "Visit Wikipedia" TextView in the layout
            val wikiLinkTextView: TextView = findViewById(R.id.wiki_link)

            // Set OnClickListener to open Wikipedia page
            wikiLinkTextView.setOnClickListener {
                val selectedElement = intent.getSerializableExtra("selectedElement") as? Element
                selectedElement?.let {
                    var wikiLink = getWikipediaLink(selectedElement.atomicNumber)
                    if (wikiLink.isNotEmpty()) {
                        val wikiIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Hydrogen"))
                        startActivity(wikiIntent)
                    } else {
                        Toast.makeText(this, "No Wikipedia link available", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun getWikipediaLink(atomicNumber: Int): String {
        return when (atomicNumber) {
            1 -> "https://en.wikipedia.org/wiki/Hydrogen"
            2 -> "https://en.wikipedia.org/wiki/Helium"
            else -> {""}
        }
    }
}


