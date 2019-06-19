package com.example.simplemvp.login

import com.example.simplemvp.bean.BaseEntity

interface LoginContact{

    interface Model{

        @Throws(Exception::class)
        fun excuteLogin (name: String, pwd: String)
    }

    interface Presenter<T :BaseEntity>{
        fun dispatchLogin(name:String, pwd:String)
        fun dispatchCallBack(t: T?)
    }

    interface View<T: BaseEntity>{
        fun callback(t: T?)
    }

}
