package com.anthony.pocket.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "report_table")
class Report(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name ="id")
    val id:Int,
    @ColumnInfo(name = "date")
    val date:String,
    @ColumnInfo(name = "description")
    val description:String,
    @ColumnInfo(name = "nominal")
    val nominal:Int

)




