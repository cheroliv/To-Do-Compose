package todo.mobile

import android.app.Application
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import todo.mobile.Modules.appModule
import todo.mobile.data.models.ToDoTask
import todo.mobile.data.models.ToDoTask.ToDoDao
import todo.mobile.util.TypesConverter


class ToDoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ToDoApplication)
            modules(appModule)
        }
    }

    @Database(
        entities = [ToDoTask::class],
        version = 1
    )
    @TypeConverters(TypesConverter::class)
    abstract class ToDoDatabase : RoomDatabase() {
        abstract fun toDoDao(): ToDoDao
    }
}

