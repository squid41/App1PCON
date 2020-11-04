package com.dark_phoenix09.app1pcon2k20.SignInUp

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.dark_phoenix09.app1pcon2k20.MainActivity
import com.dark_phoenix09.app1pcon2k20.dashboard

fun Context.toast(message:String)=
    Toast.makeText(this,message, Toast.LENGTH_SHORT)
fun Context.login() {
    val intent = Intent(this, MainActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }
    startActivity(intent)
}


fun Context.logout() {
    val intent = Intent(this, dashboard::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }
    startActivity(intent)
}
