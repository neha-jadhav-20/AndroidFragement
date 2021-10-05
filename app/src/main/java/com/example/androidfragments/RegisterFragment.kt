package com.example.androidfragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.setFragmentResult

class RegisterFragment(val callback: (String,String) -> Unit) : Fragment()  /*, View.OnClickListener   */ {

    lateinit var registerButton: Button
    lateinit var unameEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var confpwEditText : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("RegisterFragment","onCreate called")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("RegisterFragment","onCreateView called")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("RegisterFragment","onViewCreated called")
        registerButton = view.findViewById(R.id.regiB)
        unameEditText = view.findViewById(R.id.unameE)
        passwordEditText = view.findViewById(R.id.passE)
        confpwEditText = view.findViewById(R.id.confpassE)

        //registerButton.setOnClickListener(this)
        registerButton.setOnClickListener {
            registerClick(it)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("RegisterFragment","onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("RegisterFragment","onResume called")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("RegisterFragment","onAttach called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("RegisterFragment","onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("RegisterFragment","onStop called")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("RegisterFragment","onDestroyView called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("RegisterFragment","onDestroy called")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("RegisterFragment","onDetach called")
    }

//    override fun onClick(p0: View?) {
//
//        val userid = unameEditText.text.toString()
//        val password = passwordEditText.text.toString()
//        val confirmPass = confpwEditText.text.toString()
//
//        if(userid.isNotEmpty() && password.isNotEmpty() && confirmPass.isNotEmpty()){
//            Toast.makeText(activity, "Registering...", Toast.LENGTH_SHORT).show()
//        }
//        else
//            Toast.makeText(activity, "Please enter all data", Toast.LENGTH_SHORT).show()
//
//    }

    fun registerClick(p0: View?) {

        val userid = unameEditText.text.toString()
        val password = passwordEditText.text.toString()
        val confirmPass = confpwEditText.text.toString()

        if(userid.isNotEmpty() && password.isNotEmpty() && confirmPass.isNotEmpty()){
            Toast.makeText(activity, "Registering...", Toast.LENGTH_SHORT).show()

           // callback(userid, password)  // activity method execution

            val result = Bundle()
            result.putString("userid", userid)
            result.putString("password",password)

            setFragmentResult("registrationData", result)      // another method for frag to frag communication

        }
        else
            Toast.makeText(activity, "Please enter all data", Toast.LENGTH_SHORT).show()

    }


}