package fr.isen.sirtori.androiderestaurant1

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class DishesPictureAdapter(activity: AppCompatActivity, val pictures: List<String>): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = pictures.size

    override fun createFragment(position: Int): Fragment {
        return DishesPictureFragment.newInstance(pictures[position])
    }
}