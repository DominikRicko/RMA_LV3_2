package hr.dominikricko.rma_lv2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import hr.dominikricko.rma_lv2.databinding.ActivityAddPersonBinding

class AddPersonActivity : AppCompatActivity() {

    private lateinit var addPersonBinding: ActivityAddPersonBinding
    private lateinit var etDateBirth: EditText
    private lateinit var etDateDeath: EditText
    private lateinit var etName: EditText
    private lateinit var etDescription: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addPersonBinding = ActivityAddPersonBinding.inflate(layoutInflater)
        etName = addPersonBinding.etName
        etDescription = addPersonBinding.etDescription
        etDateBirth = addPersonBinding.etDateBirth
        etDateDeath = addPersonBinding.etDateDeath
        addPersonBinding.btnBrowseImage.setOnClickListener{ TODO("This needs a media/internet input for bitmap whatever, idk.")}
        addPersonBinding.btnAdd.setOnClickListener{ TODO("Needs a function")}

        setContentView(addPersonBinding.root)
    }
}