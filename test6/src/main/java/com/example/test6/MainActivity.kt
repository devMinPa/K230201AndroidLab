package com.example.test6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.test6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //button1 을 뷰바인딩 기법으로 접근
        var status =0

        binding.btn1.setOnClickListener{

            if(status==0) {
                binding.img1.visibility = View.INVISIBLE
                status=1
            }else{
                binding.img1.visibility = View.VISIBLE
                status=0
            }

        }

//        val button1=findViewById<Button>(R.id.btn1)
//        val img1 = findViewById<ImageView>(R.id.img1)
//        var status=0
//
//        //button1 눌러서 -> img1 show/hide
//        button1.setOnClickListener{
//            if(status == 0) {
//                img1.visibility = View.INVISIBLE
//                status = 1
//            }else{
//                img1.visibility = View.VISIBLE
//                status = 0
//            }
//        }
    }
}