package hr.dominikricko.rma_lv2.fragments

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import hr.dominikricko.rma_lv2.R
import hr.dominikricko.rma_lv2.activities.AddPersonActivity
import hr.dominikricko.rma_lv2.adapters.QuoteAdapter
import hr.dominikricko.rma_lv2.context.ApplicationContext
import hr.dominikricko.rma_lv2.data.PeopleRepository
import hr.dominikricko.rma_lv2.data.TemporaryQuoteRepository
import hr.dominikricko.rma_lv2.databinding.FragmentEditPersonBinding
import hr.dominikricko.rma_lv2.model.InspiringPerson

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EditPersonFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditPersonFragment : Fragment() {

    companion object{
        const val LOAD_PERSON = "LOAD"
        const val LOAD_IMAGE = 1
    }

    private lateinit var recyclerAdapter : QuoteAdapter
    private lateinit var binding : FragmentEditPersonBinding
    private var imageUri: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerAdapter = QuoteAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentEditPersonBinding.inflate(inflater, container, false)

        binding.rvQuotes.adapter = recyclerAdapter
        binding.rvQuotes.layoutManager = LinearLayoutManager(context)

        binding.btnAdd.setOnClickListener { addNewPerson() }
        binding.btnAddQuote.setOnClickListener { addNewQuote() }
        binding.btnBrowseImage.setOnClickListener { openGetImageDialog() }

        if(arguments != null){
            arguments!!.let {
                val person = it.getSerializable(LOAD_PERSON) as InspiringPerson
                binding.etName.setText(person.name)
                binding.etDescription.setText(person.description)
                binding.etDateBirth.setText(person.dateOfBirth)
                binding.etDateDeath.setText(person.dateOfDeath)
                person.quotes.forEach { TemporaryQuoteRepository.addQuote(it) }

            }

            recyclerAdapter.notifyDataSetChanged()

        }

        return binding.root
    }

    private fun addNewPerson() {

        if (isFormComplete()) {

            val birthDate = binding.etDateBirth.text.toString()
            val deathDate = if (!binding.etDateDeath.text.isNullOrBlank())
                binding.etDateDeath.text.toString()
            else
                null

            val person = InspiringPerson(
                binding.etName.text.toString(),
                imageUri,
                birthDate,
                deathDate,
                binding.etDescription.text.toString()
            )

            TemporaryQuoteRepository.quotes.forEach { person.addQuote(it) }
            TemporaryQuoteRepository.clear()
            PeopleRepository.addNewPerson(person)

            activity?.supportFragmentManager?.popBackStack()

        } else
            Toast.makeText(
                ApplicationContext.context,
                getString(R.string.add_person_error),
                Toast.LENGTH_SHORT
            ).show()

    }

    private fun isFormComplete(): Boolean {
        return !(binding.etName.text.isNullOrBlank()
                || binding.etDateBirth.text.isNullOrBlank()
                || binding.etDescription.text.isNullOrBlank()
                || imageUri == null
                || TemporaryQuoteRepository.quotes.isEmpty()
                )
    }

    private fun addNewQuote() {
        if (binding.etQuote.text.isNullOrBlank()) return

        TemporaryQuoteRepository.addQuote(binding.etQuote.text.toString())
        binding.etQuote.text.clear()
    }

    private fun openGetImageDialog() {

        val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        startActivityForResult(gallery, LOAD_IMAGE)

    }

}