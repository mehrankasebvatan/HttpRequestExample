package ir.mkv.httpexample.volley

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ir.mkv.httpexample.DataModel
import ir.mkv.httpexample.DataAdapter
import ir.mkv.httpexample.databinding.ActivityVolleyBinding

class VolleyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVolleyBinding
    private var list = mutableListOf<DataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVolleyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handleRequest()
        events()
    }

    private fun events() {
        binding.apply {
            toolbar.getChildAt(1).setOnClickListener { finish() }

        }
    }

    private fun handleRequest() {
        val request = StringRequest(
            Request.Method.GET,
            "https://jsonplaceholder.typicode.com/photos",
            { res ->
                Log.i("RESPONSE ===> ", res.toString())
                list = Gson().fromJson(res, object : TypeToken<MutableList<DataModel>>() {}.type)
                val adapter = DataAdapter(list)
                binding.rvData.adapter = adapter
            },
            { err ->
                Toast.makeText(this, err.toString(), Toast.LENGTH_SHORT).show()
            }
        )
        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(request)
    }
}
