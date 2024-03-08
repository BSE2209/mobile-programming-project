package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {

                    val viewModel = viewModel<CalcViewModel>()
                    val state = viewModel.viewState.collectAsState(initial = CalcViewModel.ViewState("0")).value
                    CalcScreen(state){
                        viewModel.dispatch(it)

                    }
            }
        }
    }
}

@Composable
private fun CalcScreen(state: CalcViewModel.ViewState, dispatcher: (ActionType) -> Unit){
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 10.dp)
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            ){
                InputDisplayComponent(state)
                Spacer(modifier = Modifier.height(5.dp))
                CalcButtonsGridDisplay(dispatcher)
            }
        }

    }
}

@Composable
fun CalcButtonsGridDisplay(dispatcher: (ActionType) -> Unit){
    val buttons = listOf(
        ActionType.Clear,
        ActionType.Delete,
        ActionType.Percentage,
        ActionType.Operator(Operators.Divide),
        ActionType.Number(7),
        ActionType.Number(8),
        ActionType.Number(9),
        ActionType.Operator(Operators.Multiply),
        ActionType.Number(4),
        ActionType.Number(5),
        ActionType.Number(6),
        ActionType.Operator(Operators.Subtract),
        ActionType.Number(1),
        ActionType.Number(2),
        ActionType.Number(3),
        ActionType.Operator(Operators.Add),
        ActionType.Number(0),
        ActionType.Decimal,
        ActionType.Operator(Operators.Power),
        ActionType.Calculate,
    )
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        verticalArrangement = Arrangement.spacedBy(1.dp),
        horizontalArrangement = Arrangement.spacedBy(1.dp),
        content = {
         items(buttons){
             CalcButtonComponent(
                 modifier = Modifier.aspectRatio(1f),
                 symbol = it.symbol,
                 color = it.color,
             ){
                 dispatcher(it)
             }
         }
    })
}

@Preview(showBackground = true)
@Composable
fun CalcScreenPreview(){
    CalculatorTheme{
        CalcScreen(CalcViewModel.ViewState("0")){
        }
    }
}