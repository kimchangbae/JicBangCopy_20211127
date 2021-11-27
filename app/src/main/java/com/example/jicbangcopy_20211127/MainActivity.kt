package com.example.jicbangcopy_20211127

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.jicbangcopy_20211127.adapter.RoomAdapter
import com.example.jicbangcopy_20211127.datas.RoomData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mRoomList = ArrayList<RoomData>()
    lateinit var mRoomAdapter: RoomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRoomList.add( RoomData(8000,   "서울시 동대문구",     5, "1번 방") )
        mRoomList.add( RoomData(5000,   "서울시 노원구",      1, "2번 방") )
        mRoomList.add( RoomData(6000,   "서울시 은평구",      0, "3번 방") )
        mRoomList.add( RoomData(2000,   "서울시 서대문구",    -5, "4번 방") )
        mRoomList.add( RoomData(7000,   "서울시 강남구",      23, "5번 방") )
        mRoomList.add( RoomData(9000,   "서울시 서초구",      -11, "6번 방") )
        mRoomList.add( RoomData(10000,  "서울시 노원구",      0, "7번 방") )
        mRoomList.add( RoomData(20000,  "서울시 은평구",      13, "8번 방") )
        mRoomList.add( RoomData(50000,  "서울시 동대문구",    -20, "9번 방") )

        mRoomAdapter = RoomAdapter(this, R.layout.room_list_item, mRoomList)
        roomListView.adapter = mRoomAdapter

        roomListView.setOnItemClickListener { adapterView, view, position, l ->
            val clickedRoom = mRoomList.get(position)

            val myIntent = Intent(this, ViewDetailActivity::class.java)
            myIntent.putExtra("room",mRoomList)
            startActivity(myIntent)
        }
    }
}