package com.example.rockpapersscissors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*


class MainActivity: AppCompatActivity() {



    lateinit var imageYou: ImageView
    lateinit var imageComp: ImageView
    lateinit var rpsPaperButton: Button
    lateinit var rpsRockButton: Button
    lateinit var rpsScissorsButton: Button
    lateinit var playerSelect: TextView
    var randomInt: Int = 0
    lateinit var gameResult: ImageView
    var yourScore: Int = 0
    var compScore: Int = 0
    var tieScore: Int = 0
    lateinit var youScore: TextView
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

        imageYou = findViewById(R.id.imageComp)

    }


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

       
      //  gameScore.setText( "Score: You  "+ you_score + " Computer " + comp_score +"")  ;
    }

    fun resetScore() {

        yourScore = 0
        compScore = 0
        tieScore = 0
        gamesPlayed = 0
    }

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
        println("You $yourScore Computer $compScore Ties $tieScore Games Played $gamesPlayed")

    }

    //private fun scorecard(){
    //    gameScore.text = ("Score: You  "+ you_score + " Computer " + comp_score +"")
   // }
    /**
     * Click listener for the Roll button.
     */
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





// private operator fun ImageView.invoke(button: Any) {

//}
