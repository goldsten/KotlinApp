package com.example.kotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.kotlinapp.DB.DBManager
import com.example.kotlinapp.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
	private lateinit var binding: ActivityEditBinding
	private var launcher: ActivityResultLauncher<Intent>? = null
	var tempImageURI = "empty"

	// создаем менеджер БД (context)
	val managerDB = DBManager(this)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityEditBinding.inflate(layoutInflater)
		setContentView(binding.root)

		binding.apply {
			fbAddImag.setOnClickListener {
				imageLayout.visibility = View.VISIBLE
				fbAddImag.visibility = View.GONE
			}
			btnDeleteImage.setOnClickListener {
				imageLayout.visibility = View.GONE
				fbAddImag.visibility = View.VISIBLE
			}
			btnSelectImage.setOnClickListener {
				// вызывает приложение для выбора картинок ACTION_PICK
				val intent = Intent(Intent.ACTION_PICK)
				intent.type = "image/*"
				launcher?.launch(intent)

			}
			fbSave.setOnClickListener {
				val title = edTitle.text.toString()
				val notes = edNotes.text.toString()
				if (title != "" && notes != ""){
					// записываем в БД
					managerDB.isertToDB(title, notes, tempImageURI)
					Toast.makeText(this@EditActivity,"Сохранилось", Toast.LENGTH_SHORT).show()
					finish()
				} else {
					edTitle.error = "Надо заполнить"
					edNotes.error = "Надо заполнить"
				}
			}
		}
		// регистрируем launcher на получение данных с activity2
		launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
			// проверяем если ==
			if (it.resultCode == RESULT_OK){
				// data - получаем данные
				val data = it?.data?.data
				// вставляем путь к картинке
				binding.imageView.setImageURI(data)

				tempImageURI = data.toString()
			}
		}
	}
	override fun onResume() {
		super.onResume()
		managerDB.openDB()
	}

	override fun onDestroy() {
		super.onDestroy()
		managerDB.closeDB()
	}
}
