package dalbers.com.timerpicker

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.timepicker.R
import com.example.timepicker.TimerPickerDialogListener
import com.example.timepicker.TimerTextView
import com.example.timepicker.TimerViewUtils


class TimerPickerDialog(context: Context) : Dialog(context) {
    private var timerTextView: TimerTextView? = null
    private var listener: TimerPickerDialogListener? = null
    private var oneButton: Button? = null
    private var twoButton: Button? = null
    private var threeButton: Button? = null
    private var fourButton: Button? = null
    private var fiveButton: Button? = null
    private var sixButton: Button? = null
    private var sevenButton: Button? = null
    private var eightButton: Button? = null
    private var nineButton: Button? = null
    private var zeroButton: Button? = null
    private var setButton: TextView? = null
    private var cancelButton: TextView? = null
    private var deleteButton: ImageButton? = null
    private var delimiterType = TimerViewUtils.DelimiterType.hms
    private var TIME_SAVED_INSTANCE_TAG = "time_saved_instance_tag"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //get time that was saved in savedInstanceState
        //probably from an orientation change, if any
        var savedTime: Long = 0
        if (savedInstanceState != null) savedTime =
            savedInstanceState.getLong(TIME_SAVED_INSTANCE_TAG)
        // Use the Builder class for convenient dialog construction
        // Use the Builder class for convenient dialog construction
        val view = LayoutInflater.from(context).inflate(R.layout.numerical_dialog_layout, null)
        setContentView(view)

        timerTextView = view.findViewById(R.id.timerTextView) as TimerTextView
        timerTextView!!.setDelimiterType(delimiterType)
        timerTextView!!.time = savedTime
        oneButton = view.findViewById(R.id.one_button) as Button
        oneButton!!.setOnClickListener(numberButtonClickListener)
        twoButton = view.findViewById(R.id.two_button) as Button
        twoButton!!.setOnClickListener(numberButtonClickListener)
        threeButton = view.findViewById(R.id.three_button) as Button
        threeButton!!.setOnClickListener(numberButtonClickListener)
        fourButton = view.findViewById(R.id.four_button) as Button
        fourButton!!.setOnClickListener(numberButtonClickListener)
        fiveButton = view.findViewById(R.id.five_button) as Button
        fiveButton!!.setOnClickListener(numberButtonClickListener)
        sixButton = view.findViewById(R.id.six_button) as Button
        sixButton!!.setOnClickListener(numberButtonClickListener)
        sevenButton = view.findViewById(R.id.seven_button) as Button
        sevenButton!!.setOnClickListener(numberButtonClickListener)
        eightButton = view.findViewById(R.id.eight_button) as Button
        eightButton!!.setOnClickListener(numberButtonClickListener)
        nineButton = view.findViewById(R.id.nine_button) as Button
        nineButton!!.setOnClickListener(numberButtonClickListener)
        zeroButton = view.findViewById(R.id.zero_button) as Button
        zeroButton!!.setOnClickListener(numberButtonClickListener)
        deleteButton = view.findViewById(R.id.delete_button) as ImageButton
        cancelButton = view.findViewById(R.id.btn_cancel) as TextView
        setButton = view.findViewById(R.id.btn_set) as TextView

        if (deleteButton != null) deleteButton!!.setOnClickListener(deleteListener)


//        builder.setView(view)
//        builder.setMessage(R.string.dialog_title)
//            .setPositiveButton(
//                R.string.dialog_set
//            ) { dialog, id -> if (listener != null) listener!!.timeSet(timerTextView!!.time) }
//            .setNegativeButton(
//                R.string.dialog_cancel
//            ) { dialog, id -> if (listener != null) listener!!.dialogCanceled() }
        // Create the AlertDialog object and return it
        // Create the AlertDialog object and return it
        //dialog.getWindow().
        //dialog.getWindow().

        setButton!!.setOnClickListener {
            if (listener != null) listener!!.timeSet(timerTextView!!.time)
        }


        cancelButton!!.setOnClickListener {
            if (listener != null) listener!!.dialogCanceled()
            dismiss()
        }
    }

    fun setDialogListener(listener: TimerPickerDialogListener?) {
        this.listener = listener
    }

    private val numberButtonClickListener = View.OnClickListener { v ->
        when (v.id) {
            R.id.one_button -> timerTextView!!.appendNumber(1)
            R.id.two_button -> timerTextView!!.appendNumber(
                2
            )
            R.id.three_button -> timerTextView!!.appendNumber(3)
            R.id.four_button -> timerTextView!!.appendNumber(
                4
            )
            R.id.five_button -> timerTextView!!.appendNumber(5)
            R.id.six_button -> timerTextView!!.appendNumber(
                6
            )
            R.id.seven_button -> timerTextView!!.appendNumber(7)
            R.id.eight_button -> timerTextView!!.appendNumber(
                8
            )
            R.id.nine_button -> timerTextView!!.appendNumber(9)
            R.id.zero_button -> timerTextView!!.appendNumber(
                0
            )
        }
    }

    var deleteListener = View.OnClickListener { timerTextView!!.removeLastNumber() }

}