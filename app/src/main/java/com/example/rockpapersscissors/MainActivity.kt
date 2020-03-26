package com.example.rockpapersscissors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity() {

    lateinit var imageYou: ImageView
    lateinit var imageComp: ImageView
    lateinit var rpsPaperButton: Button
    lateinit var rpsRockButton: Button
    lateinit var rpsScissorsButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the Button view from the layout and assign a click
        // listener to it.
        rpsRockButton = findViewById(R.id.button_rock)
        rpsRockButton.setOnClickListener { yourSelection(rpsRockButton) }

        rpsPaperButton = findViewById(R.id.paper_image)
        rpsPaperButton.setOnClickListener { yourSelection(rpsPaperButton) }

        rpsScissorsButton = findViewById(R.id.button_scissors)
        rpsScissorsButton.setOnClickListener { yourSelection(rpsScissorsButton) }

        imageYou = findViewById(R.id.imageYou)
    }


    fun yourSelection(v: View) {

        if (v.id.toString() == rpsRockButton.id.toString()) {
            imageYou.setImageResource(R.drawable.ic_rrock)

        } else if (v.id.toString() == rpsPaperButton.id.toString()) {
            imageYou.setImageResource(R.drawable.ic_rpaper)

        } else {
            imageYou.setImageResource(R.drawable.ic_rscissors)


        }
        rollRPS()
    }

    fun startGame() {

       // return yourSelection()
    }

    /**
     * Click listener for the Roll button.
     */
    private fun rollRPS() {
        // Toast.makeText(this, "button clicked",
        //  Toast.LENGTH_SHORT).show()
        val randomInt = (1..3).random()

        val drawableResource = when (randomInt) {
            1 -> R.drawable.ic_rrock
            2 -> R.drawable.ic_rpaper

            else -> R.drawable.ic_rscissors
        }

        imageComp.setImageResource(drawableResource)

    }

}





// private operator fun ImageView.invoke(button: Any) {

//}
