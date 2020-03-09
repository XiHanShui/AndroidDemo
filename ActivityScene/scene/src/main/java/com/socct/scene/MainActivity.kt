package com.socct.scene

import android.os.Bundle
import android.transition.Scene
import android.transition.TransitionManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.scene1.fl

class MainActivity : AppCompatActivity() {

    private var i = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val scene = Scene(fl, scene1)
        val scene2 = Scene.getSceneForLayout(fl, R.layout.scene1, this)
        btn.setOnClickListener {
            if (!i) {

                TransitionManager.go(scene2)
            } else {
                TransitionManager.go(scene)
            }
            i=!i
        }
    }
}
