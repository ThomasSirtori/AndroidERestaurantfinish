package fr.isen.sirtori.androiderestaurant1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import fr.isen.sirtori.androiderestaurant1.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonRegister.setOnClickListener {
            if (binding.firstName.text.trim().isNotEmpty() || binding.confirmPassword.text.trim()
                    .isNotEmpty()
            ) {
                Toast.makeText(this, "Entrez un prénom", Toast.LENGTH_LONG).show()
            }
            else if(binding.lastName.text.trim().isNotEmpty()) {
                Toast.makeText(this, "Entrez un nom", Toast.LENGTH_LONG).show()
            }
            else if( binding.address.text.trim().isNotEmpty()) {
                Toast.makeText(this, "Entrez une adress", Toast.LENGTH_LONG).show()
            }
            else if( binding.email.text.trim().isNotEmpty()) {
                Toast.makeText(this, "Entrez une adress mail", Toast.LENGTH_LONG).show()
            }
            else if( binding.firstName.text.trim().isNotEmpty()) {
                Toast.makeText(this, "Entrez un mot de passe", Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(this, "Entrez un mot de passe", Toast.LENGTH_LONG).show()
            }
        }

        binding.alreadyAccount.setOnClickListener {
            val intent = Intent(this, ConnectionActivity::class.java)
            startActivity((intent))
        }

    }
}