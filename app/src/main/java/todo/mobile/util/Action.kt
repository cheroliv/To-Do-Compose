package todo.mobile.util

import todo.mobile.util.Action.NO_ACTION
import todo.mobile.util.Action.valueOf

enum class Action {
    ADD,
    UPDATE,
    DELETE,
    DELETE_ALL,
    UNDO,
    NO_ACTION
}

fun String?.toAction(): Action = when {
    isNullOrEmpty() -> NO_ACTION
    else -> valueOf(this)
}