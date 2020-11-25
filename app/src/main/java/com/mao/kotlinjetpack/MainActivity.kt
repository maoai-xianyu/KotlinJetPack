package com.mao.kotlinjetpack

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.Gson
import com.mao.kotlinjetpack.chapter.c04.WebActivity
import com.mao.kotlinjetpack.entity.User
import com.mao.kotlinjetpack.entity.applySelf
import com.mao.kotlinjetpack.entity.applySelfS
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "Main"
    private val requestQueue: RequestQueue by lazy {
        Volley.newRequestQueue(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        display(CACHE_RESPONSE)
        requestOnlineInfo()
    }

    private fun requestOnlineInfo() {
        val url = "https://api.github.com/users/JakeWharton"

        /*val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            object : Response.Listener<String> {
                override fun onResponse(response: String?) {
                    display(response)
                }

            },
            object : Response.ErrorListener {
                override fun onErrorResponse(error: VolleyError) {
                    Toast.makeText(this@MainActivity, error.message, Toast.LENGTH_SHORT)
                        .show()
                }
            }
        )*/

        // 转 lambda
        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            Response.Listener { response -> display(response) },
            Response.ErrorListener { error ->
                Toast.makeText(this@MainActivity, error.message, Toast.LENGTH_SHORT)
                    .show()
            })
        stringRequest.tag = TAG
        requestQueue.add(stringRequest)
    }

    private fun display(response: String?) {
        if (TextUtils.isEmpty(response)) {
            return
        }

        if (response.isNullOrBlank()) {
            return
        }
        val gson = Gson()
        val user =
            gson.fromJson(
                response,
                User::class.java
            )

        user?.apply {
            Glide.with(this@MainActivity).load("file:///android_asset/get_card.gif").into(gif_1!!)
            Glide.with(this@MainActivity).load("file:///android_asset/bless.gif").into(gif!!)
            Glide.with(this@MainActivity).load(user.avatar_url)
                .apply(RequestOptions.circleCropTransform())
                .into(image!!)
            username.text = name
            this@MainActivity.company.text = company
            website.text = blog
            image!!.setOnClickListener { gotoImagePreviewActivity(user) }
            gif.setOnClickListener { gotoWebActivity() }
        }


        // user 自定义扩展函数实现 apply

        /*user.applySelf {
            Glide.with(this@MainActivity).load("file:///android_asset/bless.gif").into(gif!!)
            Glide.with(this@MainActivity).load(user.avatar_url)
                .apply(RequestOptions.circleCropTransform())
                .into(image!!)
            username.text = it.name
            this@MainActivity.company.text = it.company
            website.text = it.blog
            image!!.setOnClickListener { gotoImagePreviewActivity(user) }
        }*/

        /*user.applySelfS {

            Glide.with(this@MainActivity).load("file:///android_asset/bless.gif").into(gif!!)
            Glide.with(this@MainActivity).load(user.avatar_url)
                .apply(RequestOptions.circleCropTransform())
                .into(image!!)
            username.text = name
            this@MainActivity.company.text = company
            website.text = blog
            image!!.setOnClickListener { gotoImagePreviewActivity(user) }

        }*/
        //public void setOnClickListener(OnClickListener l)
        // 转 koltin
        // fun setOnClickListener(l: (View) -> Unit)
        //// 实际上是这样：
        //fun setOnClickListener(l: ((View!) -> Unit)?)

        // 写法1 object 关键字定义了一个匿名内部类：
        username.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

            }
        })

        // 写法2 上面的 View.OnClickListener 被称为： SAM Constructor—— SAM 构造器，
        // 它是编译器为我们生成的。Kotlin 允许我们通过这种方式来定义 Lambda 表达式
        username.setOnClickListener(View.OnClickListener { view: View? ->
            {
            }
        })

        // 写法3 由于 Kotlin 的 Lambda 表达式是不需要 SAM Constructor的，所以它也可以被删掉
        username.setOnClickListener({ view: View? ->
            {
            }
        })

        // 写法4 由于 Kotlin 支持类型推导，所以 View? 可以被删掉：
        username.setOnClickListener({ view ->
            {
            }
        })

        // 写法5 当 Kotlin Lambda 表达式只有一个参数的时候，它可以被写成 it。
        username.setOnClickListener({ it ->
            {
            }
        })

        // 写法6 Kotlin Lambda 的 it 是可以被省略的：
        username.setOnClickListener({
        })


        // 写法7 当 Kotlin Lambda 作为函数的最后一个参数时，Lambda 可以被挪到外面：
        username.setOnClickListener() {

        }
        // 写法8 当 Kotlin 只有一个 Lambda 作为函数参数时，() 可以被省略：
        username.setOnClickListener {

        }


    }

    private fun gotoImagePreviewActivity(user: User) {
        val intent = Intent(this, ImagePreviewActivity::class.java)
        intent.putExtra(EXTRA_PHOTO, user.avatar_url)
        startActivity(intent)
    }


    private fun gotoWebActivity() {
        val intent = Intent(this, WebActivity::class.java)
        startActivity(intent)
    }


    override fun onStop() {
        super.onStop()
        requestQueue.cancelAll(TAG)
    }
}