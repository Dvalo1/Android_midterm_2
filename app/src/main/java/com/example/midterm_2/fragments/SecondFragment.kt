package com.example.midterm_2.fragments

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.midterm_2.App
import com.example.midterm_2.R
import kotlinx.android.synthetic.main.second_fragment.*


class SecondFragment : Fragment(R.layout.second_fragment) {

    private lateinit var navController: NavController

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        var dayCount = App.instance.db.getHealthDao().getCount()
        var avgSteps = App.instance.db.getHealthDao().getAvgSteps()
        var avgCal = App.instance.db.getHealthDao().getAvgCalories()
        var avgBpm = App.instance.db.getHealthDao().getAvgBpm()
        var avgWater = App.instance.db.getHealthDao().getAvgWotah()
        var avgSleep = App.instance.db.getHealthDao().getAvgHours()

        day_count.text = "From total of $dayCount entries / days"

        // A lot of conditionals incoming
        // Steps
        if (avgSteps == 0) {
            first_imgview.setImageDrawable(resources.getDrawable(R.drawable.ic_error_outline_black_24dp))
            first_imgview.setColorFilter(Color.argb(255, 230, 57, 70))
            first_numb_evaluation.text = "Not found"
        } else if (avgSteps in 1..500) {
            first_imgview.setImageDrawable(resources.getDrawable(R.drawable.ic_info_outline_black_24dp))
            first_imgview.setColorFilter(Color.argb(255, 249, 210, 50))
            first_numb_evaluation.text = "Try harder"
        } else if (avgSteps in 501..1999) {
            first_imgview.setImageDrawable(resources.getDrawable(R.drawable.ic_check_black_24dp))
            first_imgview.setColorFilter(Color.argb(255, 63, 199, 42))
            first_numb_evaluation.text = "Good work"
        } else {
            first_imgview.setImageDrawable(resources.getDrawable(R.drawable.ic_sentiment_very_satisfied_black_24dp))
            first_imgview.setColorFilter(Color.argb(255, 119, 236, 100))
            first_numb_evaluation.text = "Keep it up!"
        }
        // Calories
        if (avgCal == 0) {
            second_imgview.setImageDrawable(resources.getDrawable(R.drawable.ic_error_outline_black_24dp))
            second_imgview.setColorFilter(Color.argb(255, 230, 57, 70))
            second_numb_evaluation.text = "Not found"
        } else if (avgCal in 1..1600) {
            second_imgview.setImageDrawable(resources.getDrawable(R.drawable.ic_info_outline_black_24dp))
            second_imgview.setColorFilter(Color.argb(255, 249, 210, 50))
            second_numb_evaluation.text = "Try harder"
        } else if (avgCal in 1601..3000) {
            second_imgview.setImageDrawable(resources.getDrawable(R.drawable.ic_check_black_24dp))
            second_imgview.setColorFilter(Color.argb(255, 63, 199, 42))
            second_numb_evaluation.text = "Good work"
        } else if (avgCal in 3001..4001) {
            second_imgview.setImageDrawable(resources.getDrawable(R.drawable.ic_info_outline_black_24dp))
            second_imgview.setColorFilter(Color.argb(255, 242, 116, 126))
            second_numb_evaluation.text = "Slow down there bud!"
        } else {
            second_imgview.setImageDrawable(resources.getDrawable(R.drawable.ic_error_outline_black_24dp))
            second_imgview.setColorFilter(Color.argb(255, 251, 27, 45))
            second_numb_evaluation.text = "This is definitely not healthy"
        }
        // Bpm
        if (avgBpm == 0) {
            third_imgview.setImageDrawable(resources.getDrawable(R.drawable.ic_error_outline_black_24dp))
            third_imgview.setColorFilter(Color.argb(255, 230, 57, 70))
            third_numb_evaluation.text = "Not found"
        } else if (avgBpm in 1..60) {
            third_imgview.setImageDrawable(resources.getDrawable(R.drawable.ic_error_outline_black_24dp))
            third_imgview.setColorFilter(Color.argb(255, 251, 27, 45))
            third_numb_evaluation.text = "Visit your doctor!"
        } else if (avgBpm in 60..200) {
            third_imgview.setImageDrawable(resources.getDrawable(R.drawable.ic_sentiment_very_satisfied_black_24dp))
            third_imgview.setColorFilter(Color.argb(255, 63, 199, 42))
            third_numb_evaluation.text = "Healthy!"
        } else {
            third_imgview.setImageDrawable(resources.getDrawable(R.drawable.ic_error_outline_black_24dp))
            third_imgview.setColorFilter(Color.argb(255, 251, 27, 45))
            third_numb_evaluation.text = "This is definitely not healthy"
        }
        // Water
        if (avgWater == 0) {
            fourth_imgview.setImageDrawable(resources.getDrawable(R.drawable.ic_error_outline_black_24dp))
            fourth_imgview.setColorFilter(Color.argb(255, 230, 57, 70))
            fourth_numb_evaluation.text = "Not found"
        } else if (avgWater in 1..5) {
            fourth_imgview.setImageDrawable(resources.getDrawable(R.drawable.ic_check_black_24dp))
            fourth_imgview.setColorFilter(Color.argb(255, 63, 199, 42))
            fourth_numb_evaluation.text = "Normal"
        } else if (avgWater in 6..10) {
            fourth_imgview.setImageDrawable(resources.getDrawable(R.drawable.ic_info_outline_black_24dp))
            fourth_imgview.setColorFilter(Color.argb(255, 249, 210, 50))
            fourth_numb_evaluation.text = "Slow down there bud!"
        } else {
            fourth_imgview.setImageDrawable(resources.getDrawable(R.drawable.ic_error_outline_black_24dp))
            fourth_imgview.setColorFilter(Color.argb(255, 251, 27, 45))
            fourth_numb_evaluation.text = "This is definitely not healthy"
        }
        // Sleep
        if (avgSleep == 0) {
            fifth_imgview.setImageDrawable(resources.getDrawable(R.drawable.ic_error_outline_black_24dp))
            fifth_imgview.setColorFilter(Color.argb(255, 230, 57, 70))
            fifth_numb_evaluation.text = "Not found"
        } else if (avgSleep in 1..6) {
            fifth_imgview.setImageDrawable(resources.getDrawable(R.drawable.ic_info_outline_black_24dp))
            fifth_imgview.setColorFilter(Color.argb(255, 249, 210, 50))
            fifth_numb_evaluation.text = "Get more sleep"
        } else if (avgSleep in 6..10) {
            fifth_imgview.setImageDrawable(resources.getDrawable(R.drawable.ic_sentiment_very_satisfied_black_24dp))
            fifth_imgview.setColorFilter(Color.argb(255, 63, 199, 42))
            fifth_numb_evaluation.text = "Healthy!"
        } else {
            fifth_imgview.setImageDrawable(resources.getDrawable(R.drawable.ic_error_outline_black_24dp))
            fifth_imgview.setColorFilter(Color.argb(255, 251, 27, 45))
            fifth_numb_evaluation.text = "Way too sleepy"
        }
        first_numb_display.text = avgSteps.toString()
        second_numb_display.text = avgCal.toString()
        third_numb_display.text = avgBpm.toString()
        fourth_numb_display.text = avgWater.toString()
        fifth_numb_display.text = avgSleep.toString()


    }

}