package com.example.belajarui

import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DataDiriFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DataDiriFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var picker: TimePickerDialog? = null
    var eText: EditText? = null
    var btnGet: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val t=  inflater.inflate(R.layout.fragment_data_diri, container, false)
        eText= t.findViewById(R.id.editText1)
        btnGet = t.findViewById(R.id.button1)

        eText!!.setOnClickListener {
                var calendar = Calendar.getInstance()
                val hour: Int = calendar.get(Calendar.HOUR_OF_DAY)
                val minutes: Int = calendar.get(Calendar.MINUTE)

            picker = TimePickerDialog(context,
                { tp, sHour, sMinute -> eText!!.setText("$sHour:$sMinute") }, hour, minutes, true
            )
                picker!!.show()
        }

        btnGet!!.setOnClickListener {
            Toast.makeText(activity, eText!!.text.toString(), Toast.LENGTH_LONG).show()
            }
        return t
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DataDiriFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DataDiriFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}