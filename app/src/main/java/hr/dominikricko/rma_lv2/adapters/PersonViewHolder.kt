package hr.dominikricko.rma_lv2.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import hr.dominikricko.rma_lv2.data.InspiringPerson
import hr.dominikricko.rma_lv2.databinding.ItemPersonBinding

class PersonViewHolder(private val personView : View) : RecyclerView.ViewHolder(personView) {
    fun bind(person : InspiringPerson){
        val personBinding = ItemPersonBinding.bind(personView)
        personBinding.ivPerson.setImageBitmap(person.image)
        personBinding.tvName.text = person.name

        personBinding.tvDates.text = if(person.dateOfDeath != null){
            "${person.dateOfBirth} - ${person.dateOfDeath}"
        }
        else{
            "${person.dateOfBirth}"
        }

        personBinding.tvDescription.text = person.description
    }
}