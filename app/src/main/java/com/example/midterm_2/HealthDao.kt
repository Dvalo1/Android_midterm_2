package com.example.midterm_2

import androidx.room.*

@Dao
interface HealthDao {

    @Query("SELECT COUNT(stepsAmount) FROM HEALTH")
    fun getCount(): Int

    @Query("SELECT * FROM HEALTH")
    fun getAllEntries(): List<Health>

    @Query("SELECT AVG(stepsAmount) FROM HEALTH")
    fun getAvgSteps(): Int

    @Query("SELECT AVG(caloriesBurnt) FROM HEALTH")
    fun getAvgCalories(): Int

    @Query("SELECT AVG(averageBpm) FROM HEALTH")
    fun getAvgBpm(): Int

    @Query("SELECT AVG(waterDrank) FROM HEALTH")
    fun getAvgWotah(): Int

    @Query("SELECT AVG(hoursSlept) FROM HEALTH")
    fun getAvgHours(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg entry: Health)

    @Delete
    fun deleteEntry(entry: Health)

    @Query("DELETE FROM health")
    fun deleteAll()

}