package com.example.androidfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.setFragmentResultListener

class LoginFragment : Fragment() {

    lateinit var useridEditText: EditText
    lateinit var passewordEditText: EditText
    lateinit var submitButton: Button

    var username = ""
    var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setFragmentResultListener("registrationData"){ key, bundle ->

            username = bundle.getString("userid")  ?: ""
            password = bundle.getString("password") ?: ""

            useridEditText.setText(username)
            passewordEditText.setText(password)

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        useridEditText = view.findViewById(R.id.unameloginE)
        passewordEditText = view.findViewById(R.id.passloginE)
        submitButton = view.findViewById(R.id.loginB)

        useridEditText.setText(username)
        passewordEditText.setText(password)

//        val dataBundle = arguments
//        dataBundle?.let{
//            val userid = it.getString("userid")
//            val password = it.getString("password")
//            useridEditText.setText(userid)
//            passewordEditText.setText(password)
//        }
    }

}