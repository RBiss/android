package com.example.rockpapersscissors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity: AppCompatActivity() {



    lateinit var imageYou: ImageView
    lateinit var imageComp: ImageView
    lateinit var rpsPaperButton: Button
    lateinit var rpsRockButton: Button
    lateinit var rpsScissorsButton: Button
    lateinit var playerSelect: TextView
    var randomInt: Int = 0
    var yourScore: Int = 0
    var compScore: Int = 0
    var tieScore: Int = 0
    var gamesPlayed: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the Button view from the layout and assign a click
        // listener to it.
        rpsRockButton = findViewById(R.id.button_rock)
        rpsRockButton.setOnClickListener { yourSelection(rpsRockButton) }

        rpsPaperButton = findViewById(R.id.button_paper)
        rpsPaperButton.setOnClickListener { yourSelection(rpsPaperButton) }

        rpsScissorsButton = findViewById(R.id.button_scissors)
        rpsScissorsButton.setOnClickListener { yourSelection(rpsScissorsButton) }

        buttonReset.setOnClickListener { resetScore(buttonReset) }
        scoreTextView.findViewById<View>(gameStart())

        imageYou = findViewById(R.id.imageComp)

    }

     // displays image based on player's button selection

    fun yourSelection(v: View) {


        if (v.id.toString() == rpsRockButton.id.toString()) {
            imageYou.setImageResource(R.drawable.ic_rpsrock)
            playerSelect = findViewById(R.id.button_rock)

        } else if (v.id.toString() == rpsPaperButton.id.toString()) {
            imageYou.setImageResource(R.drawable.ic_rpaper)
            playerSelect = findViewById(R.id.button_paper)
        } else {
            imageYou.setImageResource(R.drawable.ic_rscissors)
            playerSelect = findViewById(R.id.button_scissors)

        }
        rollRPS()
        resultGame()

       
     
    }
    // function resets variables to zero and redisplays the empty values by restarting gameStart()

    fun resetScore(buttonReset: Button) {

        yourScore = 0
        compScore = 0
        tieScore = 0
        gamesPlayed = 0

             gameStart()
    
    }

    // compares player selection vs computer random selection and distributes scores and runs the gameStart score function

    
    fun resultGame() {



        if (playerSelect == button_rock && randomInt == 1) {
            imageViewResult.setImageResource(R.drawable.ic_equal)
             tieScore++
            gamesPlayed++
        } else if (playerSelect == button_rock && randomInt == 2) {
           imageViewResult.setImageResource(R.drawable.ic_lose)
             compScore++
            gamesPlayed++
        } else if (playerSelect == button_rock && randomInt == 3) {
           imageViewResult.setImageResource(R.drawable.ic_check)

             yourScore++
            gamesPlayed++
        } else if (playerSelect == button_paper && randomInt == 1) {
           imageViewResult.setImageResource(R.drawable.ic_check)
             yourScore++
            gamesPlayed++
        } else if (playerSelect == button_paper && randomInt == 2) {
            imageViewResult.setImageResource(R.drawable.ic_equal)
            tieScore++
            gamesPlayed++
        } else if (playerSelect == button_paper && randomInt == 3) {
           imageViewResult.setImageResource(R.drawable.ic_lose)
                compScore++
            gamesPlayed++
        } else if (playerSelect == button_scissors && randomInt == 1) {
           imageViewResult.setImageResource(R.drawable.ic_lose)
                compScore++
            gamesPlayed++
        } else if (playerSelect == button_scissors && randomInt == 2) {
           imageViewResult.setImageResource(R.drawable.ic_check)
             yourScore++
            gamesPlayed++
        } else {
           imageViewResult.setImageResource(R.drawable.ic_equal)
                         tieScore++
            gamesPlayed++
        }
       
              gameStart()

    }
         // displays the score in the TextView id scoreTextView

    fun gameStart() {
         scoreTextView.text = ("Scores - You: $yourScore  Computer: $compScore Ties: $tieScore #Games: $gamesPlayed")
    }

    // the computers selection

    private fun rollRPS() {
        // Toast.makeText(this, "button clicked",
        //  Toast.LENGTH_SHORT).show()
        imageComp = findViewById(R.id.imageYou)
        randomInt = (1..3).random()

        val drawableResource = when (randomInt) {
            1 -> R.drawable.ic_rpsrock
            2 -> R.drawable.ic_rpaper

            else -> R.drawable.ic_rscissors
        }

        imageComp.setImageResource(drawableResource)

    }

}
              // generated to make types work together in gameStart

private fun <T> TextView.findViewById(gameStart: Unit) {

}





