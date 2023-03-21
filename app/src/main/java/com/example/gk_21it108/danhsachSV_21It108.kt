package com.example.gk_21it108

import android.content.Intent
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gk_21it108.databinding.ActivityDanhsachSv21It108Binding
import com.google.firebase.database.*

class danhsachSV_21It108 : AppCompatActivity() {
    private lateinit var ds:ArrayList<Data_21IT108>
    private lateinit var dbRef: DatabaseReference
    private  lateinit var binding: ActivityDanhsachSv21It108Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDanhsachSv21It108Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvSV.layoutManager = LinearLayoutManager(this)
        binding.rvSV.setHasFixedSize(true)
        ds = arrayListOf<Data_21IT108>()
        GetSV()
    }

    private fun GetSV() {
        dbRef = FirebaseDatabase.getInstance().getReference("SinhVien")
        dbRef.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                ds.clear()
                if (snapshot.exists()){
                    for (empSnap in snapshot.children){
                        val empData = empSnap.getValue(Data_21IT108::class.java)
                        ds.add(empData!!)
                    }
                    val madapter = RvAdapter(ds)
                    binding.rvSV.adapter = madapter

                    madapter.setOnItemClickListener(object :RvAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {
                            val intent = Intent(this@danhsachSV_21It108,SV_detail_21It108::class.java )
                            intent.putExtra("MSV", ds[position].svMsv)
                            intent.putExtra("Name", ds[position].svName)
                            intent.putExtra("Age", ds[position].svAge)
                            intent.putExtra("Gender", ds[position].svGender)
                            startActivity(intent)

                        }
                    })

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}