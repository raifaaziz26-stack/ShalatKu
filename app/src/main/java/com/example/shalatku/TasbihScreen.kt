package com.example.shalatku

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TasbihScreen(
    count: Int,
    rounds: Int,
    target: Int,
    onIncrement: () -> Unit,
    onReset: () -> Unit,
    onSetTarget: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Tasbih", style = MaterialTheme.typography.headlineMedium)

        // Tampilkan putaran/rounds
        Text("Rounds: $rounds", style = MaterialTheme.typography.titleMedium)

        Spacer(Modifier.height(16.dp))

        // Tampilkan hitungan / target (contoh: 5 / 33)
        Text("$count / $target", style = MaterialTheme.typography.displayLarge)

        Spacer(Modifier.height(16.dp))

        // HW12 Part B: Pilihan Target (33, 99, 100)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf(33, 99, 100).forEach { size ->
                FilterChip(
                    selected = (target == size),
                    onClick = { onSetTarget(size) },
                    label = { Text("$size") }
                )
            }
        }

        Spacer(Modifier.height(24.dp))

        // Memanggil lambda fungsi dari ViewModel
        Button(onClick = onIncrement) { Text("+1") }
        Spacer(Modifier.height(8.dp))
        OutlinedButton(onClick = onReset) { Text("Reset") }
    }
}