package com.example.test8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.widget.CompoundButton
import com.example.test8.databinding.ActivityMainBinding


class MyEventHandler : CompoundButton.OnCheckedChangeListener{
    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        Log.d("nsh","방법 2 외부 클래스로 구현")
    }
}

//class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
class MainActivity : AppCompatActivity() {

//    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
//        Log.d("nsh","체크박스 클릭.")
//    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when(keyCode){
            KeyEvent.KEYCODE_BACK -> Log.d("nsh","Back 키를 눌렀네요")
            KeyEvent.KEYCODE_VOLUME_UP -> Log.d("nsh","VOLUME_UP 키를 눌렀네요")
            KeyEvent.KEYCODE_VOLUME_DOWN -> Log.d("nsh","VOLUME_DOWN 키를 눌렀네요")
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("nsh","onKeyUp 실행")
        return super.onKeyUp(keyCode, event)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN -> {
                Log.d("nsh","Touch Down event x:${event.x}, raw X:${event.rawX}")
            }
            MotionEvent.ACTION_UP -> {
                Log.d("nsh","Touch Up event 발생함")
            }
        }
        return super.onTouchEvent(event)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //방법 1:
        //리스너 인터페이스를 메인 액티비티에서 구현 후, 이벤트 처리 방법.
//        binding.check1.setOnCheckedChangeListener(this)
        
        //방법 2:
        //클래스로 정의된 리스너를 사용함
//        binding.check1.setOnCheckedChangeListener(MyEventHandler())
        
        //방법 3: SAM 기법(Single Abstract Method) , 자바: 함수형 인터페이스, 람다식 구현.
        //인터페이스 : 구성을 추상 메서드로 구성된 것
        // 추상 메서드 : 메서드의 선언부는 있지만, 구현부가 없는 것을 말함.
        // 보통 인터페이스를 구현해서 사용할 때, 보통 재정의해서 사용함.
        binding.check1.setOnCheckedChangeListener{
            a,b -> Log.d("nsh","방법 3: SAM 기법 구현: 체크박스 클릭")
        }

        binding.btn1.setOnLongClickListener{
            Log.d("nsh","롱 클릭")
            true
        }
    }
}