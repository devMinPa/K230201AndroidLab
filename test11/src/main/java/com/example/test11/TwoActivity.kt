package com.example.test11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.test11.databinding.ActivityTwoBinding

class TwoActivity : AppCompatActivity() {
    override fun onSupportNavigateUp(): Boolean {
        Toast.makeText(this@TwoActivity,"업버튼 클릭시 동작확인",Toast.LENGTH_SHORT).show()
        return super.onSupportNavigateUp()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}