package com.example.kotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapp.DB.DBManager
import com.example.kotlinapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding
	// создаем менеджер БД (context)
	val managerDB = DBManager(this)
	// передаем context
	val Adapter = rcAdapter(ArrayList(), this)

	fun Message(message:String){
		return Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
	}

	override fun onCreate(s: Bundle?) {
		super.onCreate(s)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		init()
		initSearch()

		binding.fbNew.setOnClickListener {
			// создаем переход в editActivity
			val i = Intent(this, EditActivity::class.java)
			startActivity(i)
		}
	}

	override fun onResume() {
		super.onResume()
		managerDB.openDB()
		init()
		fillAdapter()
	}
	override fun onDestroy() {
		super.onDestroy()
		managerDB.closeDB()
	}

	// инициализация адаптера
	fun init(){
		// if (){}
		// LinearLayoutManager(this) - элементы будут распологаться по вертикали
		binding.rcView.layoutManager = LinearLayoutManager(this)

		val swipeHalper = getSwipeManager()
		// указываем какой куснсдук мшуц присоединять
		swipeHalper.attachToRecyclerView(binding.rcView)

		binding.rcView.adapter = Adapter
	}
	//
	fun fillAdapter(){
		val list = managerDB.readDBData("")
		// считываем с БД, передаем в Adapter и обновляем список
		Adapter.updateAdapter(list)
		if(list.size > 0) {
			binding.tvNoElements.visibility = View.GONE
		} else {
			binding.tvNoElements.visibility = View.VISIBLE
		}
	}
	// SEARCH
	private fun initSearch(){
		// слушатель замечает любые изменения в searchView
		binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
			// поиск по нажатию кнопки
			override fun onQueryTextSubmit(query : String?) : Boolean {return true}
			// поиск по вводу символов
			override fun onQueryTextChange(newText : String?) : Boolean {
				// обновляем адаптер
				val list = managerDB.readDBData(newText!!)
				// считываем с БД, передаем в Adapter и обновляем список
				Adapter.updateAdapter(list)

				return true
			}
		})
	}

	private fun getSwipeManager(): ItemTouchHelper{
		//SimpleCallback() указываем что делать и в каком направлении
		//return ItemTouchHelper(object:ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT))
		return ItemTouchHelper(object:ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT){
			// перетаскивание
			override fun onMove(
				recyclerView : RecyclerView,
				viewHolder : RecyclerView.ViewHolder,
				target : RecyclerView.ViewHolder
			) : Boolean {return false}

			// SWIPE
			override fun onSwiped(viewHolder : RecyclerView.ViewHolder, direction : Int) {
				// удаляем элемент на позиции
				Adapter.removeItem(viewHolder.adapterPosition, managerDB)
				Message("Заметка удалена")
			}

		})
	}
} // *--- END CLASS
