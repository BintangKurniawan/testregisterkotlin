package com.example.ngeteslogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ngeteslogin.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.register.setOnClickListener {
            val fname = binding.Fname.text.toString()
            val pw = binding.getPassword.text.toString()

            database = FirebaseDatabase.getInstance("https://realtime-db-344cd-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("Users")
            val User = User(fname, pw)
            database.child(fname).setValue(User).addOnSuccessListener {
                binding.Fname.text.clear()
                binding.getPassword.text.clear()

                Toast.makeText(this, "jos", Toast.LENGTH_LONG).show()
            }.addOnFailureListener{
                Toast.makeText(this, "tolol", Toast.LENGTH_SHORT).show()
            }
            Toast.makeText(this, "jos", Toast.LENGTH_SHORT).show()

        }
    }
}