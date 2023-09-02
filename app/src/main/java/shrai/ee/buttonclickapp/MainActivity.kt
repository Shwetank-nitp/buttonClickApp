package shrai.ee.buttonclickapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private var STORE_TEXT = ""
    private var textView:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: called")
        val userInput:EditText? = findViewById(R.id.editTextTextPersonName)
        val button:Button? = findViewById(R.id.button)
        textView = findViewById(R.id.textView)
        textView?.text=""
        textView?.movementMethod = ScrollingMovementMethod()
        button?.setOnClickListener {
            Log.d(TAG, "onClick: called")
            if (!userInput?.text.isNullOrBlank()){
                textView?.append("${userInput?.text}\n")
                userInput?.text?.clear()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG,"OnSaveInstanceState: called")
        super.onSaveInstanceState(outState)
        outState.putString(STORE_TEXT, textView?.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG, "onRestoreInstanceState: called")
        super.onRestoreInstanceState(savedInstanceState)
        textView?.text = savedInstanceState.getString(STORE_TEXT,"")
    }
}