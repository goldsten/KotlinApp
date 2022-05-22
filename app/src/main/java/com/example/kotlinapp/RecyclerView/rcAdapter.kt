package com.example.kotlinapp.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapp.R
import com.example.kotlinapp.databinding.ListAdapterCardCategoryBinding

class rcAdapter() : RecyclerView.Adapter<rcAdapter.rcHolder>() {
	private var titleList = ArrayList<TitleList>()

	// rcHolder - содержит ссылки на все view в одном элементе
	class rcHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

		val binding = ListAdapterCardCategoryBinding.bind(itemView)
		// получаем список заголовка
		fun bind(titleList: TitleList) = with(binding){
			cardView.setOnClickListener {
				val title = titleList.title
				Toast.makeText(it.context, "Item: $title", Toast.LENGTH_SHORT).show()
			}
			tvCard.text = titleList.title
		}

	}
	// какой шаблон заполнять
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): rcHolder {
		return rcHolder(LayoutInflater.from(parent.context)
				.inflate(R.layout.list_adapter_card_category, parent, false))
	}
	override fun onBindViewHolder(holder: rcHolder, position: Int) {
		holder.bind(titleList[position])
	}
	override fun getItemCount(): Int {
		return titleList.size
	}
	fun addItem(item: TitleList){
		titleList.add(item)
		notifyDataSetChanged()
	}
}