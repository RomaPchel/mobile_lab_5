package com.example.lab5

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import com.example.lab5.calculateDamages.DamagesViewModel
import com.example.lab5.calculateDamages.models.DamagesInputModel
import com.example.lab5.calculateDamages.models.DamagesResulModel

@Composable
fun DamagesView(viewModel: DamagesViewModel = viewModel()) {
    val inputModel by viewModel.inputModel.observeAsState(DamagesInputModel())
    val resultModel by viewModel.resulModel.observeAsState(DamagesResulModel())

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = inputModel.failureFrequency.toString(),
            onValueChange = { viewModel.setFailureFrequency(it.toDoubleOrNull() ?: 0.0) },
            label = { Text("Частота відмов") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = inputModel.restoreTile.toString(),
            onValueChange = { viewModel.setRestoreTile(it.toDoubleOrNull() ?: 0.0) },
            label = { Text("Час відновлення") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = inputModel.Pm.toString(),
            onValueChange = { viewModel.setPm(it.toDoubleOrNull() ?: 0.0) },
            label = { Text("Pm") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = inputModel.Tm.toString(),
            onValueChange = { viewModel.setTm(it.toDoubleOrNull() ?: 0.0) },
            label = { Text("Tm") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = inputModel.kp.toString(),
            onValueChange = { viewModel.setKp(it.toDoubleOrNull() ?: 0.0) },
            label = { Text("Kp") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = inputModel.Za.toString(),
            onValueChange = { viewModel.setZa(it.toDoubleOrNull() ?: 0.0) },
            label = { Text("Za") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = inputModel.Zp.toString(),
            onValueChange = { viewModel.setZp(it.toDoubleOrNull() ?: 0.0) },
            label = { Text("Zp") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            viewModel.calculateResult()
        },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Companion.Black, contentColor = MaterialTheme.colorScheme.onPrimary)
        ) {
            Text("Розрахувати")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Displaying results directly below the inputs
        Text("MWa: ${resultModel.MWa}", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text("MWp: ${resultModel.MWp}", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text("Mz: ${resultModel.Mz}", style = MaterialTheme.typography.bodyLarge)
    }
}
