package fr.isen.sirtori.androiderestaurant1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import fr.isen.sirtori.androiderestaurant1.databinding.FragmentDishesPictureBinding


class DishesPictureFragment : Fragment() {
    private lateinit var binding: FragmentDishesPictureBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDishesPictureBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString("picture_url")?.let { pictureUrl ->
            Picasso.get()
                .load(pictureUrl)
                .placeholder(R.drawable.loadvitaly)
                .into(binding.dishesPictureFrag)
        }
    }

    companion object {
        fun newInstance(pictureUrl: String) =
            DishesPictureFragment().apply {
                arguments = Bundle().apply {
                    putString("picture_url", pictureUrl)
                }
            }
    }

}