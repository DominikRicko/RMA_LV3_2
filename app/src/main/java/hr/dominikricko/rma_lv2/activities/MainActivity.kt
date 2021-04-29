package hr.dominikricko.rma_lv2.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hr.dominikricko.rma_lv2.R
import hr.dominikricko.rma_lv2.data.DefaultPeopleAdded
import hr.dominikricko.rma_lv2.databinding.ActivityMainBinding
import hr.dominikricko.rma_lv2.fragments.DisplayPeopleFragment

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)

        if( savedInstanceState == null){
            DefaultPeopleAdded.init()
            supportFragmentManager.beginTransaction()
                .add(R.id.fl_fragmentContainer, DisplayPeopleFragment())
                .commit()
        }

        setContentView(mainBinding.root)
    }

}