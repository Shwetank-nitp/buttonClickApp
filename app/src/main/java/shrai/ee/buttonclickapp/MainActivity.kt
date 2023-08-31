package shrai.ee.buttonclickapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var button:Button? = null
    private var userInput:EditText? = null
    private var textView:TextView? = null
    private var numTimesClicked:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userInput = findViewById(R.id.editTextTextPersonName)
        button = findViewById(R.id.button)
        textView = findViewById(R.id.textView)
        textView?.text=""
        textView?.movementMethod = ScrollingMovementMethod()
        button?.setOnClickListener {
            numTimesClicked++
            textView?.append("Hi ${userInput?.text} clicked button $numTimesClicked time")
            if (numTimesClicked!=1)
                textView?.append("s\n")
            else textView?.append("\n")
        }

    }
}