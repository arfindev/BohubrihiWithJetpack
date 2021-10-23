package com.example.bohubrihiwithjetpack

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.bohubrihiwithjetpack.retrofit.RetrofitClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

class MainActivity : ComponentActivity() {

    private val apiKey = "rNCnpnQge4Il62hiTcLVX6FAr8IPG7oW"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dddd)
        getRegionByHttp()
    }

    private fun getRegionByHttp() {
        RetrofitClient.retrofitInstance?.getApi()?.getRegion(apiKey)
            ?.enqueue(object : retrofit2.Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if (response.isSuccessful) {
                        var dataBody = response.body()?.string()
                        Toast.makeText(this@MainActivity, dataBody, Toast.LENGTH_SHORT).show()
                    } else {
                        try {
                            val error = response.errorBody()?.string()
                            var catchError = error
                            Toast.makeText(this@MainActivity, error, Toast.LENGTH_SHORT).show()

                        } catch (e: Exception) {
                            e.printStackTrace()
                            Toast.makeText(
                                this@MainActivity,
                                "something went wrong",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
                }
            })
    }
}




