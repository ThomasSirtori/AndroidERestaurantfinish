package fr.isen.sirtori.androiderestaurant1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.sirtori.androiderestaurant1.databinding.ActivityDetailBinding
import fr.isen.sirtori.androiderestaurant1.model.DishesModel

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dishes = intent.getSerializableExtra("dishes") as DishesModel
        initDetail(dishes)

    }

    private fun initDetail(dishes: DishesModel) {
        var nbInBucket = 1
        binding.detailTitle.text = dishes.name_fr

        binding.dishesPhotoPager.adapter = DishesPictureAdapter(this, dishes.pictures)

        binding.dishesIngredient.text = dishes.ingredients.joinToString(", ") { it.name_fr}

        binding.boutonPlus.setOnClickListener {
            nbInBucket++
            binding.number.text = nbInBucket.toString()
            binding.boutonPanier.text = "AJOUTER AU PANIER " + (dishes.prices[0].price.toFloat() * nbInBucket) + "€"
        }

        binding.boutonMoins.setOnClickListener {
            if (nbInBucket > 0) nbInBucket--
            else nbInBucket = 0
            binding.number.text = nbInBucket.toString()
            binding.boutonPanier.text =
                "AJOUTER AU PANIER  " + (dishes.prices[0].price.toFloat() * nbInBucket) + "€"
        }
        binding.boutonPanier.setOnClickListener{
            val intent = Intent(this, ConnectionActivity::class.java)
            startActivity(intent)
        }
    }
}