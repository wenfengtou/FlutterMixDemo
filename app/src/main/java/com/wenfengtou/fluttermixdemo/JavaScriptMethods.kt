package com.wenfengtou.fluttermixdemo

import android.content.Context
import android.webkit.JavascriptInterface
import android.widget.Toast

class JavaScriptMethods {

    private var  mContext: Context? = null

    constructor(context: Context) {
        this.mContext = context
    }

    @JavascriptInterface
    fun showToast(json:String) {
        Toast.makeText(mContext, json, Toast.LENGTH_LONG).show()
    }
}