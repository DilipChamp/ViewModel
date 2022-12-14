package com.dileep.viewmodel

import androidx.lifecycle.ViewModel

class MainActivityViewModel(StartingTotal:Int): ViewModel() {
    private var count = 0
    private var total = 0
    init {
        total = StartingTotal
    }
    fun getCurrentCount():Int
    {
        return count
    }

    fun getUpdatedCount():Int
    {
        return ++count
    }

    fun getTotal():Int
    {
        return total
    }
    fun getAddValue(input:Int)
    {
        total += input
    }
}