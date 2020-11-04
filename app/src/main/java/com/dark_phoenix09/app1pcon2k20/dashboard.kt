package com.dark_phoenix09.app1pcon2k20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.dark_phoenix09.app1pcon2k20.SignInUp.login
import kotlinx.android.synthetic.main.activity_dashboard.*

class dashboard : AppCompatActivity() {
    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        handler = Handler()
        handler.postDelayed({

            // Delay and Start Activity
            val intent = Intent(this@dashboard,login::class.java)
            startActivity(intent)
            finish()
        } , 3000) // here we're delaying to startActivity after 3seconds


    }
}