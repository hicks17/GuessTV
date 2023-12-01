package js.apps.guessthevalue.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import js.apps.guessthevalue.R
import js.apps.guessthevalue.databinding.ActivityResultBinding
import js.apps.guessthevalue.viewmodel.HomeViewModel

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    val homeViewModel:HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initFlows()
    }

    private fun initFlows() {
        val valor = intent.getDoubleExtra("valor", 0.0)
        val aciertos = intent.getIntExtra("aciertos", 0)
        binding.tvAciertos.text = "Obtuviste $aciertos aciertos"
        binding.tvValor.text = "Tu valor es de $valor"
    }
}