package fr.isen.sirtori.androiderestaurant1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.isen.sirtori.androiderestaurant1.databinding.CategoryCellBinding
import fr.isen.sirtori.androiderestaurant1.model.DishesModel


class DishesAdapter(val dish_es: List<DishesModel>, val onDishesClicked:(DishesModel) -> Unit): RecyclerView.Adapter<DishesAdapter.DishesViewHolder>() {

    class DishesViewHolder(binding: CategoryCellBinding): RecyclerView.ViewHolder(binding.root) {
        val dishesPicture = binding.dishesPictureFrag
        val dishesName = binding.dishesName
        val dishesPrice = binding.dishesPrice
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishesViewHolder {
        val binding = CategoryCellBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return DishesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DishesViewHolder, position: Int) {
        holder.dishesName.text = dish_es[position].name_fr

        Picasso.get()
            .load(dish_es[position].getFirstPicture())
            .error(R.drawable.burgermaison)
            .placeholder(R.drawable.loadvitaly)
            .into(holder.dishesPicture)
        holder.dishesPrice.text = dish_es[position].getFormattedPrice()

        holder.itemView.setOnClickListener {
            onDishesClicked(dish_es[position])
        }
    }

    override fun getItemCount(): Int = dish_es.size
}
