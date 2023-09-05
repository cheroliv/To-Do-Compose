package com.example.to_docompose

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ToDoApplication : Application()

//@Database(
//    entities = [ToDoTask::class],
//    version = 1,
//    exportSchema = false
//)
//abstract class ToDoDatabase : RoomDatabase() {
//
//    abstract fun toDoDao(): ToDoTask.ToDoDao
//
//}