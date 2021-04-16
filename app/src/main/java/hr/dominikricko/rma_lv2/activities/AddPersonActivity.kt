package hr.dominikricko.rma_lv2.activities

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import hr.dominikricko.rma_lv2.adapters.QuoteAdapter
import hr.dominikricko.rma_lv2.context.ApplicationContext
import hr.dominikricko.rma_lv2.data.PeopleRepository
import hr.dominikricko.rma_lv2.databinding.ActivityAddPersonBinding
import hr.dominikricko.rma_lv2.model.InspiringPerson
import java.util.*

class AddPersonActivity : AppCompatActivity(){

    private lateinit var addPersonBinding: ActivityAddPersonBinding
    private lateinit var etDateBirth: EditText
    private lateinit var etDateDeath: EditText
    private lateinit var etName: EditText
    private lateinit var etDescription: EditText
    private lateinit var etQuote: EditText
    private lateinit var recyclerView: RecyclerView
    private lateinit var imageUrl: String
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
        etQuote = addPersonBinding.etQuote
        recyclerView = addPersonBinding.rvQuotes

        addPersonBinding.btnBrowseImage.setOnClickListener{ openGetImageDialog() }
        addPersonBinding.btnAdd.setOnClickListener{ addNewPerson()}
        addPersonBinding.btnAddQuote.setOnClickListener { addQuote() }
        recyclerView.adapter = quoteRecyclerViewAdapter

        setContentView(addPersonBinding.root)
    }

    private fun addQuote() {
        if(etQuote.text.isNullOrBlank()) return
        quoteRecyclerViewAdapter.quotes.add(etQuote.text.toString())
        etQuote.text.clear()
    }

    private fun openGetImageDialog(){

        val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        startActivityForResult(gallery, PICK_IMAGE)

    }

    private fun clearForm(){
        etName.text.clear()
        etDescription.text.clear()
        etDateDeath.text.clear()
        etDateBirth.text.clear()
        quoteRecyclerViewAdapter.quotes.clear()
    }

    private fun isFormComplete(): Boolean{
        return !(etName.text.isNullOrBlank()
                || etDateBirth.text.isNullOrBlank()
                || etDescription.text.isNullOrBlank()
                || quoteRecyclerViewAdapter.quotes.size > 0
                )
    }

    private fun addNewPerson(){

        if(isFormComplete()){

            val birthDate = etDateBirth.text.toString()
            val deathDate = if(!etDateDeath.text.isNullOrBlank())
                etDateDeath.text.toString()
            else
                null

            PeopleRepository.addNewPerson(
                    InspiringPerson(
                            etName.text.toString(),
                            imageUrl,
                            birthDate,
                            deathDate,
                            etDescription.text.toString()
                    )
            )
            clearForm()
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {

            imageUrl = data?.data.toString()
            Toast.makeText(ApplicationContext.context, imageUrl,Toast.LENGTH_SHORT).show()

        }

    }

}