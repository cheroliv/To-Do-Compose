package todo.mobile

import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase.Callback
import androidx.sqlite.db.SupportSQLiteDatabase
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import todo.mobile.data.repositories.DataStoreRepository
import todo.mobile.data.repositories.ToDoRepository
import todo.mobile.ui.viewmodels.SharedViewModel
import todo.mobile.util.Constants.DATABASE_NAME

object Modules {
    val appModule = module {
        singleOf(::DataStoreRepository)
        singleOf(::ToDoRepository)
        viewModelOf(::SharedViewModel)
        single {
            databaseBuilder(
                get(),
                ToDoApplication.ToDoDatabase::class.java,
                DATABASE_NAME
            ).addCallback(object : Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    db.run {
                        super.onCreate(this)
                        //Initialiser la base de données ici.
                    }
                }
            }).build()
        }
    }
}