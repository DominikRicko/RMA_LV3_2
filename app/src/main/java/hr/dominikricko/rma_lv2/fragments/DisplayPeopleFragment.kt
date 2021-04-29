package hr.dominikricko.rma_lv2.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import hr.dominikricko.rma_lv2.adapters.PersonAdapter
import hr.dominikricko.rma_lv2.databinding.FragmentDisplayPeopleBinding
import hr.dominikricko.rma_lv2.listeners.ShowRandomQuoteOnClick

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DisplayPeopleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DisplayPeopleFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DisplayPeopleFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun createNewPerson() {

    }

}