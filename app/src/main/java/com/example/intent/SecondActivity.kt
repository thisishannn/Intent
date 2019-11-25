package com.example.intent

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.buttonDone
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //Get the Extra Value(s)
        val message = intent.getStringExtra(MainActivity.EXTRA_MSG)
        val lucky = intent.getStringExtra(MainActivity.EXTRA_LUCKY)
        textViewMessage.text = String.format("%s %s",
            "Message : ", message + lucky)



        buttonDone.setOnClickListener{
            intent = getIntent()
            if(!editTextReply.text.isEmpty()){
                val reply = editTextReply.text.toString()
                intent.putExtra(MainActivity.EXTRA_REPLY, reply)
                setResult(Activity.RESULT_OK, intent)
            }else
                setResult(Activity.RESULT_CANCELED)


            //terminate the Second Activity
            finish()
        }
    }
}
