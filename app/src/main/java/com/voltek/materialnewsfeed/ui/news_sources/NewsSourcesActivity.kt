package com.voltek.materialnewsfeed.ui.news_sources

import android.os.Bundle
import com.voltek.materialnewsfeed.R
import com.voltek.materialnewsfeed.navigation.proxy.Command
import com.voltek.materialnewsfeed.ui.BaseActivity

class NewsSourcesActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generic)
        setupToolbar(displayHomeAsUpEnabled = true)
    }

    override fun executeCommand(command: Command): Boolean {
        return false
    }
}
