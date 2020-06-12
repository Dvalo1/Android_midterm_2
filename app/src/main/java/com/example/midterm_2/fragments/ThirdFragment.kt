package com.example.midterm_2.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.midterm_2.App
import com.example.midterm_2.R
import com.example.midterm_2.adapter.MainAdapter
import kotlinx.android.synthetic.main.third_fragment.*


class ThirdFragment : Fragment(R.layout.third_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var healthInfoEntries = App.instance.db.getHealthDao().getAllEntries()

        val adapter = MainAdapter(healthInfoEntries)

        recyclerView.layoutManager = LinearLayoutManager(this.context)

        recyclerView.adapter = adapter

    }


}