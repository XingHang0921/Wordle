package codepath.com.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import codepath.com.wordle.FourLetterWordList.getRandomFourLetterWord

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<TextView>(R.id.editText)
        val answer = findViewById<TextView>(R.id.answer)

        val guess1 = findViewById<TextView>(R.id.guess1)
        val guess1Check = findViewById<TextView>(R.id.guess1Check)
        val guess2 = findViewById<TextView>(R.id.guess2)
        val guess2Check = findViewById<TextView>(R.id.guess2Check)
        val guess3 = findViewById<TextView>(R.id.guess3)
        val guess3Check = findViewById<TextView>(R.id.guess3Check)

        val text1 = findViewById<TextView>(R.id.text1)
        val text2 = findViewById<TextView>(R.id.text2)
        val text3 = findViewById<TextView>(R.id.text3)

        val check1 = findViewById<TextView>(R.id.check1)
        val check2 = findViewById<TextView>(R.id.check2)
        val check3 = findViewById<TextView>(R.id.check3)

        wordToGuess = getRandomFourLetterWord()
        answer.text = wordToGuess
        button.setOnClickListener{
            guess = editText.text.toString()
            numOfGuess++
            if(numOfGuess == 1)
            {
                text1.text = editText.text.toString()
                guess1.visibility = View.VISIBLE
                text1.visibility = View.VISIBLE

                check1.text = checkGuess(guess)
                guess1Check.visibility = View.VISIBLE
                check1.visibility = View.VISIBLE

            }
            else if (numOfGuess == 2 )
            {
                    text2.text = editText.text.toString()
                    guess2.visibility = View.VISIBLE
                    text2.visibility = View.VISIBLE

                    check2.text = checkGuess(guess)
                    guess2Check.visibility = View.VISIBLE
                    check2.visibility = View.VISIBLE

            }
            else if( numOfGuess == 3)
            {
                    text3.text = editText.text.toString()
                    guess3.visibility = View.VISIBLE
                    text3.visibility = View.VISIBLE

                    check3.text = checkGuess(guess)
                    guess3Check.visibility = View.VISIBLE
                    check3.visibility = View.VISIBLE

            }
            else {
                Toast.makeText(it.context, "You Used All Three Guess Chances!", Toast.LENGTH_SHORT)
                    .show()
                Toast.makeText(it.context, "Game Over!", Toast.LENGTH_SHORT).show()
                button.visibility = View.INVISIBLE
                answer.visibility = View.VISIBLE
            }
        }
    }
    var guess = ""
    var wordToGuess = ""
    var numOfGuess = 0

    private fun checkGuess(guess: String) : String
    {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
}
