package com.example.kotlinapp.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapp.R
import com.example.kotlinapp.databinding.ListAdapterCardCategoryBinding

class rcAdapter() : RecyclerView.Adapter<rcAdapter.rcHolder>() {
//	val context = contextFragment
//	private var title = arrayList(" Cleaner","Plumber","Electrican","Gardener","Text5","Text6","Text7")
	private var titleList = ArrayList<TitleList>()
//	fun Message(text: String){Toast.makeText(context, text, Toast.LENGTH_SHORT).show()}

	// rcHolder - содержит ссылки на все view в одном элементе
	class rcHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		val binding = ListAdapterCardCategoryBinding.bind(itemView)
		// получаем список заголовка
		fun bind(titleList: TitleList) = with(binding){
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