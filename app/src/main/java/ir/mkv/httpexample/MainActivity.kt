package ir.mkv.httpexample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ir.mkv.httpexample.databinding.ActivityMainBinding
import ir.mkv.httpexample.retrofit.RetrofitActivity
import ir.mkv.httpexample.volley.VolleyActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        event()
    }

    private fun event() {
        binding.apply {
            btnRetrofit.setOnClickListener {
                startActivity(
                    Intent(
                        this@MainActivity,
                        RetrofitActivity::class.java
                    )
                )
            }

            btnVolley.setOnClickListener {
                startActivity(
                    Intent(
                        this@MainActivity,
                        VolleyActivity::class.java
                    )
                )
            }
        }
    }
}