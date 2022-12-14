package com.dileep.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.dileep.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewModelFactory: MainActivityViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModelFactory=MainActivityViewModelFactory(120)
        viewModel= ViewModelProvider(this,viewModelFactory)[MainActivityViewModel::class.java]
        binding.countText.text=viewModel.getCurrentCount().toString()
        binding.clickHere.setOnClickListener()
        {
            binding.countText.text=viewModel.getUpdatedCount().toString()
        }

        // add values
        binding.value.text=viewModel.getTotal().toString()
        binding.add.setOnClickListener()
        {
            viewModel.getAddValue(binding.addValue.text.toString().toInt())
            binding.value.text=viewModel.getTotal().toString()
        }

    }
}