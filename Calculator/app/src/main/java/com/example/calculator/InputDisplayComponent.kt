package com.example.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.example.calculator.ui.theme.CalculatorTheme
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
internal fun InputDisplayComponent(state: CalcViewModel.ViewState) {
    Box(
        modifier = Modifier
            .padding(vertical = 5.dp,horizontal = 5.dp)
            .fillMaxWidth()
            .height(150.dp)
            .clip(MaterialTheme.shapes.large)
            .background(MaterialTheme.colorScheme.onBackground),
        contentAlignment = Alignment.BottomEnd
    ){
        Text(
            text = state.result,
            color = Color.White,
            overflow = TextOverflow.Visible,
            maxLines = 1,
            style = MaterialTheme.typography.headlineMedium.merge(TextStyle(textAlign = TextAlign.End)),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InputDisplayComponentPreview(){
    CalculatorTheme{
        Box(modifier = Modifier.padding(10.dp)){
            InputDisplayComponent(CalcViewModel.ViewState("1 + 2 = 3"))
        }
    }
}