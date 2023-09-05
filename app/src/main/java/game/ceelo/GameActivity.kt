package game.ceelo

//import game.ceelo.databinding.ActivityGameBinding
//import game.ceelo.databinding.ActivityGameBinding.inflate
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import game.ceelo.Hand.getDiceImageFromDiceValue
import org.koin.androidx.viewmodel.ext.android.getViewModel

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getViewModel<GameViewModel>()//.loadLocalGame(this)
    }
}
fun runDiceAnimation(
    diceImage: ImageView,
    diceValue: Int,
    diceImages: List<Int>
) = diceImage.apply {
    setImageResource(diceImages.getDiceImageFromDiceValue(diceValue))
}.run {
    startAnimation(
        RotateAnimation(
            0f,
            360f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        ).apply { duration = 500 })
}

fun setTextViewResult(
    textViewResult: TextView,
    diceResult: GameResult,
    textViewVisibility: Int
): TextView = textViewResult.apply {
    visibility = textViewVisibility
    text = when (diceResult) {
        GameResult.WIN -> GameResult.WIN.toString()
        GameResult.LOOSE -> GameResult.LOOSE.toString()
        else -> GameResult.RERUN.toString()
    }
}

//val GameActivity.binding: ActivityGameBinding
//    get() = inflate(layoutInflater)
//        .apply { setContentView(root) }
//
//val ActivityGameBinding.playerOneUI: List<ImageView>
//    get() = listOf(
//        playerOneFirstDice,
//        playerOneMiddleDice,
//        playerOneLastDice
//    )
//
//val ActivityGameBinding.playerTwoUI: List<ImageView>
//    get() = listOf(
//        playerTwoFirstDice,
//        playerTwoMiddleDice,
//        playerTwoLastDice
//    )
//
//val ActivityGameBinding.playersUI: List<List<ImageView>>
//    get() = listOf(playerOneUI, playerTwoUI)
//
//
//val ActivityGameBinding.resultUI: List<TextView>
//    get() = listOf(localPlayerResult, computerResult)

