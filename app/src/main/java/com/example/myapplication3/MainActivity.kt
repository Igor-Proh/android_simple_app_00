package com.example.myapplication3

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication3.constance.Constance
import com.example.myapplication3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding
    private var login: String = "empty"
    private var password: String = "empty"
    private var name: String = "empty"
    private var name2: String = "empty"
    private var name3: String = "empty"
    private var avatarImageId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Constance.REQUEST_CODE_SIGN_IN) {
            val l = data?.getStringExtra(Constance.LOGIN)
            val p = data?.getStringExtra(Constance.PASSWORD)

            if (login == l && password == p) {
                bindingClass.imAvatar.setImageResource(avatarImageId)
                val textInfo = "$name $name2 $name3"
                bindingClass.tvInfo.text = textInfo
            } else {
                bindingClass.tvInfo.text = "Account does not exist"
                bindingClass.imAvatar.setImageResource(R.drawable.dula)

            }

        } else if (requestCode == Constance.REQUEST_CODE_SIGN_UP) {

        }

    }

    fun onClickSignIn(view: View) {
        val intent = Intent(this, SignInUpActivity::class.java)
        intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_IN_STATE)
        startActivityForResult(intent, Constance.REQUEST_CODE_SIGN_IN)
    }

    fun onClickSignUp(view: View) {
        val intent = Intent(this, SignInUpActivity::class.java)
        intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_UP_STATE)
        startActivityForResult(intent, Constance.REQUEST_CODE_SIGN_UP)

    }
}