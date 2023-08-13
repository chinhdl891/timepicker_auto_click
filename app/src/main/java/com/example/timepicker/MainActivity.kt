package com.example.timepicker

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dalbers.com.timerpicker.TimerPickerDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showPickerDialog()
    }

    private fun showPickerDialog() {
        val timerDialog = TimerPickerDialog(this)
        //        timerDialog.setDelimiter(delimiterType);
        timerDialog.show()
        timerDialog.setDialogListener(dialogListener)
    }

    private val dialogListener: TimerPickerDialogListener = object : TimerPickerDialogListener {
        override fun timeSet(timeInMillis: Long) {


            Toast.makeText(this@MainActivity, "" + timeInMillis, Toast.LENGTH_SHORT).show()
        }

        override fun dialogCanceled() {

        }
    }
}