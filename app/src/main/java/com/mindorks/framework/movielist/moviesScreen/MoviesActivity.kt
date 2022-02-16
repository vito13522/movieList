package com.mindorks.framework.movielist.moviesScreen

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mindorks.framework.movielist.SingleMovie.MoviesDetailsActivity
import com.mindorks.framework.retrofitcoctail.R
import com.mindorks.framework.movielist.model.Movies
import com.mindorks.framework.movielist.remote.TheMovieDBInterfae
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MoviesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        Log.d("testLogs", "RegistrationActivity start registration")

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = GridLayoutManager(this, 2)

        // ArrayList of class ItemsViewModel
//        val data = ArrayList<ItemsViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
//        for (i in 1..20) {
//            data.add(ItemsViewModel(R.drawable.ic_launcher_background, "Item " + i))
//        }

        val apiInterface = TheMovieDBInterfae.create().getMovies("9f27579c00bf2cac2ad7b467e86c5105")


        apiInterface.enqueue(object : Callback<Movies>, CustomAdapter.ItemClickListener {
            override fun onResponse(
                call: Call<Movies>?,
                response: Response<Movies>?
            ) {
                Log.d("testLogs", "OnResponse Success ${response?.body()?.results}")

//                if(response?.body() != null)
//                    recyclerAdapter.setMovieListItems(response.body()!!)

                // This will pass the ArrayList to our Adapter
                val adapter = CustomAdapter(onItemClick(it) )
                viewModel.getMovies() ghlgl
                viewModel.moviesLiveData.observe(this@MoviesActivity) { list ->
                    list.asReversed()
                    adapter.setData(list)//
                }

                // Setting the Adapter with the recyclerview
                recyclerview.adapter = adapter

            }

            override fun onFailure(call: Call<Movies>?, t: Throwable?) {
                Log.d("testLogs", "OnResponse Success {${t?.message}")

            }

            override fun onItemClick(id: Int) {
                val intent = Intent(this@MoviesActivity, MoviesDetailsActivity::class.java)
                intent.putExtra("id", id)
                startActivity(intent)
            }
        })

    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finishAffinity()
    }
}

