package com.example.lab5

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab5.compareReliability.models.ReliabilityInputModel
import com.example.lab5.compareReliability.models.ReliabilityResultModel
import com.example.lab5.ui.theme.Lab5Theme
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import com.example.lab5.compareReliability.ReliabilityViewModel

@Composable
fun ReliabilityView(viewModel: ReliabilityViewModel = viewModel()) {
    val inputData by viewModel.inputData.observeAsState(ReliabilityInputModel())
    val resultData by viewModel.resultData.observeAsState(ReliabilityResultModel())

    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                OutlinedTextField(
                    value = inputData.electricGasSwitch.toString(),
                    onValueChange = {
                        viewModel.inputData.value =
                            inputData.copy(electricGasSwitch = it.toDoubleOrNull() ?: 0.0)
                    },
                    label = { Text("Електричний газовий вимикач") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = inputData.pl110.toString(),
                    onValueChange = {
                        viewModel.inputData.value =
                            inputData.copy(pl110 = it.toDoubleOrNull() ?: 0.0)
                    },
                    label = { Text("ПЛ110") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = inputData.transformer.toString(),
                    onValueChange = {
                        viewModel.inputData.value =
                            inputData.copy(transformer = it.toDoubleOrNull() ?: 0.0)
                    },
                    label = { Text("Трансформатор") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = inputData.inputSwitch.toString(),
                    onValueChange = {
                        viewModel.inputData.value =
                            inputData.copy(inputSwitch = it.toDoubleOrNull() ?: 0.0)
                    },
                    label = { Text("Ввідний вимикач") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = inputData.connections.toString(),
                    onValueChange = {
                        viewModel.inputData.value =
                            inputData.copy(connections = it.toDoubleOrNull() ?: 0.0)
                    },
                    label = { Text("З'єднання") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = inputData.electricGasSwitchT.toString(),
                    onValueChange = {
                        viewModel.inputData.value =
                            inputData.copy(electricGasSwitchT = it.toDoubleOrNull() ?: 0.0)
                    },
                    label = { Text("Час відновлення електричного газового вимикача (T)") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = inputData.pl110T.toString(),
                    onValueChange = {
                        viewModel.inputData.value =
                            inputData.copy(pl110T = it.toDoubleOrNull() ?: 0.0)
                    },
                    label = { Text("Час відновлення ПЛ110 (T)") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = inputData.transformerT.toString(),
                    onValueChange = {
                        viewModel.inputData.value =
                            inputData.copy(transformerT = it.toDoubleOrNull() ?: 0.0)
                    },
                    label = { Text("Час відновлення трансформатора (T)") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = inputData.inputSwitchT.toString(),
                    onValueChange = {
                        viewModel.inputData.value =
                            inputData.copy(inputSwitchT = it.toDoubleOrNull() ?: 0.0)
                    },
                    label = { Text("Час відновлення ввідного вимикача (T)") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = inputData.connectionsT.toString(),
                    onValueChange = {
                        viewModel.inputData.value =
                            inputData.copy(connectionsT = it.toDoubleOrNull() ?: 0.0)
                    },
                    label = { Text("Час відновлення з'єднань (T)") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = inputData.kppmax.toString(),
                    onValueChange = {
                        viewModel.inputData.value =
                            inputData.copy(kppmax = it.toDoubleOrNull() ?: 0.0)
                    },
                    label = { Text("Максимальний КПП") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = inputData.failureFreqSectionSwitcher.toString(),
                    onValueChange = {
                        viewModel.inputData.value =
                            inputData.copy(failureFreqSectionSwitcher = it.toDoubleOrNull() ?: 0.0)
                    },
                    label = { Text("Частота відмов секційного вимикача") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        viewModel.calculateResult()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Companion.Black, contentColor = MaterialTheme.colorScheme.onPrimary)
                ) {
                    Text("Розрахувати")
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Displaying results directly below the inputs
                Text("Частота відмов: ${resultData.failureFrequency}", style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Середня тривалість відновлення: ${resultData.averageRecoveryDuration}", style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Коефіцієнт аварійного простою: ${resultData.emergencyCoeff}", style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Коефіцієнт планового простою: ${resultData.planCoeff}", style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Частота відмов для двох систем: ${resultData.failureFreqForTwoSys}", style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Частота відмов з секційним вимикачем: ${resultData.failureFrequencyWithSectionSwitcher}", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}

@Preview
@Composable
fun ReliabilityViewPreview() {
    Lab5Theme {
        ReliabilityView()
    }
}
