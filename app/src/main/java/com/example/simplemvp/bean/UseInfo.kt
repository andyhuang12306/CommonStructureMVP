package com.example.simplemvp.bean

import com.example.simplemvp.bean.BaseEntity

data class UseInfo(override var code: Int, override var status: Boolean, override var error: String, var name: String) : BaseEntity()