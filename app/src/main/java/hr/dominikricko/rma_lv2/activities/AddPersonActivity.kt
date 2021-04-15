package hr.dominikricko.rma_lv2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import hr.dominikricko.rma_lv2.adapters.QuoteAdapter
import hr.dominikricko.rma_lv2.data.InspiringPerson
import hr.dominikricko.rma_lv2.data.PeopleRepository
import hr.dominikricko.rma_lv2.databinding.ActivityAddPersonBinding

class AddPersonActivity : AppCompatActivity() {

    private lateinit var addPersonBinding: ActivityAddPersonBinding
    private lateinit var etDateBirth: EditText
    private lateinit var etDateDeath: EditText
    private lateinit var etName: EditText
    private lateinit var etDescription: EditText
    private lateinit var recyclerView: RecyclerView
    private val quoteRecyclerViewAdapter : QuoteAdapter = QuoteAdapter()

    companion object{
        const val PICK_IMAGE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addPersonBinding = ActivityAddPersonBinding.inflate(layoutInflater)
        etName = addPersonBinding.etName
        etDescription = addPersonBinding.etDescription
        etDateBirth = addPersonBinding.etDateBirth
        etDateDeath = addPersonBinding.etDateDeath
        recyclerView = addPersonBinding.rvQuotes

        addPersonBinding.btnBrowseImage.setOnClickListener{ openGetImageDialog() }
        addPersonBinding.btnAdd.setOnClickListener{ addNewPerson()}
        recyclerView.adapter = quoteRecyclerViewAdapter

        setContentView(addPersonBinding.root)
    }

    private fun openGetImageDialog(){
        val getImageIntent = Intent()
        getImageIntent.type = "image/*"
        getImageIntent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select picture"), PICK_IMAGE)
    }

    private fun clearForm(){
        etName.text.clear()
        etDescription.text.clear()
        etDateDeath.text.clear()
        etDateBirth.text.clear()
        quoteRecyclerViewAdapter.quotes.clear()
    }

    private fun addNewPerson(){

        var error = false
        if(etName.text.isNullOrBlank()) error = true
        if(etDescription.text.isNullOrBlank()) error = true
        if(etDateBirth.text.isNullOrBlank()) error = true
        if(quoteRecyclerViewAdapter.quotes.size > 0) error = true

        if(error) return
        
        clearForm()
    }
}