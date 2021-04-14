package hr.dominikricko.rma_lv2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hr.dominikricko.rma_lv2.adapters.PersonAdapter
import hr.dominikricko.rma_lv2.databinding.ActivityMainBinding
import hr.dominikricko.rma_lv2.listeners.ShowRandomQuoteOnClick

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var recyclerAdapter : PersonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recyclerAdapter = PersonAdapter(ShowRandomQuoteOnClick)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        mainBinding.rvPeople.adapter = recyclerAdapter

        setContentView(mainBinding.root)
    }
}