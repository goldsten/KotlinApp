package com.example.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlinapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding
	fun Message(text: String){
		return Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
	}

	override fun onCreate(s: Bundle?) {
		binding = ActivityMainBinding.inflate(layoutInflater)
		super.onCreate(s)
		setContentView(binding.root)


		binding.bottomNavigation.setOnItemSelectedListener { item ->
			when(item.itemId) {
				R.id.shop -> {
					// Respond to navigation item 1 click
					Message("Fragment ${item.itemId}")

					true
				}
				R.id.category -> {
					// Respond to navigation item 2 click
					Message("Fragment ${item.itemId}")
					true
				}
				R.id.profile -> {
					// Respond to navigation item 2 click
					Message("Fragment ${item.itemId}")
					true
				}
				else -> false
			}
		}

	}
}
/*
*
* <style name="ThemeOverlay.App.BottomNavigationView" parent="">
<!--        background-->
        <item name="colorSurface">@color/white</item>
<!--        active color text-->
        <item name="colorOnSurface">#9DFF00</item>
<!--        inactive color Icon/Text label-->
        <item name="colorOnSurfaceVariant">@color/item_bar_unchecked</item>
<!--        active color Icon/-->
        <item name="colorOnSecondaryContainer">@color/teal_200</item>
<!--        active color circle icon-->
        <item name="itemTextAppearanceInactive">@color/itemTextAppearanceActive</item>
        <item name="itemTextAppearanceActive">@color/itemTextAppearanceInactive</item>
<!--        color around active item-->
        <item name="colorPrimary">@color/design_default_color_error</item>
    </style>
* */