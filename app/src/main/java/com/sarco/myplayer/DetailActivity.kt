package com.sarco.myplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.sarco.myplayer.Media.*
import com.sarco.myplayer.databinding.ActivityDetailBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "DetailActivity:id"
    }

    private lateinit var mBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val id = intent.getIntExtra(EXTRA_ID, -1)
        getItemById(id)

    }

    private fun getItemById(id: Int){
         lifecycleScope.launch(Dispatchers.Main) {
           val result = withContext(Dispatchers.IO){
                MediaProvider.getItems().find { it.id == id }
            }
             result?.let {
                 supportActionBar?.title = it.title
                 with(mBinding){
                     mediaThumb.loadURL(it.url)
                     mediaVideoIndicator.visibility = when(it.type){
                         Type.PHOTO -> View.GONE
                         Type.VIDEO -> View.VISIBLE
                     }
                 }
             }


         }
    }
}