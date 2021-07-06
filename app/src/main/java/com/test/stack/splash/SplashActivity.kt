package com.test.stack.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.test.stack.AppPreferences
import com.test.stack.R
import com.test.stack.base.BaseActivity
import com.test.stack.home.HomeActivity
import javax.inject.Inject

/**
 *  Splash screen with launcher theme.
 */
class SplashActivity : BaseActivity() {

    @Inject
    lateinit var appPreferences: AppPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme_Launcher)
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        routeTo()
    }

    private fun routeTo() {
        Handler().postDelayed({
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, 1000)
    }
}