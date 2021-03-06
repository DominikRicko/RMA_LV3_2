package hr.dominikricko.rma_lv2.adapters

import android.net.Uri
import android.os.Environment
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import hr.dominikricko.rma_lv2.R
import hr.dominikricko.rma_lv2.databinding.ItemPersonBinding
import hr.dominikricko.rma_lv2.listeners.OnPersonEditClickListener
import hr.dominikricko.rma_lv2.listeners.OnPersonRemoveClickListener
import hr.dominikricko.rma_lv2.model.InspiringPerson
import java.io.File

class PersonViewHolder(
    private val personView: View,
    private val onPersonEditClickListener: OnPersonEditClickListener,
    private val onPersonRemoveClickListener: OnPersonRemoveClickListener
    ) : RecyclerView.ViewHolder(personView) {

    fun bind(person: InspiringPerson) {
        val personBinding = ItemPersonBinding.bind(personView)
        personBinding.tvName.text = person.name

        @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
        Glide.with(personView.context)
            .applyDefaultRequestOptions(
                RequestOptions()
                    .placeholder(R.mipmap.ic_launcher_round)
            )
            .load(
                if (person.imageUrl != null && person.imageUrl!!.startsWith('/'))
                    Uri.parse(Environment.getExternalStorageDirectory().toString()
                            + person.imageUrl)
                else
                    person.imageUrl
            )
            .into(personBinding.ivPerson)

        personBinding.tvDates.text = if (person.dateOfDeath != null) {
            "${person.dateOfBirth} - ${person.dateOfDeath}"
        } else {
            person.dateOfBirth
        }

        personBinding.tvDescription.text = person.description

        personBinding.btnEdit.setOnClickListener { onPersonEditClickListener.onClickEditPerson(person) }
        personBinding.btnRemove.setOnClickListener { onPersonRemoveClickListener.removePerson(person)}
    }
}