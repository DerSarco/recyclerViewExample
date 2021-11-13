package com.sarco.myplayer

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.sarco.myplayer.Media.*
import com.sarco.myplayer.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import java.util.logging.Filter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val adapter: MediaAdapter =  MediaAdapter() {
        startActivity<DetailActivity>(DetailActivity.EXTRA_ID to it.id)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.adapter = adapter
        updateItems()

//        val textView: TextView = TextView(this).apply2 {
//            text = "Hello"
//            hint = "GoodBye"
//            textSize = 20f
//        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun updateItems(filter: FilterOp = FilterOp.FilterNone){
        lifecycleScope.launch {
            binding.progress.visibility = View.VISIBLE
            adapter.mediaList = withContext(Dispatchers.IO) {
                getFilteredItems(filter)
            }
            binding.progress.visibility = View.GONE
        }
    }

    private fun getFilteredItems(filter: FilterOp, ): List<Media>{
        return MediaProvider.getItems().let { media ->
            when(filter){
                FilterOp.FilterNone -> media
                is FilterOp.FilterByType -> media.filter { it.type == filter.type }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        val newAdapter : MediaAdapter = when(item.itemId){
//            R.id.filter_all ->  MediaAdapter(getItems()) { toast(it.title) }
//            R.id.filter_photos ->
//                MediaAdapter(getItems().filter { it.type == Media.Type.PHOTO }) { toast(it.title) }
//            R.id.filter_videos ->
//                MediaAdapter(getItems().filter { it.type == Media.Type.VIDEO }) { toast(it.title) }
//            else -> MediaAdapter(emptyList()) {toast(it.title)}
//        }
//        binding.recycler.adapter = newAdapter

        val filter = when(item.itemId){
            R.id.filter_photos -> FilterOp.FilterByType(Type.PHOTO)
            R.id.filter_videos -> FilterOp.FilterByType(Type.VIDEO)
            R.id.filter_all -> FilterOp.FilterNone
            else -> FilterOp.FilterNone
        }
        updateItems(filter)
        return super.onOptionsItemSelected(item)
    }

}



fun <T> T.apply2(body: T.() -> Unit): T{
    this.body()
    return this
}


//fun <T, U> T.run2(body: T.() -> U): U{
//    return this.body()
//}


//fun <T, U> T.let2(body: (T) -> U): U{
//    return body(this)
//}

//fun <T, U> with2(receiver: T, body: T.() -> U): U{
//    return receiver.body()
//}

//fun <T> T.also2(body: (T) -> Unit): T{
//    body(this)
//    return this
//}

