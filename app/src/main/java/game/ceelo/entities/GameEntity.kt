package game.ceelo.entities

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.*
import java.time.ZonedDateTime
import java.time.ZonedDateTime.now
import java.util.*

@Entity(
    tableName = "Game", indices = [
        Index("isDraw"),
        Index("isOffLineGame"),
    ]
)
data class GameEntity @RequiresApi(Build.VERSION_CODES.O) constructor(
    @PrimaryKey
    val id: Int,
    val winnerPlayerId: Int,
    val isDraw: Boolean,
    val isOffLineGame: Boolean,
    val date: ZonedDateTime = now(),
) {
    @Dao
    interface GameDao {
        // List<List<List<Int>>>
        @Query("SELECT * FROM Game")
        fun allGames(): List<GameEntity>

        //List<List<Int>>
        @Insert
        fun saveGame(newGame: GameEntity)
    }
}
