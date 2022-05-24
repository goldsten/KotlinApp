package com.example.kotlinapp.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapp.DataArrayList.TitleListCategory
import com.example.kotlinapp.R
import com.example.kotlinapp.databinding.ListAdapterCardCategoryBinding

class rcAdapterCardCategoryThird() : RecyclerView.Adapter<rcAdapterCardCategoryThird.rcHolder>() {
	private var titleListCategory = ArrayList<TitleListCategory>()

	// rcHolder - содержит ссылки на все view в одном элементе
	class rcHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

		val binding = ListAdapterCardCategoryBinding.bind(itemView)
		// получаем список заголовка
		fun bind(titleListCategory: TitleListCategory) = with(binding){
			cardView.setOnClickListener {
				val title = titleListCategory.title
				Toast.makeText(it.context, "Item: $title", Toast.LENGTH_SHORT).show()
			}
			tvCard.text = titleListCategory.title
		}

	}
	// какой шаблон заполнять
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): rcHolder {
		return rcHolder(LayoutInflater.from(parent.context)
				.inflate(R.layout.list_adapter_card_category, parent, false))
	}
	override fun onBindViewHolder(holder: rcHolder, position: Int) {
		holder.bind(titleListCategory[position])
	}
	override fun getItemCount(): Int {
		return titleListCategory.size
	}
	fun addItem(item: TitleListCategory){
		titleListCategory.add(item)
		notifyDataSetChanged()
	}
}