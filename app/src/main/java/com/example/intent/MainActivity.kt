package com.example.intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.buttonDone

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonDone.setOnClickListener{
            sendMessage()
        }
    }
    private fun sendMessage(){
        if(editTextMessage.text.isEmpty()){
            editTextMessage.setError("Value Required")
            return
        }
        //Explicit intent : component name must be provided
        val intent = Intent(this, SecondActivity::class.java)

        //insert extre to the intent
        val message = editTextMessage.text.toString()
        intent.putExtra(EXTRA_MSG, message)



        val lucky = editTextLucky.text.toString()
        intent.putExtra(EXTRA_LUCKY, lucky)

        //no return value from the second activity
        //startActivity(intent)


        //return value from the second activity
        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK) {
                val reply = data?.getStringExtra(EXTRA_REPLY)
                //Display reply here
                editTextReply.text = String.format("%s %s",
                    getString(R.string.reply), reply)

            }
        }
    }

    companion object{
        const val EXTRA_MSG = "com.example.intent.EXTRA_MSG"
        const val EXTRA_LUCKY ="com.example.intent.EXTRA_LUCKY"
        const val EXTRA_REPLY ="com.example.intent.REPLY"
        const val REQUEST_CODE = 1
    }
}
