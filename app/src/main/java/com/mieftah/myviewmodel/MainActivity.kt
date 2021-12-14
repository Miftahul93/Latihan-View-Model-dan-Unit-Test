package com.mieftah.myviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.mieftah.myviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    //private lateinit var viewModel: MainViewModel
    //menyingkat iniziazi viewmodel
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        // dizingkat jadi dihilangkan iniziazinya
        //viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        displayResult()

        activityMainBinding.btnCalculate.setOnClickListener {
            val length = activityMainBinding.edtLength.text.toString()
            val width = activityMainBinding.edtWidth.text.toString()
            val height = activityMainBinding.edtHeight.text.toString()

            when {
                width.isEmpty() -> {
                    activityMainBinding.edtWidth.error = "Masih Kosong"
                }

                height.isEmpty() -> {
                    activityMainBinding.edtHeight.error = "Masih Kosong"
                }

                length.isEmpty() -> {
                    activityMainBinding.edtLength.error = "Masih Kosong"
                }

                else -> {
                    viewModel.calculate(width, height, length)
                    displayResult()
                }
            }
        }
    }

    private fun displayResult() {
        activityMainBinding.tvResult.text = viewModel.result.toString()
    }
}