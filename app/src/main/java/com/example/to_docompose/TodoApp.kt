package com.example.to_docompose

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.*
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase.Callback
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.to_docompose.data.models.ToDoTask
import com.example.to_docompose.data.models.ToDoTask.ToDoDao
import game.ceelo.CeeLoApp.Database.Companion.DB_NAME
import game.ceelo.CeeLoApp.Database.TypeUtils.fromDateTime
import game.ceelo.CeeLoApp.Database.TypeUtils.toDateTime
import game.ceelo.CeeLoApp.Database.TypesConverter
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module
import java.time.Instant.ofEpochMilli
import java.time.ZoneId.systemDefault
import java.time.ZonedDateTime
import java.util.*


class TodoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@TodoApp)
            modules(module {
                @Suppress("RemoveExplicitTypeArguments")
                single<ToDoDatabase>() {
                    databaseBuilder(
                        get(),
                        ToDoDatabase::class.java,
                        DB_NAME
                    ).addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            db.run {
                                super.onCreate(this)
                                //Initialiser la base de données ici.
                            }
                        }
                    }).build()
                }
            })
        }
    }

    @Database(
        entities = [ToDoTask::class],
        version = 1
    )
    @TypeConverters(TypesConverter::class)
    abstract class ToDoDatabase : RoomDatabase() {
        abstract fun toDoDao(): ToDoDao

        object TypesConverter {

            @RequiresApi(Build.VERSION_CODES.O)
            @JvmStatic
            @TypeConverter
            fun fromZonedDateTime(value: ZonedDateTime?)
                : Long? = value?.fromDateTime

            @RequiresApi(Build.VERSION_CODES.O)
            @JvmStatic
            @TypeConverter
            fun toZonedDateTime(value: Long?)
                : ZonedDateTime? = value?.toDateTime
        }

        object TypeUtils {

            val ZonedDateTime.fromDateTime: Long?
                @RequiresApi(Build.VERSION_CODES.O)
                get() = toInstant()?.toEpochMilli()

            val Long.toDateTime: ZonedDateTime?
                @RequiresApi(Build.VERSION_CODES.O)
                get() = ofEpochMilli(this)
                    .atZone(systemDefault())
        }

        companion object {
            const val DB_NAME = "todo.db"
        }
    }
}