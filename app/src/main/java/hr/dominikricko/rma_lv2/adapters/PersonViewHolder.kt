package hr.dominikricko.rma_lv2.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import hr.dominikricko.rma_lv2.R
import hr.dominikricko.rma_lv2.model.InspiringPerson
import hr.dominikricko.rma_lv2.databinding.ItemPersonBinding

class PersonViewHolder(private val personView : View) : RecyclerView.ViewHolder(personView) {
    fun bind(person : InspiringPerson){
        val personBinding = ItemPersonBinding.bind(personView)
        personBinding.tvName.text = person.name

        Glide.with(personView.context)
                .applyDefaultRequestOptions(
                        RequestOptions()
                                .placeholder(R.mipmap.ic_launcher_round))
                .load(person.imageUrl)
                .into(personBinding.ivPerson)

        personBinding.tvDates.text = if(person.dateOfDeath != null){
            "${person.dateOfBirth} - ${person.dateOfDeath}"
        }
        else{
            person.dateOfBirth
        }

        personBinding.tvDescription.text = person.description
    }
}