package com.mieftah.myviewmodel

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MainViewModelTest {

    private lateinit var mainViewModel: MainViewModel

    @Before
    fun init() {
        mainViewModel = MainViewModel()
    }

    @Test
    fun calculate() {
        val width = "1"
        val length = "2"
        val height = "3"
        mainViewModel.calculate(width, height, length)
        assertEquals(6, mainViewModel.result)
    }
}