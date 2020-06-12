package com.example.midterm_2.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.midterm_2.Health
import com.example.midterm_2.R
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class MainAdapter(private val healthInfo: List<Health>) :
    RecyclerView.Adapter<MainAdapter.HealthViewHolder>() {

    class HealthViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealthViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)

        return HealthViewHolder(view)

    }

    override fun getItemCount(): Int = healthInfo.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: HealthViewHolder, position: Int) {

        val pos = healthInfo[position]

        holder.itemView.title_display.text = "Record date - ${pos.timeNow}"

        holder.itemView.step_display.text = "Steps - ${pos.stepsAmount}"

        holder.itemView.cal_display.text = "Calories Burnt - ${pos.caloriesBurnt.toString()}"

        holder.itemView.bpm_display.text = "Heart Beat - ${pos.averageBpm.toString()}"

        holder.itemView.water_display.text = "Water Consumed - ${pos.waterDrank.toString()}"

        holder.itemView.hours_display.text = "Hours Slept - ${pos.hoursSlept.toString()}"

    }
}

