package com.example.androidfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    lateinit var regButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        regButton = findViewById(R.id.registerB)
    }

    fun buttonClick(view: View) {
        when(view.id){
            R.id.loginB ->{
                Toast.makeText(this, "Login button pressed", Toast.LENGTH_SHORT).show()
                val transaction = supportFragmentManager.beginTransaction()
                val frag = LoginFragment()
                transaction.replace(R.id.parentFL,frag)    // we replaced previous fragment
                transaction.commit()

            }
            R.id.registerB->{
                Toast.makeText(this, "Register button pressed", Toast.LENGTH_SHORT).show()
                // add register fragment

                // get fragment manager
                val transaction = supportFragmentManager.beginTransaction()     // gives object of fragment transsaction
                val frag = RegisterFragment(::registrationDone)      // get object of fragment class
                transaction.add(R.id.parentFL,frag)       // add that fragment to our parent layout holder
                transaction.replace(R.id.parentFL,frag)       // we replace previous fragment
                //transaction.addToBackStack(null)     //now on pressing back your activity won't be destroyed only register view will be vanished
                transaction.commit()     // fragment is now interactive or visible to the user
            }
        }
    }

    fun registrationDone(uname : String, password : String){
        // disable "REGISTER" button
        regButton.isEnabled = false

        // navigating user to login
        val transaction =  supportFragmentManager.beginTransaction()
        val frag = LoginFragment()

        val b = Bundle()
        b.putString("userid",uname)
        b.putString("password",password)

        frag.arguments = b

        transaction.replace(R.id.parentFL,frag)
        transaction.commit()
    }
}