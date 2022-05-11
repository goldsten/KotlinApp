package com.example.kotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.net.toUri
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


		// ВСЕ ЗАПИСЫВАТЬ ТУТ !!!
		binding.apply {

			// принимаем intent
			// записываем интент который получаем
			val i = intent
			if(i != null){
				if (i.getStringExtra(IntentConstance.I_TITLE_KEY) != null){

					fbAddImag.visibility = View.GONE

					edTitle.setText(i.getStringExtra(IntentConstance.I_TITLE_KEY))
					edNotes.setText(i.getStringExtra(IntentConstance.I_NOTE_KEY))
					if (i.getStringExtra(IntentConstance.I_URI_KEY) != "empty"){
						imageLayout.visibility = View.VISIBLE

//						imageView.setImageURI(Uri.parse(i.getStringExtra(IntentConstance.I_URI_KEY)))
						imageView.setImageURI(i.getStringExtra(IntentConstance.I_URI_KEY)!!.toUri())

						btnDeleteImage.visibility = View.GONE
						btnSelectImage.visibility = View.GONE
					}
				}
			}


			fbAddImag.setOnClickListener {
				imageLayout.visibility = View.VISIBLE
				fbAddImag.visibility = View.GONE
			}
			btnDeleteImage.setOnClickListener {
				imageLayout.visibility = View.GONE
				fbAddImag.visibility = View.VISIBLE
			}
			btnSelectImage.setOnClickListener {
				// вызывает приложение для выбора картинок ACTION_PICK - верменная ссылка
				//
				val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
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
			// регистрируем launcher на получение данных с activity2
			launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
				// проверяем если ==
				if (it.resultCode == RESULT_OK){
					// data - получаем данные
					val data = it?.data?.data
					// вставляем путь к картинке
					imageView.setImageURI(data)
					tempImageURI = data.toString()
					/*
						FLAG_GRANT_READ_URI_PERMISSION дает разрешение для считывания ссылки картинки
						contentResolver - Этот класс предоставляет приложениям доступ к модели содержимого.
						Берет постоянное разрешение URI, которое было предложено. После получения предоставленное разрешение будет запоминаться при перезагрузке устройства.
						public void takePersistableUriPermission (Uri uri, int modeFlags)
					*/
					it.data?.data?.let {it1 -> contentResolver.takePersistableUriPermission(it1, Intent.FLAG_GRANT_READ_URI_PERMISSION)}
				}
			}

		}// *----BINDING
	}// *----ONCREATE

	override fun onResume() { // ОТКРЫТИЕ БД
		super.onResume()
		managerDB.openDB()}
	override fun onDestroy() {// ЗАКРЫТИЕ БД
		super.onDestroy()
		managerDB.closeDB()}
}// *----CLASS



