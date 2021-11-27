package com.example.jicbangcopy_20211127.datas

import android.util.Log
import java.io.Serializable
import java.text.NumberFormat
import java.util.*

class RoomData(
    val price: Int,
    val address: String,
    val floor: Int,
    val description: String
) : Serializable {
    // 방 데이터의 기능 : 가격을 가공해서 String 으로 주는 기능. -> 리스트뷰/상세화면에서 사용.
    fun getFormattedPrice() : String {
        if(this.price < 10000) {
            return NumberFormat.getNumberInstance(Locale.KOREA).format(this.price)
        } else {
            val uk = this.price / 10000 // Int/Int -> 결과도 무조건 Int (소수점 버림) -> 억단위 추출
            val rest = this.price % 10000 // 나머지 구하기

            val str = NumberFormat.getNumberInstance(Locale.KOREA).format(rest)

            return "${uk}억 ${str}"
        }
    }


    // 추가 기능 : 층수도 가공해서 String 으로 주자.
    fun getFormattedFloor() : String {
        val floorStr : String

        if(floor == 0) return "반지하 층"
        else if(floor > 0) return "지하 " + floor.toString().substring(1) + "층"
        else return floor.toString() + "층"
    }
}