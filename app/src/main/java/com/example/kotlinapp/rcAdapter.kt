package com.example.kotlinapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapp.DB.DBManager

// <где будет создан холдер, название холдера>
//rcAdapter(конструктор массива с типом)
class rcAdapter(listMain:ArrayList<ListItem>, contextMainActivity:Context) : RecyclerView.Adapter<rcAdapter.rcHolder>() {
	val listArray = listMain
	val context = contextMainActivity

	class rcHolder(itemView: View, contextViewHolde:Context) : RecyclerView.ViewHolder(itemView) {
		// выбираем элемент в котором и которой выводить
		val tvTitle: TextView = itemView.findViewById(R.id.rcTitle)
		val context = contextViewHolde

		fun setData(item:ListItem){
			tvTitle.text = item.title
			// слушатель для всего элемента
			itemView.setOnClickListener {
				// передаем значения в EditActivity
				val intent = Intent(context, EditActivity::class.java).apply{
					putExtra(IntentConstance.I_ID_KEY, item.id)
					putExtra(IntentConstance.I_TITLE_KEY, item.title)
					putExtra(IntentConstance.I_NOTE_KEY, item.note)
					putExtra(IntentConstance.I_URI_KEY, item.uri)
				}
				// запускаем intent
				context.startActivity(intent)
			}
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
		return rcHolder(inflater.inflate(R.layout.rc_item, parent, false), context)
	}
	// подключает данные массива к шаблон для отрисовки
	override fun onBindViewHolder(holder: rcHolder, position: Int) {
		holder.setData(listArray.get(position))
	}
	// перезаписывает массив с добавление нового списка
	//передаем список List<type>
	fun updateAdapter(listItems:List<ListItem>){
		// очищаем старый
		listArray.clear()
		// выводим новый
		listArray.addAll(listItems)
		//сообщаем адаптеру что данные изменились
		notifyDataSetChanged()
	}
	// оичщиаем видимую часть в адаптере
	fun removeItem(position:Int, dbManager : DBManager){
		// перед тем как удалять визуально, нужно удалить с БД
		dbManager.removeItemFromDB(listArray[position].id.toString())
		// удаляем из списка
		listArray.removeAt(position)
		// сообщаем адаптеру что нужно показать новый размер списка
		notifyItemRangeChanged(0, listArray.size)
		// указываем позицию на которой удалили
		notifyItemRemoved(position)

	}
}