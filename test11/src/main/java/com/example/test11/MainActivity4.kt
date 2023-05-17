package com.example.test11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test11.databinding.ActivityMain4Binding
import com.example.test11.databinding.Item342Binding

//리사이클러뷰가 재료로 다른 액티비티에서 재활용 될 예정
class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //임시 데이터
        val datas = mutableListOf<String>()
        for(i in 1..9) {
            datas.add("Item $i")
        }

        //설정 아래에 클래스들 참고 하고.

        //1) 뷰 홀더, 2)어댑터, 3)레이아웃 매니저

        // 설정이 적용
        // 출력을 위한 목록의 틀이 필요함 ->activity_main4 여기에 아이디를 추가.
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        // 틀에 해당 어댑터 붙이기 작업.
        binding.recyclerView.adapter = MyAdapter(datas)
        //옵션, 아이템
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(this,LinearLayoutManager.VERTICAL)
        )
    }
}
//뷰 홀더 만들기. (item.342.xml 의 자동생성된 바인딩 파일 사용.)
class MyViewHolder(val binding:Item342Binding) :RecyclerView.ViewHolder(binding.root)
//어댑터 만들기.
class MyAdapter(val datas:MutableList<String>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    //필수적으로 재정의 해야하는 함수들
    //다 적어도 되지만, 자동완성으로, 해당 클래스에서 선택하면, 자동 구현 링크 클릭하기.
    //재 정의한 함수는 다 자동호출. 순서 상관 없음.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
    =
        // MyViewHolder() 이부분에 정의 부분,
        // 참고 코드:
        // 실제 xml 파일명 : item_342.xml
        // 자동으로 생성되는 Item342Binding -> 리사이클러 뷰의 하나의 아이템 구성.
        // 순서는 : 목록 리스트, 구성품을 아이템,
        // 설계 순서는, 큰것 -> 작은것, 진행 방향이.
        // 개발순서는 반대로, 작은것 ->큰것
        MyViewHolder(Item342Binding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun getItemCount(): Int {
        Log.d("nsh","init datas size 크기: ${datas.size}")
        return datas.size
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //holder : RecyclerView.ViewHolder 타입, 부모 클래스 타입
        //holder 타입 변환 : -> 다운캐스팅 MyViewHolder
        val binding = (holder as MyViewHolder).binding

        //뷰에 데이터 출력 : 아이템의 하나의 요소, 어댑터 데이터를 해당 뷰에 연결해주기.
        binding.itemData.text = datas[position]

        //뷰에 이벤트 추가. 리사이클러 뷰 그룹 레이아웃.
        binding.itemRoot.setOnClickListener{
            //어댑터 클래스는, 액티비티 컴포넌트 클래스가 아니라서, 이것 사용하려면, 해당 부모 클레스에서
            //상속을 받아서 써야합니다.
//            Toast.makeText(this@MyAdapter,"메세지 요소 인덱스: $position",Toast.LENGTH_SHORT).show()
        }
    }

}