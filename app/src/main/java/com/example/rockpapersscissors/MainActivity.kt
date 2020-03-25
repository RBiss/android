package com.example.rockpapersscissors

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity() {

    lateinit var imageYou: ImageView
    lateinit var rpsPaperButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the Button view from the layout and assign a click
        // listener to it.
        val rpsRockButton: Button = findViewById(R.id.button_rock)
        button_rock.setOnClickListener { yourSelection(button_rock) }

        rpsPaperButton = findViewById(R.id.paper_image)
        rpsPaperButton.setOnClickListener { yourSelection(rpsPaperButton) }

        val rpsScissorButton: Button = findViewById(R.id.button_scissors)
        button_scissors.setOnClickListener { yourSelection(button_scissors) }

        imageYou = findViewById(R.id.imageYou)
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

        imageYou .setImageResource(drawableResource)

    }

    fun yourSelection(v: View){
        if (v.id.toString() == rpsPaperButton.id.toString()) {

                imageYou = R(com.example.rockpapersscissors(button_rock))


              } else if
            (v.id.toString() == button_paper.id.toString()) {
                imageYou = R(com.example.rockpapersscissors(button_paper))
            }
        } else
            (v.id.toString() == button_scissors.id.toString()) {
                imageYou  = R(com.example.rockpapersscissors(button_scissors))

            }
        }

        fun startGame(){

            return yourSelection()
        }


}



// private operator fun ImageView.invoke(button: Any) {

//}
