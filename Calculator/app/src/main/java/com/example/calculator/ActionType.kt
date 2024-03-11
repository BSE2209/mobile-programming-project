package com.example.calculator

import androidx.compose.ui.graphics.Color

sealed class ActionType(val symbol: String, val color: Color) {
    data class Number(val number: Int) : ActionType(number.toString(), Color.Black)
    data class Operator(val operation: Operators): ActionType(operation.symbol, Color.Blue)

    data object Calculate : ActionType("=", Color.Blue)
    data object Delete : ActionType("<-", Color.Blue)
    data object Clear : ActionType("C", Color.Blue)
    data object Decimal : ActionType(".", Color.Blue)
    data object Percentage : ActionType("%", Color.Blue)

}

sealed class Operators(val symbol: String) {
    data object Add: Operators("+")
    data object Subtract: Operators("-")
    data object Multiply: Operators("*")
    data object Divide: Operators("/")
    data object Power: Operators("^")

}