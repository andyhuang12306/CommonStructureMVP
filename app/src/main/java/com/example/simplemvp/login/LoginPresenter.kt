package com.example.simplemvp.login

import com.example.simplemvp.base.BasePresenter
import com.example.simplemvp.bean.UseInfo

class LoginPresenter: BasePresenter<LoginModel, LoginActivity, LoginContact.Presenter<UseInfo>>() {


    override fun getContract(): LoginContact.Presenter<UseInfo> {

        return object :LoginContact.Presenter<UseInfo>{
            override fun dispatchLogin(name: String, pwd: String) {
                try {
                    model?.contract?.excuteLogin(name, pwd)
                }catch (e: Exception){
                    e.printStackTrace()
                    view?.contract?.callback(null)
                }

            }

            override fun dispatchCallBack(t: UseInfo?) {
                view?.contract?.callback(t)
            }

        }

    }

    override fun getModel(): LoginModel {
        return LoginModel(this)
    }

}