package fr.isen.sirtori.androiderestaurant1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import fr.isen.sirtori.androiderestaurant1.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.starters.setOnClickListener {
            changeActivity(getString(R.string.home_starters))
        }

        binding.dishes.setOnClickListener {
            changeActivity(getString(R.string.home_dishes))
        }

        binding.desserts.setOnClickListener {
            changeActivity(getString(R.string.home_desserts))
        }
        binding.childMenu.setOnClickListener {
            changeActivityOffers(getString(R.string.child_menu))
        }
    }

    private fun changeActivity(category: String) {
        val intent = Intent(this, DishesActivity::class.java)
        intent.putExtra("category_type",category)
        startActivity(intent)
    }
    private fun changeActivityOffers(category: String) {
        val intent = Intent(this, ChildMenu::class.java)
        intent.putExtra("category_type", category)
        startActivity(intent)
    }

}