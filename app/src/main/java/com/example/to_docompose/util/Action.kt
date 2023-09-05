package com.example.to_docompose.util

import com.example.to_docompose.util.Action.NO_ACTION
import com.example.to_docompose.util.Action.valueOf

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