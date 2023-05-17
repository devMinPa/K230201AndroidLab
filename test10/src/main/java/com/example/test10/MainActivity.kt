package com.example.test10

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.example.test10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    //경고창, 특정정보를 띄워서,
    val eventHandler = object :DialogInterface.OnClickListener{
        override fun onClick(dialog: DialogInterface?, which: Int) {
            if(which == DialogInterface.BUTTON_POSITIVE){
                Toast.makeText(this@MainActivity,"확인 시 토스트 띄우기",Toast.LENGTH_SHORT).show()
            }else if(which==DialogInterface.BUTTON_NEGATIVE){
                Toast.makeText(this@MainActivity,"취소 시 토스트 띄우기",Toast.LENGTH_SHORT).show()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.R)
    fun showTest(){
        val toast = Toast.makeText(this,"message 내용",Toast.LENGTH_SHORT)

        toast.addCallback(
            object : Toast.Callback(){
                override fun onToastHidden() {
                    super.onToastHidden()
                    Log.d("nsh","toast hidden, 숨겨진 후 추가 기능 동작.")
                }

                override fun onToastShown() {
                    super.onToastShown()
                    Log.d("nsh","toast shown , 보여진 후 추가 기능 동작.")
                }
            }
        )
        toast.show()
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRadio.setOnClickListener {
            val items = arrayOf<String>("사과","복숭아","수박","딸기")
            AlertDialog.Builder(this@MainActivity).run {
                setTitle("items test")
                setIcon(android.R.drawable.ic_dialog_info)
                setSingleChoiceItems(
                    items,
                    1,
                    object: DialogInterface.OnClickListener{
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            Log.d("nsh","${items[which]} 이 선택되었습니다.")
                        }
                    }
                )
                setCancelable(false)
                setPositiveButton("닫기",null)
                show()
            }.setCanceledOnTouchOutside(true)
        }

        //다이얼로그에 체크박스 선택 부분 해보기.
        binding.btnCheck.setOnClickListener {
            val items = arrayOf<String>("두루치기","된장찌개","밀면","칼국수")
            AlertDialog.Builder(this@MainActivity).run {
                setTitle("checkbox alert 다이얼로그")
                setIcon(android.R.drawable.ic_dialog_info)
                setMultiChoiceItems(
                    items,
                    booleanArrayOf(true,false,false,false),
                    object: DialogInterface.OnMultiChoiceClickListener{
                        override fun onClick(
                            dialog: DialogInterface?,
                            which: Int,
                            isChecked: Boolean
                        ) {
                            Log.d("nsh","선택한 점심 메뉴: ${items[which]} 이 ${if(isChecked)"선택됨." else "선택 해제됨."}")
                        }
                    }
                )
                setPositiveButton("닫기",null)
                show()
            }

        }


        //다이얼로그에 메뉴 선택 부분 확인 해보기.
        binding.btnManu.setOnClickListener {
            val items = arrayOf<String>("두루치기","된장찌개","밀면","칼국수")
            AlertDialog.Builder(this@MainActivity).run {
                setTitle("메뉴 alert 다이얼로그")
                setIcon(android.R.drawable.ic_dialog_info)
                setItems(
                    items,
                    object:DialogInterface.OnClickListener{
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            Log.d("nsh","선택한 점심 메뉴 : ${items[which]}")
                        }
                    }
                )
                setPositiveButton("닫기",null)
                show()
            }

        }

        //경고창, 특정 정보를 띄워서, 확인시 동작 기능, 취소시 동작.
        binding.btnAlert.setOnClickListener {
            AlertDialog.Builder(this@MainActivity).run{
                setTitle("테스트 제목")
                setIcon(android.R.drawable.ic_dialog_info)
                setMessage("토스트 메시지 띄울까요?")
                setPositiveButton("확인",eventHandler)
                setNegativeButton("취소",eventHandler)
                show()
        }

        }

        //날짜 다이얼로그 띄우기, 출력은, 콘솔 또는 토스트 메세지
        binding.btnDate.setOnClickListener{
            //DatePickerDialog(this,리스너, 년도,월,일).show()
            DatePickerDialog(this,object : DatePickerDialog.OnDateSetListener{
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    Log.d("nsh","year(년도): $year, month: ${month+1}, dayOfMonth: $dayOfMonth")
                    Toast.makeText(this@MainActivity,"year(년도): $year, month: ${month+1}, dayOfMonth: $dayOfMonth",Toast.LENGTH_SHORT).show()
                }
            },2020,5,15).show()
        }

        //시간을 띄우는 버튼 UI 추가, 해당 시간을 출력하는 1)Log.d 2)토스트 메시지에도 출력하기 p18참고
        binding.btnTime.setOnClickListener {
            //TimePickerDialog(this,리스너,시,분,24시간표기)
            TimePickerDialog(this,object:TimePickerDialog.OnTimeSetListener{
                override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                    Log.d("nsh","hourOfDay:$hourOfDay 시, minute: $minute 분")
                    Toast.makeText(this@MainActivity,"hourOfDay:$hourOfDay 시, minute: $minute 분",Toast.LENGTH_SHORT).show()
                }
            },15,0,false).show()
        }

        binding.btn1.setOnClickListener{
            //toast.show()
            //
            Toast.makeText(this,"토스트 출력 방법2",Toast.LENGTH_SHORT).show()

            //옵션, 토스트 메세지가 보여지거나, 사라졌을 경우에 추가 기능을 확인 중
            showTest()
        }

        val requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ){
            isGranted ->
            if(isGranted){
                Log.d("nsh","승인됨")
            }else{
                Log.d("nsh","승인 안됨.")
            }
        }

        val status= ContextCompat.checkSelfPermission(this,"android.permission.ACCESS_FINE_LOCATION")
        if(status == PackageManager.PERMISSION_GRANTED){
            Log.d("nsh","status 승인 됨2.")
        }else{
            Log.d("nsh","status 승인 안됨2.")
            requestPermissionLauncher.launch("android.permission.ACCESS_FINE_LOCATION")
        }
    }
}