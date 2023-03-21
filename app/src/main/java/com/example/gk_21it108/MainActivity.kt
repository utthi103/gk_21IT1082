package com.example.gk_21it108

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gk_21it108.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnInsertData.setOnClickListener {
            val intent  = Intent(this,Insertion_21IT108::class.java)
            startActivity(intent)
        }
        binding.btnFetchData.setOnClickListener {
            val intent  = Intent(this,danhsachSV_21It108::class.java)
            startActivity(intent)

        }
    }
}