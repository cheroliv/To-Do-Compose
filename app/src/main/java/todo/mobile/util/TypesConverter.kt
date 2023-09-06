package todo.mobile.util

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import todo.mobile.util.TypeUtils.fromDateTime
import todo.mobile.util.TypeUtils.toDateTime
import java.time.ZonedDateTime

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