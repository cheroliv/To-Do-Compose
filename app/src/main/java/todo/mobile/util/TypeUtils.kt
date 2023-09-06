package todo.mobile.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

object TypeUtils {

    val ZonedDateTime.fromDateTime: Long?
        @RequiresApi(Build.VERSION_CODES.O)
        get() = toInstant()?.toEpochMilli()

    val Long.toDateTime: ZonedDateTime?
        @RequiresApi(Build.VERSION_CODES.O)
        get() = Instant.ofEpochMilli(this)
            .atZone(ZoneId.systemDefault())
}