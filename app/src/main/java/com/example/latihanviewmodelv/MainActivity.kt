package com.example.latihanviewmodelv

import android.os.Bundle
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.latihanviewmodelv.databinding.ActivityMainBinding
import android.view.Menu
import android.content.Intent

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        mainViewModel.currentNumber().observe(this) {
            binding.tvNumber.text = it.toString()
        }

        mainViewModel.currentType().observe(this) {
            binding.tvNumberType.text = it
        }

        binding.btnAdd.setOnClickListener {
            mainViewModel.increment()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.theme_menu -> {
                val intent = Intent(this@MainActivity, ThemeActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}