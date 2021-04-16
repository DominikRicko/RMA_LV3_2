package hr.dominikricko.rma_lv2.activities

import android.content.Intent
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

        mainBinding.btnAddNewPerson.setOnClickListener { createNewPerson() }

        setContentView(mainBinding.root)
    }

    private fun createNewPerson(){
        val newPersonIntent = Intent(this, AddPersonActivity::class.java)
        startActivity(newPersonIntent)
    }

}