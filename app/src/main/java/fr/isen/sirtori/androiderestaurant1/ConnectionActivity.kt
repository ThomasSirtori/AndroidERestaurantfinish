package fr.isen.sirtori.androiderestaurant1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import fr.isen.sirtori.androiderestaurant1.databinding.ActivityConnectionBinding


class ConnectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConnectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityConnectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener {
            if (binding.userName.text.trim().isNotEmpty() || binding.userPassword.text.trim()
                    .isNotEmpty()
            ) {
                Toast.makeText(this, "Entrez un identifiant", Toast.LENGTH_LONG).show()
            } else if (binding.userEmail.text.trim().isNotEmpty()) {
                Toast.makeText(this, "Entrez un email", Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(this, "Entrez un mot de passe", Toast.LENGTH_LONG).show()
            }
        }

        binding.wantRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity((intent))
        }
    }
}