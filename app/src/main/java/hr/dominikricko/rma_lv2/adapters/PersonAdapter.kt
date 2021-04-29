package hr.dominikricko.rma_lv2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hr.dominikricko.rma_lv2.R
import hr.dominikricko.rma_lv2.data.PeopleRepository
import hr.dominikricko.rma_lv2.listeners.OnPersonEditClickListener
import hr.dominikricko.rma_lv2.listeners.OnPersonViewClickListener
import hr.dominikricko.rma_lv2.listeners.RemovePersonClickListener
import hr.dominikricko.rma_lv2.observable.Observer

class PersonAdapter(
    private val clickListener: OnPersonViewClickListener,
    private val onPersonEditClickListener: OnPersonEditClickListener
    ) : Observer<Int>,
    RecyclerView.Adapter<PersonViewHolder>() {

    init{
        PeopleRepository.addObserver(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_person, parent, false)

        return PersonViewHolder(view, onPersonEditClickListener, RemovePersonClickListener)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {

        val person = PeopleRepository.people[position]
        holder.bind(person)
        holder.itemView.setOnClickListener { clickListener.onPersonClick(person) }

    }

    override fun getItemCount(): Int {
        return PeopleRepository.people.size
    }

    override fun notify(data: Int) {
        notifyItemRemoved(data)
    }

}