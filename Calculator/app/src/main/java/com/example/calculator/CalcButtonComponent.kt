package com.example.calculator
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
internal fun CalcButtonComponent(
    symbol: String,
    color: Color,
    modifier:  Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        Modifier
            .fillMaxSize(fraction = 0.8f)
            .background(Color.LightGray)
            .clickable{ onClick() }
            .then(modifier),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = symbol,
            fontSize = 40.sp,
            color = color
        )
    }
}
@Preview(showBackground = true)
@Composable
fun CalcButtonComponentPreview(){
    CalculatorTheme{
        CalcButtonComponent(
            symbol = "1",
            color = Color.Red,
            modifier = Modifier.size(100.dp),
            onClick = {},
        )
    }
}