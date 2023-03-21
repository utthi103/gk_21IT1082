package com.example.gk_21it108

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.gk_21it108.databinding.ActivitySvDetail21It108Binding
import com.google.firebase.database.FirebaseDatabase

class SV_detail_21It108 : AppCompatActivity() {
    private lateinit var binding: ActivitySvDetail21It108Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySvDetail21It108Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
         detailSV()
        binding.btnDelete.setOnClickListener {
            deleteSV(intent.getStringExtra("MSV").toString())
        }
    }

    private fun deleteSV(msv: String) {
        val dbRef = FirebaseDatabase.getInstance().getReference("SinhVien").child(msv)
        val mTask = dbRef.removeValue()
        mTask.addOnSuccessListener {
            Toast.makeText(this,"Delete employee success", Toast.LENGTH_SHORT).show()
            val intent  = Intent(this,danhsachSV_21It108::class.java)
            finish()
            startActivity(intent)
        }.addOnFailureListener{err->
            Toast.makeText(this,"Delete err${err.message}", Toast.LENGTH_SHORT).show()

        }
    }

    private fun detailSV() {
        binding.txtMsv.text = intent.getStringExtra("MSV")
        binding.txtName.text = intent.getStringExtra("Name")
        binding.txtAge.text = intent.getStringExtra("Age")
        binding.txtGender.text = intent.getStringExtra("Gender")
    }
}