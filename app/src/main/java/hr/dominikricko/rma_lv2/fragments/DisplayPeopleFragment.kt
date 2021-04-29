package hr.dominikricko.rma_lv2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import hr.dominikricko.rma_lv2.adapters.PersonAdapter
import hr.dominikricko.rma_lv2.databinding.FragmentDisplayPeopleBinding
import hr.dominikricko.rma_lv2.listeners.ShowRandomQuoteOnClick

class DisplayPeopleFragment : Fragment() {

    private lateinit var binding: FragmentDisplayPeopleBinding
    private lateinit var recyclerAdapter: PersonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerAdapter = PersonAdapter(ShowRandomQuoteOnClick)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDisplayPeopleBinding.inflate(layoutInflater)
        binding.rvPeople.adapter = recyclerAdapter
        binding.rvPeople.layoutManager = LinearLayoutManager(context)
        binding.btnAddNewPerson.setOnClickListener { createNewPerson() }

        return binding.root;
    }

    private fun createNewPerson() {

    }

}