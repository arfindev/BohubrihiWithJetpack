package com.example.bohubrihiwithjetpack

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.bohubrihiwithjetpack.retrofit.RetrofitClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import java.lang.Exception
import javax.security.auth.callback.Callback

class MainActivity : ComponentActivity() {
    private val weatherAPI = "rNCnpnQge4Il62hiTcLVX6FAr8IPG7oW"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContent {
           composable()

       }
    }

     fun getRegionsHttp() : RetrofitClient.Companion {
        RetrofitClient.getInstance().getApi()
            ?.getRegions(weatherAPI)
            ?.enqueue(object : retrofit2.Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if (response.isSuccessful) {
                        val successFul = response.body()?.string()
                        Toast.makeText(this@MainActivity, successFul, Toast.LENGTH_SHORT).show()

                    } else {
                        try {
                            val errorDetect = response.errorBody()?.string()
                            val error = errorDetect
                            Toast.makeText(this@MainActivity, error, Toast.LENGTH_SHORT).show()

                        } catch (e: Exception) {
                            Toast.makeText(this@MainActivity, "something wrong", Toast.LENGTH_SHORT)
                                .show()

                        }
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
                }
            })
return RetrofitClient
    }


}




