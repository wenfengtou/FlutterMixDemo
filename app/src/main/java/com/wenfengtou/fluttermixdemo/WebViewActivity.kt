package com.wenfengtou.fluttermixdemo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.*
import androidx.core.content.ContextCompat.startActivity

class WebViewActivity : AppCompatActivity() {

    /*
    private val mWebView:WebView by lazy {
        mWebView
    }
     */
    private lateinit var mWebView:WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        mWebView = findViewById(R.id.link_wv);
        setWebView()
    }

    var setWebView = {
        mWebView.settings.javaScriptEnabled = true
        mWebView.webViewClient = MyWebViewClient()
        mWebView.webChromeClient = MyWebChromeClient()
        mWebView.loadUrl("https://www.zhihu.com/")
    }

    inner  class MyWebViewClient:WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {

            return if(request?.url?.scheme?.startsWith("http")!! ||request?.url?.scheme?.startsWith("https")!!){
                //对http或者https协议的链接进行加载
                view!!.loadUrl(request.url.toString())
                true
            }else{
                //这里需要捕捉异常，因为如果没有安装相关的APP会有类找不到的异常
                try {
                    //启动对应协议的APP
                    //val intent = Intent(Intent.ACTION_VIEW, Uri.parse(request.url.toString()))
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(request.url.toString())))
                }catch (e:Exception){
                }
                true
            }
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
        }
    }

    private  class MyWebChromeClient:WebChromeClient() {

        override fun onJsConfirm(view: WebView?, url: String?, message: String?, result: JsResult?): Boolean {
            return super.onJsConfirm(view, url, message, result)
        }

        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            super.onProgressChanged(view, newProgress)
        }
    }
}