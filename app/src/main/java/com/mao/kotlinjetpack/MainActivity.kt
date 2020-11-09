package com.mao.kotlinjetpack

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
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
import com.mao.kotlinjetpack.entity.User
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
            Glide.with(this@MainActivity).load("file:///android_asset/bless.gif").into(gif!!)
            Glide.with(this@MainActivity).load(user.avatar_url)
                .apply(RequestOptions.circleCropTransform())
                .into(image!!)
            username.text = name
            this@MainActivity.company.text = company
            website.text = blog
            image!!.setOnClickListener { gotoImagePreviewActivity(user) }
        }
    }

    private fun gotoImagePreviewActivity(user: User) {
        val intent = Intent(this, ImagePreviewActivity::class.java)
        intent.putExtra(EXTRA_PHOTO, user.avatar_url)
        startActivity(intent)
    }

    override fun onStop() {
        super.onStop()
        requestQueue.cancelAll(TAG)
    }
}