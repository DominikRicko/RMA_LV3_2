package hr.dominikricko.rma_lv2.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hr.dominikricko.rma_lv2.R
import hr.dominikricko.rma_lv2.data.DefaultPeopleAdded
import hr.dominikricko.rma_lv2.databinding.ActivityMainBinding
import hr.dominikricko.rma_lv2.fragments.DisplayPeopleFragment
import hr.dominikricko.rma_lv2.fragments.EditPersonFragment
import hr.dominikricko.rma_lv2.listeners.OnAddPersonClickListener
import hr.dominikricko.rma_lv2.listeners.OnPersonEditClickListener
import hr.dominikricko.rma_lv2.model.InspiringPerson

class MainActivity : AppCompatActivity(), OnPersonEditClickListener, OnAddPersonClickListener {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)

        if( savedInstanceState == null){
            DefaultPeopleAdded.init()
            supportFragmentManager.beginTransaction()
                .add(R.id.fl_fragmentContainer, DisplayPeopleFragment(this, this))
                .commit()
        }

        setContentView(mainBinding.root)
    }

    override fun onClickEditPerson(person: InspiringPerson) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_fragmentContainer, EditPersonFragment.create(person))
            .addToBackStack(null)
            .commit()
    }

    override fun onClickAddPerson() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_fragmentContainer, EditPersonFragment())
            .addToBackStack(null)
            .commit()
    }

}