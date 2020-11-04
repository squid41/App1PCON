package com.dark_phoenix09.app1pcon2k20.SignInUp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import com.dark_phoenix09.app1pcon2k20.MainActivity
import com.dark_phoenix09.app1pcon2k20.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mAuth = FirebaseAuth.getInstance()
        text_view_login.setOnClickListener {
            startActivity(Intent(this@RegisterActivity, login::class.java))
        }
        button_register.setOnClickListener {
            val email=text_email1.text.toString().trim()
            val password=edit_text_password1.toString().trim()
            if(email.isEmpty())
            {
                text_email1.error="Email Required"
                text_email1.requestFocus()
                return@setOnClickListener

            }
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            {
                text_email1.error="Valid Email Required"
                text_email1.requestFocus()
                return@setOnClickListener


            }
            if(password.isEmpty() || password.length<6)
            {
                edit_text_password1.error="6 char password required"
                edit_text_password1.requestFocus()
                return@setOnClickListener

            }
            registeruser(email,password)
        }

    }
    private fun registeruser(email:String,password:String){

        mAuth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){task->
                if(task.isSuccessful)
                {
                    val intent=Intent(this@RegisterActivity, MainActivity::class.java).apply{
                        flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    }
                    startActivity(intent)
                }
                else
                {
                    task.exception?.message?.let {
                        toast(it)
                    }
                }
            }
    }
    override fun onStart() {
        super.onStart()
        mAuth.currentUser?.let {

            val intent=Intent(this@RegisterActivity, MainActivity::class.java).apply{
                flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
    }
}

}