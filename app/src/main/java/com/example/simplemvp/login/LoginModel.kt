package com.example.simplemvp.login

import com.example.simplemvp.base.BaseModel
import com.example.simplemvp.bean.UseInfo

class LoginModel(p: LoginPresenter?) : BaseModel<LoginPresenter, LoginContact.Model>(p) {

    override fun getContract(): LoginContact.Model {
        return object :LoginContact.Model{
            override fun excuteLogin(name: String, pwd: String) {
                if(name!=null&&name=="Haha"&&pwd!=null&&pwd=="123"){
                    p?.contract?.dispatchCallBack(UseInfo(200, true, "", "haha"))
                }else{
                    p?.contract?.dispatchCallBack(null)
                }
            }

        }
    }

}