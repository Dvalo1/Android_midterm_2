package com.example.midterm_2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "HEALTH")
data class Health(

    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "stepsAmount")
    val stepsAmount: Int,

    @ColumnInfo(name = "caloriesBurnt")
    val caloriesBurnt: Int?,

    @ColumnInfo(name = "averageBpm")
    val averageBpm: Int?,

    @ColumnInfo(name = "waterDrank")
    val waterDrank: Int?,

    @ColumnInfo(name = "hoursSlept")
    val hoursSlept: Int?,

    @ColumnInfo(name = "timeNow")
    val timeNow: String

)