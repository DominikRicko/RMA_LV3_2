package hr.dominikricko.rma_lv2.activities

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import hr.dominikricko.rma_lv2.R
import hr.dominikricko.rma_lv2.adapters.QuoteAdapter
import hr.dominikricko.rma_lv2.context.ApplicationContext
import hr.dominikricko.rma_lv2.data.PeopleRepository
import hr.dominikricko.rma_lv2.databinding.ActivityAddPersonBinding
import hr.dominikricko.rma_lv2.model.InspiringPerson

class AddPersonActivity : AppCompatActivity() {

    private lateinit var addPersonBinding: ActivityAddPersonBinding
    private lateinit var quoteRecyclerViewAdapter: QuoteAdapter
    private var imageUri: String? = null

    companion object {
        const val PICK_IMAGE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        quoteRecyclerViewAdapter = QuoteAdapter()

        addPersonBinding = ActivityAddPersonBinding.inflate(layoutInflater)
        addPersonBinding.btnBrowseImage.setOnClickListener { openGetImageDialog() }
        addPersonBinding.btnAdd.setOnClickListener { addNewPerson() }
        addPersonBinding.btnAddQuote.setOnClickListener { addQuote() }
        addPersonBinding.rvQuotes.adapter = quoteRecyclerViewAdapter
        addPersonBinding.rvQuotes.layoutManager = LinearLayoutManager(this)

        setContentView(addPersonBinding.root)
    }

    private fun addQuote() {
        if (addPersonBinding.etQuote.text.isNullOrBlank()) return

        quoteRecyclerViewAdapter.quotes.add(addPersonBinding.etQuote.text.toString())
        addPersonBinding.etQuote.text.clear()
    }

    private fun openGetImageDialog() {

        val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        startActivityForResult(gallery, PICK_IMAGE)

    }

    private fun isFormComplete(): Boolean {
        return !(addPersonBinding.etName.text.isNullOrBlank()
                || addPersonBinding.etDateBirth.text.isNullOrBlank()
                || addPersonBinding.etDescription.text.isNullOrBlank()
                || imageUri == null
                || quoteRecyclerViewAdapter.quotes.size == 0
                )
    }

    private fun addNewPerson() {

        if (isFormComplete()) {

            val birthDate = addPersonBinding.etDateBirth.text.toString()
            val deathDate = if (!addPersonBinding.etDateDeath.text.isNullOrBlank())
                addPersonBinding.etDateDeath.text.toString()
            else
                null

            val person = InspiringPerson(
                addPersonBinding.etName.text.toString(),
                imageUri,
                birthDate,
                deathDate,
                addPersonBinding.etDescription.text.toString()
            )

            quoteRecyclerViewAdapter.quotes.forEach { person.addQuote(it) }

            PeopleRepository.addNewPerson(person)
            finish()

        } else
            Toast.makeText(
                ApplicationContext.context,
                getString(R.string.add_person_error),
                Toast.LENGTH_SHORT
            ).show()


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {

            imageUri = data?.data?.path
            Toast.makeText(ApplicationContext.context, imageUri, Toast.LENGTH_SHORT).show()

        }

    }

}