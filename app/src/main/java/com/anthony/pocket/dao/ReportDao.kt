package com.anthony.pocket.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.anthony.pocket.entity.Report
import kotlinx.coroutines.flow.Flow


@Dao
interface ReportDao {

    @Query("SELECT * FROM report_table")
    fun findAll(): LiveData<List<Report>>

//    @Query("SELECT * FROM report_table WHERE id=:id")
//    fun findById(id:Int): LiveData<String>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(report:Report)

    @Query("Delete from report_table where id =:id")
    fun delete(id: Int)

    @Query("SELECT SUM(nominal) FROM report_table")
    fun getSum():LiveData<Int>
}