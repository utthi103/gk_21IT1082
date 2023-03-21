package com.example.gk_21it108

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.gk_21it108.databinding.ActivityInsertion21It108Binding
import com.example.gk_21it108.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Insertion_21IT108 : AppCompatActivity() {
    private lateinit var binding: ActivityInsertion21It108Binding
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInsertion21It108Binding.inflate(layoutInflater)
        setContentView(binding.root)
        dbRef = FirebaseDatabase.getInstance().getReference("SinhVien")
        binding.btnsave.setOnClickListener {
            saveSV()
        }
    }

    private fun saveSV() {
        var svMsv = binding.txtMsv.text.toString()
        val svName = binding.txtHoten.text.toString()
        val svAge = binding.txttuoi.text.toString()
        val svGender = binding.txtgioitinh.text.toString()


//        svMsv = dbRef.push().key!!
        val sinhvien = Data_21IT108(svMsv,svName,svAge, svGender)
        if(svName.isEmpty()){
            binding.txtHoten.error = "Please enter name"
            return
        }
        if(svMsv.isEmpty()){
            binding.txttuoi.error = "Please enter MSV"
            return
        }
        if(svAge.isEmpty()){
            binding.txttuoi.error = "Please enter Age"
            return
        }
        val age = binding.txttuoi.text
        if(age.toString()< 18.toString()){
            binding.txttuoi.error = "Age must <18"
            return
        }
        if(svGender.isEmpty()){
            binding.txtgioitinh.error = "Please enter gender"
            return
        }
        dbRef.child(svMsv).setValue(sinhvien).addOnCompleteListener {
            Toast.makeText(this,"Thêm dữ liệu thành công", Toast.LENGTH_SHORT).show()
            binding.txtHoten.setText("")
            binding.txtgioitinh.setText("")
            binding.txttuoi.setText("")

        }.addOnFailureListener {err->
            Toast.makeText(this,"ERR ${err.message}", Toast.LENGTH_SHORT).show()
        }
    }
}