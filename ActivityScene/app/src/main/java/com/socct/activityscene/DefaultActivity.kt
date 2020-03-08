package com.socct.activityscene

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.ViewCompat


import kotlinx.android.synthetic.main.item.*

class DefaultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_default)
        ViewCompat.setTransitionName(iv, IMG)
        ViewCompat.setTransitionName(tv, TXT)
    }

    companion object {
        const val IMG = "detail:img"
        const val TXT = "detail:txt"

    }
}
