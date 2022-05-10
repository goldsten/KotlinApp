package com.example.kotlinapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// <где будет создан холдер, название холдера>
//rcAdapter(конструктор массива с типом)
class rcAdapter(listMain:ArrayList<String>) : RecyclerView.Adapter<rcAdapter.rcHolder>() {
	val listArray = listMain

	class rcHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		// выбираем элемент в котором и которой выводить
		val tvTitle: TextView = itemView.findViewById(R.id.rcTitle)

		fun setData(title:String){
			tvTitle.text = title
		}
	}
	// сколько элементов в списке столько придется отрисовать (размер массива)
	// спископередаем списко и размер
	override fun getItemCount(): Int {
		// возвращаем размер массива
		return listArray.size
	}
	// функция создает шаблон из xml файла для отрисовки
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): rcHolder {
		// LayoutInflater класс который надувает xml в объект который отрисуется на экране
		// from - откуда брать context)
		val inflater = LayoutInflater.from(parent.context)
		//нужно вернуть холдер
		//в холдер нужно передать view rcHolder()
		return rcHolder(inflater.inflate(R.layout.rc_item, parent, false))
	}
	// подключает данные массива к шаблон для отрисовки
	override fun onBindViewHolder(holder: rcHolder, position: Int) {
		holder.setData(listArray.get(position))
	}
	// перезаписывает массив с добавление нового списка
	//передаем список List<type>
	fun updateAdapter(listItems:List<String>){
		// очищаем старый
		listArray.clear()
		// выводим новый
		listArray.addAll(listItems)
		//сообщаем адаптеру что данные изменились
		notifyDataSetChanged()
	}
}