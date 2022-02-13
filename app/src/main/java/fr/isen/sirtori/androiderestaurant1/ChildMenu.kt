package fr.isen.sirtori.androiderestaurant1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.sirtori.androiderestaurant1.databinding.ActivityChildMenuBinding
import fr.isen.sirtori.androiderestaurant1.databinding.ActivityConnectionBinding

class ChildMenu : AppCompatActivity() {
    private lateinit var binding: ActivityChildMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChildMenuBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_child_menu)
        binding.backHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity((intent))
        }
    }
}