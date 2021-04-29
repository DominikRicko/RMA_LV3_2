package hr.dominikricko.rma_lv2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import hr.dominikricko.rma_lv2.adapters.PersonAdapter
import hr.dominikricko.rma_lv2.databinding.FragmentDisplayPeopleBinding
import hr.dominikricko.rma_lv2.listeners.OnAddPersonClickListener
import hr.dominikricko.rma_lv2.listeners.OnPersonEditClickListener
import hr.dominikricko.rma_lv2.listeners.ShowRandomQuoteOnClick

class DisplayPeopleFragment(
    private val addClickListener: OnAddPersonClickListener,
    private val editClickListener: OnPersonEditClickListener) : Fragment() {

    private lateinit var binding: FragmentDisplayPeopleBinding
    private lateinit var recyclerAdapter: PersonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerAdapter = PersonAdapter(ShowRandomQuoteOnClick, editClickListener)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDisplayPeopleBinding.inflate(layoutInflater)
        binding.rvPeople.adapter = recyclerAdapter
        binding.rvPeople.layoutManager = LinearLayoutManager(context)
        binding.btnAddNewPerson.setOnClickListener { addClickListener.onClickAddPerson() }

        return binding.root;
    }




}