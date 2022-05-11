package com.example.kotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

	override fun onCreate(s: Bundle?) {
		super.onCreate(s)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		init()

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
		val list = managerDB.readDBData()
		// считываем с БД, передаем в Adapter и обновляем список
		Adapter.updateAdapter(list)
		if(list.size > 0) {
			binding.tvNoElements.visibility = View.GONE
		} else {
			binding.tvNoElements.visibility = View.VISIBLE
		}
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
				Adapter.removeItem(viewHolder.adapterPosition)
			}

		})
	}
} // *--- END CLASS