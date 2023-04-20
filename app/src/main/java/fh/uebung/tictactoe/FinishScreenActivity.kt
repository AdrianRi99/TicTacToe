package fh.uebung.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_finish_screen.*

class FinishScreenActivity : AppCompatActivity() {

    val test = 3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish_screen)


        val winner = intent.getStringExtra("Winner")
        val players =intent.getStringArrayListExtra("Players")


        tv_show_winner.setText(winner!!.uppercase() + " WON THE GAME")


        btn_new_round.setOnClickListener {
            val intent = Intent(this,GameActivity::class.java)
            intent.putStringArrayListExtra("Players", players)
            startActivity(intent)
        }

        btn_new_players.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}