package ir.mkv.httpexample.retrofit

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ir.mkv.httpexample.DataModel
import ir.mkv.httpexample.databinding.ActivityRetrofitBinding
import ir.mkv.httpexample.DataAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRetrofitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRetrofitBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
        event()

    }

    private fun getData() {
        ApiInstance.api.getList().enqueue(object : Callback<MutableList<DataModel>> {
            override fun onResponse(
                call: Call<MutableList<DataModel>>,
                response: Response<MutableList<DataModel>>
            ) {

                val adapter = DataAdapter(response.body() ?: mutableListOf())
                binding.rvData.adapter = adapter
            }

            override fun onFailure(call: Call<MutableList<DataModel>>, t: Throwable) {
                Toast.makeText(this@RetrofitActivity, t.toString(), Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun event() {
        binding.apply {
            toolbar.getChildAt(1).setOnClickListener { finish() }

        }
    }
}