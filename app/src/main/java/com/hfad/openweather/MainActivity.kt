package com.hfad.openweather



import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.hfad.openweather.databinding.ActivityMainBinding
import com.hfad.openweather.fragments.MainFragment
import org.json.JSONObject


const val API_KAY = "9e6dd28744124805bd960633222707"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.pleaceHolder, MainFragment.newInstance())
            .commit()
        //binding.bGet.setOnClickListener{
           // getResult(name = "London")

        }
    }
//    private fun getResult(name: String){
//        val url = "https://api.weatherapi.com/v1/current.json"+
//                "?key=$API_KAY&q=$name&adi=no"
//        //val queue = Volley.newRequestQueue(this)//новая очередь запроса
//
//        val stringRequest =  StringRequest(Request.Method.GET,
//            url,
//            {
//                    response->
//                val obj = JSONObject(response)
//                val temp = obj.getJSONObject("current")
//                Log.d("MyLog","Response: ${temp.getString("temp_c")}")
//
//            },
//
//            {
//                Log.d("MyLog","Volley error: $it")
//            }
//        )
//
//        //queue.add(stringRequest)
//    }
//

