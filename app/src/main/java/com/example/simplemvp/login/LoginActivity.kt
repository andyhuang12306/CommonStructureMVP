package com.example.simplemvp.login

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.simplemvp.R
import com.example.simplemvp.base.BaseView
import com.example.simplemvp.bean.UseInfo

class LoginActivity : BaseView<LoginPresenter, LoginContact.View<UseInfo>>() {



    override fun getPresenter(): LoginPresenter {
        if(null == p){
            p=LoginPresenter()
        }
        return p
    }

    override fun getContract(): LoginContact.View<UseInfo> {
        return object:LoginContact.View<UseInfo>{
            override fun callback(t: UseInfo?) {
                if(t!=null){
                    Toast.makeText(applicationContext, "登录成功", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(applicationContext, "登录失败", Toast.LENGTH_SHORT).show()
                }

            }

        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        val nameET = findViewById<EditText>(R.id.name_et)
        val pwdET=findViewById<EditText>(R.id.pwd_et)
        findViewById<TextView>(R.id.tv).setOnClickListener {
            val name = nameET.text.trim().toString()
            val pwd = pwdET.text.trim().toString()
            p?.contract?.dispatchLogin(name, pwd)
        }
    }
}
