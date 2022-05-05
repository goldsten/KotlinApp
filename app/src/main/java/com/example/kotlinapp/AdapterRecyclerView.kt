package com.example.kotlinapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapp.databinding.SightItemBinding

// наследуем class от RecyclerView.Adapter <viewholder> AdapterRecyclerView.название свого класса
// viewholder - специальный класс который содержит ссылки все view в одном элементе
class AdapterRecyclerView: RecyclerView.Adapter<AdapterRecyclerView.HolderRecyclerView>() {
	// добавляем массив элементов
	val sights_list = ArrayList<SightsActivity>()

	// наследуем class от RecyclerView.ViewHolder
	// HolderRecyclerView(view отдельный шаблон, который заполняет RecyclerView )
	// RecyclerView.ViewHolder(название элемента View)
	class HolderRecyclerView(item: View): RecyclerView.ViewHolder(item) {
		// получаем список элементов View
		// так как уже готовый view, нужно только взять и  указываем item (item:View)
		val binding = SightItemBinding.bind(item)
		// (передаем SightsActivity)
		//  = with(binding) определяет что в fun bind() будет работать binding view, а значит binding.viewId писать не нужно
		fun bind(sights:SightsActivity) = with(binding){
			//получаем view
			imgView.setImageResource(sights.imgId)
			// setText() - записываем в поле значение string
			titleView.setText(sights.title)
		}
	}
	// СОЗДАЕТСЯ и хранится разметка
	// берет разметку sight_item создает с помощью inflate и создает class HolderRecyclerView
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderRecyclerView {
		// создаем шаблон разметки sight_item
		val view = LayoutInflater.from(parent.context).inflate(R.layout.sight_item, parent, false)
		// передаем class который создаем который хранит ссылки на view
		return HolderRecyclerView(view)
	}
	// ЗАПОЛНЯЕТСЯ
	// получаем доступ к элементам view и заполняем
	override fun onBindViewHolder(holder: HolderRecyclerView, position: Int) {
		// берем holder и вызываем bind(передаем sight_list[поизиция])
		holder.bind(sights_list[position])
	}
	//ПЕРЕДАЕМ РАЗМЕР МАССИВА
	override fun getItemCount(): Int {
		return sights_list.size
	}
	//ЧТО БЫ ДОБАВЛЯТЬ НОВЫЙ ЭЛЕМЕНТ
	fun addSight(sights: SightsActivity){
		sights_list.add(sights)
		// следит за новыми элементами и обновляет список
		notifyDataSetChanged()
	}
}