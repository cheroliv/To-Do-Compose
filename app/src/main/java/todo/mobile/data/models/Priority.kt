package todo.mobile.data.models

import androidx.compose.ui.graphics.Color
import todo.mobile.ui.theme.HighPriorityColor
import todo.mobile.ui.theme.LowPriorityColor
import todo.mobile.ui.theme.MediumPriorityColor
import todo.mobile.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}