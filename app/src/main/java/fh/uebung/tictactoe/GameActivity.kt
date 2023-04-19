package fh.uebung.tictactoe


import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.widget.ImageViewCompat
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*
import kotlin.concurrent.schedule

var switchPlayer = 1
lateinit var fields : Array<ImageButton>
var gamesWon = IntArray(2)



class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val animationDrawable : AnimationDrawable = gameActivity.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(4000)
        animationDrawable.start()

        val players =intent.getStringArrayListExtra("Players")



        tv_currentPlayer.setText(players!!.get(0).toString() + "'s turn")

        fields = arrayOf(imageButton, imageButton2, imageButton3, imageButton4,
            imageButton5, imageButton6, imageButton7, imageButton8, imageButton9 )



        for (field in fields) {
                field.setOnClickListener {
                    if(switchPlayer == 1){
                        if(field.getTag() == R.drawable.ic_close || field.getTag() == R.drawable.ic_circle){

                        } else {
                            field.setImageResource(R.drawable.ic_circle)
                            ImageViewCompat.setImageTintList(field, ColorStateList.valueOf(Color.parseColor("#FF3700B3")))
                            field.setTag(R.drawable.ic_circle)


                            tv_currentPlayer.setText(fh.uebung.tictactoe.players!!.get(1).toString() + "'s turn")
                            switchPlayer = 0
                            checkIfWinnerPerRound(fh.uebung.tictactoe.players!!.get(0).toString())

                        }

                    } else {
                        if(field.getTag() == R.drawable.ic_circle || field.getTag() == R.drawable.ic_close){

                        } else {
                            field.setImageResource(R.drawable.ic_close)
                            ImageViewCompat.setImageTintList(field, ColorStateList.valueOf(Color.parseColor("#FCCA16")))
                            field.setTag(R.drawable.ic_close)


                            tv_currentPlayer.setText(fh.uebung.tictactoe.players!!.get(0).toString() + "'s turn")
                            switchPlayer = 1

                            checkIfWinnerPerRound(fh.uebung.tictactoe.players!!.get(1).toString())
                        }
                    }

                }

        }




    }




    private fun checkIfWinnerPerRound(winnerRound: String){

        if(imageButton.getTag() == imageButton2.getTag() && imageButton2.getTag() == imageButton3.getTag() && imageButton.getTag() != null && imageButton2.getTag() != null && imageButton3.getTag() != null) {

            ImageViewCompat.setImageTintList(imageButton, ColorStateList.valueOf(Color.parseColor("#E80F0F")));
            ImageViewCompat.setImageTintList(imageButton2, ColorStateList.valueOf(Color.parseColor("#E80F0F")));
            ImageViewCompat.setImageTintList(imageButton3, ColorStateList.valueOf(Color.parseColor("#E80F0F")));

            addPlayerPoints(winnerRound)
            checkIfWinnerOfGame(winnerRound)

        }
        else if(imageButton4.getTag() == imageButton5.getTag() && imageButton5.getTag() == imageButton6.getTag() && imageButton4.getTag() != null && imageButton5.getTag() != null && imageButton6.getTag() != null) {

            ImageViewCompat.setImageTintList(imageButton4, ColorStateList.valueOf(Color.parseColor("#E80F0F")));
            ImageViewCompat.setImageTintList(imageButton5, ColorStateList.valueOf(Color.parseColor("#E80F0F")));
            ImageViewCompat.setImageTintList(imageButton6, ColorStateList.valueOf(Color.parseColor("#E80F0F")));

            addPlayerPoints(winnerRound)
            checkIfWinnerOfGame(winnerRound)

        }
        else if(imageButton7.getTag() == imageButton8.getTag() && imageButton8.getTag() == imageButton9.getTag() && imageButton7.getTag() != null && imageButton8.getTag() != null && imageButton9.getTag() != null){

            ImageViewCompat.setImageTintList(imageButton7, ColorStateList.valueOf(Color.parseColor("#E80F0F")));
            ImageViewCompat.setImageTintList(imageButton8, ColorStateList.valueOf(Color.parseColor("#E80F0F")));
            ImageViewCompat.setImageTintList(imageButton9, ColorStateList.valueOf(Color.parseColor("#E80F0F")));

            addPlayerPoints(winnerRound)
            checkIfWinnerOfGame(winnerRound)

        } else if(imageButton.getTag() == imageButton4.getTag() && imageButton4.getTag() == imageButton7.getTag() && imageButton.getTag() != null && imageButton4.getTag() != null && imageButton7.getTag() != null){

            ImageViewCompat.setImageTintList(imageButton, ColorStateList.valueOf(Color.parseColor("#E80F0F")));
            ImageViewCompat.setImageTintList(imageButton4, ColorStateList.valueOf(Color.parseColor("#E80F0F")));
            ImageViewCompat.setImageTintList(imageButton7, ColorStateList.valueOf(Color.parseColor("#E80F0F")));

            addPlayerPoints(winnerRound)
            checkIfWinnerOfGame(winnerRound)

        } else if(imageButton2.getTag() == imageButton5.getTag() && imageButton5.getTag() == imageButton8.getTag() && imageButton2.getTag() != null && imageButton5.getTag() != null && imageButton8.getTag() != null){

            ImageViewCompat.setImageTintList(imageButton2, ColorStateList.valueOf(Color.parseColor("#E80F0F")));
            ImageViewCompat.setImageTintList(imageButton5, ColorStateList.valueOf(Color.parseColor("#E80F0F")));
            ImageViewCompat.setImageTintList(imageButton8, ColorStateList.valueOf(Color.parseColor("#E80F0F")));

            addPlayerPoints(winnerRound)
            checkIfWinnerOfGame(winnerRound)

        } else if(imageButton3.getTag() == imageButton6.getTag() && imageButton6.getTag() == imageButton9.getTag() && imageButton3.getTag() != null && imageButton6.getTag() != null && imageButton9.getTag() != null){

            ImageViewCompat.setImageTintList(imageButton3, ColorStateList.valueOf(Color.parseColor("#E80F0F")));
            ImageViewCompat.setImageTintList(imageButton6, ColorStateList.valueOf(Color.parseColor("#E80F0F")));
            ImageViewCompat.setImageTintList(imageButton9, ColorStateList.valueOf(Color.parseColor("#E80F0F")));

            addPlayerPoints(winnerRound)
            checkIfWinnerOfGame(winnerRound)

        } else if(imageButton.getTag() == imageButton5.getTag() && imageButton5.getTag() == imageButton9.getTag() && imageButton.getTag() != null && imageButton5.getTag() != null && imageButton9.getTag() != null){

            ImageViewCompat.setImageTintList(imageButton, ColorStateList.valueOf(Color.parseColor("#E80F0F")));
            ImageViewCompat.setImageTintList(imageButton5, ColorStateList.valueOf(Color.parseColor("#E80F0F")));
            ImageViewCompat.setImageTintList(imageButton9, ColorStateList.valueOf(Color.parseColor("#E80F0F")));

            addPlayerPoints(winnerRound)
            checkIfWinnerOfGame(winnerRound)

        } else if(imageButton3.getTag() == imageButton5.getTag() && imageButton5.getTag() == imageButton7.getTag() && imageButton3.getTag() != null && imageButton5.getTag() != null && imageButton7.getTag() != null){

            ImageViewCompat.setImageTintList(imageButton3, ColorStateList.valueOf(Color.parseColor("#E80F0F")));
            ImageViewCompat.setImageTintList(imageButton5, ColorStateList.valueOf(Color.parseColor("#E80F0F")));
            ImageViewCompat.setImageTintList(imageButton7, ColorStateList.valueOf(Color.parseColor("#E80F0F")));

            addPlayerPoints(winnerRound)
            checkIfWinnerOfGame(winnerRound)

        } else if(checkIfFieldFull()){
            Toast.makeText(this, "No more possibilities - new round", Toast.LENGTH_SHORT).show()
            resetGame()
        }

    }

    private fun checkIfWinnerOfGame(winnerRound: String) {
        if(gamesWon[0] == 2 || gamesWon[1] == 2){
            gamesWon[0] = 0
            gamesWon[1] = 0
            switchPlayer = 1

            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)

            Handler().postDelayed(Runnable {
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)

                val intent = Intent(this,FinishScreenActivity::class.java)
                intent.putExtra("Winner", winnerRound)
                intent.putStringArrayListExtra("Players", players)
                startActivity(intent)
            }, 1500)


        } else {
            Toast.makeText(this, winnerRound + " got a point", Toast.LENGTH_SHORT).show()
            resetGame()

        }
    }

    private fun addPlayerPoints(winnerRound: String) {
        if(winnerRound == players!!.get(0)){
            gamesWon[0]++
        } else {
            gamesWon[1]++
        }
    }


    private fun resetGame() {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)

        Handler().postDelayed(Runnable {

            for (field in fields){
                field.setImageResource(R.drawable.ic_transparent)
                field.setTag(null)
            }

            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)

        }, 3000)


    }



    //                if(field.getTag() == R.drawable.ic_circle){
//                    ImageViewCompat.setImageTintList(field, ColorStateList.valueOf(Color.parseColor("#FF3700B3")));
//                } else if(field.getTag() == R.drawable.ic_close){
//                    ImageViewCompat.setImageTintList(field, ColorStateList.valueOf(Color.parseColor("#FCCA16")));
//                }


    private fun checkIfFieldFull() : Boolean{
        for (field in fields) {
            if (field.getTag() == null) {
                return false
            }
        }

        return true
    }
}