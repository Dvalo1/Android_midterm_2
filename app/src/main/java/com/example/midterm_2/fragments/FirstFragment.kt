package com.example.midterm_2.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.midterm_2.App
import com.example.midterm_2.Health
import com.example.midterm_2.R
import kotlinx.android.synthetic.main.first_fragment.*
import kotlinx.android.synthetic.main.first_fragment.view.*
import java.text.SimpleDateFormat
import java.util.*


class FirstFragment : Fragment(R.layout.first_fragment) {

    private lateinit var navController: NavController

    @SuppressLint("SimpleDateFormat")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        notification.text = "" // Reset notification text per view

        view.submit_btn.setOnClickListener {

            val formattedDate = SimpleDateFormat("yyyy-MM-dd").format(Date())
            val formattedTime = SimpleDateFormat("HH:mm").format(Date())
            val dateTime = "$formattedDate - $formattedTime" // Date now for records page

            // Check if any input is empty (Probably could have been done better)
            if(steps_amt.text.isNotEmpty()) {
                if(calories_amt.text.isNotEmpty()) {
                    if(bpm_amt.text.isNotEmpty()) {
                        if(water_amt.text.isNotEmpty()) {
                            if(hours_amt.text.isNotEmpty()) {
                                var stepsAmt = steps_amt.text.toString().toInt()
                                var calBurnt = calories_amt.text.toString().toInt()
                                var avgBpm = bpm_amt.text.toString().toInt()
                                var wotahDrank = water_amt.text.toString().toInt()
                                var hoursSlept = hours_amt.text.toString().toInt()

                                var healthInfo = Health(stepsAmt, calBurnt, avgBpm, wotahDrank, hoursSlept, dateTime)

                                App.instance.db.getHealthDao().insert(healthInfo)

                                notification.text = "Information has been submitted!"
                            } else {
                                hours_amt.hint = "Input can't be empty!"
                            }
                        } else {
                            water_amt.hint = "Input can't be empty!"
                        }
                    } else {
                        bpm_amt.hint = "Input can't be empty!"
                    }
                } else {
                    calories_amt.hint = "Input can't be empty!"
                }
            } else {
                steps_amt.hint = "Input can't be empty!"
            }
        }

        view.reset_btn.setOnClickListener {
            steps_amt.setText("")
            calories_amt.setText("")
            bpm_amt.setText("")
            water_amt.setText("")
            hours_amt.setText("")

            notification.text = "Input fields have been wiped!"
        }
    }

}