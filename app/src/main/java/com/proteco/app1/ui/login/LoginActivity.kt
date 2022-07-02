package com.proteco.app1.ui.login

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.proteco.app1.MainActivity
import com.proteco.app1.databinding.ActivityLoginBinding

import com.proteco.app1.R
import com.proteco.app1.databinding.DialogRegBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val credenciales = mutableListOf<String>("Juan123", "orejas123", "Naomi14", "4lan", "Al1n_", "SyA2623", "Ultimo14", "penultimo18")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val etUser = binding.etUser
        val etPass = binding.etPass
        val login = binding.login
        val registrarB = binding.btnReg
        val google = binding.loginGoogle
        val facebook = binding.loginFace
        val forgotPass = binding.btnConOlv
        val gato = binding.gato

        //Complete and destroy login activity once successful
        //finish()
        login.setOnClickListener {
            if (credenciales.contains(etUser?.text.toString())){
                var id = credenciales.indexOf(etUser?.text.toString())
                if (credenciales[id] == etUser?.text.toString() && credenciales[id+1] == etPass?.text.toString()){
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("usuario", etUser?.text.toString())
                    startActivity(intent)
                    finish()
                }
            }else{
                Toast.makeText(applicationContext, R.string.login_failed, Toast.LENGTH_SHORT).show()
            }
        }

        gato?.setOnClickListener{
            Toast.makeText(applicationContext, R.string.miau, Toast.LENGTH_SHORT).show()
        }

        google?.setOnClickListener {
            Toast.makeText(applicationContext, R.string.reedireccion, Toast.LENGTH_SHORT).show()
        }

        facebook?.setOnClickListener {
            Toast.makeText(applicationContext, R.string.reedireccion, Toast.LENGTH_SHORT).show()
        }

        forgotPass?.setOnClickListener {
            if (etUser?.text?.isEmpty() == true){
                Toast.makeText(applicationContext, R.string.invalid_username, Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext, R.string.success_login, Toast.LENGTH_SHORT).show()
            }
        }

        registrarB?.setOnClickListener{
            showCreateDialog()
        }

    }

    private fun showCreateDialog(){
        val fragmentManager = supportFragmentManager
        val newFragment = DialogReg()
        // The device is smaller, so show the fragment fullscreen
        val transaction = fragmentManager.beginTransaction()
        // For a little polish, specify a transition animation
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        // To make it fullscreen, use the 'content' root view as the container
        // for the fragment, which is always the root view for the activity
        transaction
            .add(android.R.id.content, newFragment)
            .addToBackStack(null)
            .commit()
    }
}