package hr.dominikricko.rma_lv2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hr.dominikricko.rma_lv2.R
import hr.dominikricko.rma_lv2.data.PeopleRepository

class PersonAdapter() : RecyclerView.Adapter<PersonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_person, parent, false)
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = PeopleRepository.getAt(position)
        holder.bind(person)
    }

    override fun getItemCount(): Int {
        return PeopleRepository.people.size
    }
}