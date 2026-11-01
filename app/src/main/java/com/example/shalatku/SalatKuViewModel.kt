package com.example.shalatku

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SalatKuViewModel : ViewModel() {

    // --- HW12 Part B: Dynamic Target Tasbih ---
    var roundSize by mutableIntStateOf(33)
        private set

    var tasbihCount by mutableIntStateOf(0)
        private set

    var completedRounds by mutableIntStateOf(0)
        private set

    // --- State Tracker ---
    private val _donePrayers = mutableStateListOf<String>()
    val donePrayers: List<String> get() = _donePrayers

    // --- State Home ---
    var selectedDay by mutableIntStateOf(0)
        private set

    // --- Logic Tasbih ---
    fun updateRoundSize(size: Int) {
        roundSize = size
        tasbihCount = 0 // Reset hitungan saat ini, tapi biarkan completedRounds bertahan
    }

    fun incrementTasbih() {
        tasbihCount++
        if (tasbihCount == roundSize) {
            completedRounds++
            tasbihCount = 0
        }
    }

    fun resetTasbih() {
        tasbihCount = 0
        completedRounds = 0
    }

    // --- Logic Tracker ---
    fun togglePrayer(name: String) {
        if (name in _donePrayers) {
            _donePrayers.remove(name)
        } else {
            _donePrayers.add(name)
        }
    }

    // HW12 Part A: Clear All Prayers
    fun clearPrayers() {
        _donePrayers.clear()
    }

    // --- Logic Home ---
    fun selectDay(index: Int) {
        selectedDay = index
    }
}