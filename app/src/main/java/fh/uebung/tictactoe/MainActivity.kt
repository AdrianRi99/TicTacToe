package fh.uebung.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


lateinit var players : ArrayList<String>

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        players = ArrayList()

        btn_play.setOnClickListener {

            if(tv_player1.text.toString() != "" && tv_player2.text.toString() != ""){
                players.add(tv_player1.text.toString().trim())
                players.add(tv_player2.text.toString().trim())


                val intent = Intent(this,GameActivity::class.java)
                intent.putStringArrayListExtra("Players", players)
                startActivity(intent)


            } else {
                Toast.makeText(this, "Select players first", Toast.LENGTH_SHORT).show()
            }

        }



    }


}