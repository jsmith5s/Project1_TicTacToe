package com.example.demo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //connect the button code to the button layout
        val button : Button = findViewById(R.id.button)
        button.isVisible = false

        val button2 : Button = findViewById(R.id.button2)

        //connect textview to the textview layout
        val textView : TextView = findViewById(R.id.textView)
        textView.text = ""

        var switchPlayer : Boolean = false

        val b: Array<ImageView> = arrayOf(
            findViewById(R.id.imageView1),
            findViewById(R.id.imageView2),
            findViewById(R.id.imageView3),
            findViewById(R.id.imageView4),
            findViewById(R.id.imageView5),
            findViewById(R.id.imageView6),
            findViewById(R.id.imageView7),
            findViewById(R.id.imageView8),
            findViewById(R.id.imageView9))

        val winCombs : Array<Array<Int>> = arrayOf (
            arrayOf(0, 1, 2),
            arrayOf(3, 4, 5),
            arrayOf(6, 7, 8),
            arrayOf(0, 3, 6),
            arrayOf(1, 4, 7),
            arrayOf(2, 5, 8),
            arrayOf(0, 4, 8),
            arrayOf(2, 4, 6),
        )

        fun checkWin() {
            for (num in winCombs.indices) {
                if (b[winCombs[num][0]].tag == b[winCombs[num][1]].tag && b[winCombs[num][1]].tag == b[winCombs[num][2]].tag) {

                    for (image in b) {
                        image.isClickable = false
                    }
                    textView.text = b[winCombs[num][0]].tag.toString() + " won!"
                    button.isVisible = true

                    for (i in 0..2) {
                        b[winCombs[num][i]].setColorFilter(0xFFf6ad09.toInt())
                    }
                    return
                }
            }
            if (!button.isVisible) {
                for (image in b) {
                    if (image.isClickable)
                        return
                }

                textView.text = "tie..."
                button.isVisible = true
            }
        }

        //load image resource

        for (num in 0..8) {
            b[num].setImageResource(R.drawable.blank)
            b[num].setColorFilter(0xFFCCCCCC.toInt())
            b[num].tag = num


            b[num].setOnClickListener {
                if (b[num].isClickable) {
                    if (switchPlayer) {
                        b[num].setImageResource(R.drawable.x)
                        b[num].setColorFilter(0xFFe51a2f.toInt())
                        b[num].tag = "x"
                    }
                    else {
                        b[num].setImageResource(R.drawable.o)
                        b[num].setColorFilter(0xFF1AE5D0.toInt())
                        b[num].tag = "o"
                    }
                    b[num].isClickable = false
                    //b[num].setBackgroundColor(0x00000000.toInt())

                    switchPlayer = !switchPlayer

                    checkWin()
                }
            }
        }



        button.setOnClickListener {
            for (num in 0..8) {
                b[num].setImageResource(R.drawable.blank)
                b[num].setColorFilter(0xFFCCCCCC.toInt())
                b[num].tag = num
                b[num].isClickable = true

                textView.text = ""
                button.isVisible = false
            }
            switchPlayer = false
        }

        button2.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

    }

}