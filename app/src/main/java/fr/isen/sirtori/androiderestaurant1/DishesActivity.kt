package fr.isen.sirtori.androiderestaurant1

import android.app.DownloadManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import fr.isen.sirtori.androiderestaurant1.databinding.ActivityDishesBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import fr.isen.sirtori.androiderestaurant1.model.Dishes
import fr.isen.sirtori.androiderestaurant1.model.DishesModel
import fr.isen.sirtori.androiderestaurant1.model.DishesResult
import org.json.JSONObject

class DishesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDishesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDishesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val categoryType = intent.getStringExtra("category_type") ?: ""
        binding.mainDishesTitle.text = categoryType

        loadDish_esFromCategory(categoryType)

    }

    private fun loadDish_esFromCategory(categorType: String) {
        val url = "http://test.api.catering.bluecodegames.com/menu"

        val jsonObject = JSONObject ()
        jsonObject.put("id_shop", "1")
        val jsonRequest = JsonObjectRequest(
            Request.Method.POST, url, jsonObject, { response ->
                val dishesResult = Gson().fromJson(response.toString(), DishesResult::class.java)
                displayDish_es(dishesResult.data.firstOrNull { category -> category.name_fr == categorType }?.items ?: listOf())
            },{
                    Log.e("dishesActivity", "erreur lors de la récupération de la liste des plats")
                })
        Volley.newRequestQueue(this).add(jsonRequest)

    }

    private fun displayDish_es(dish_es: List<DishesModel>) {

        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = DishesAdapter(dish_es) {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("dishes", it)
            startActivity(intent)
        }
    }
}