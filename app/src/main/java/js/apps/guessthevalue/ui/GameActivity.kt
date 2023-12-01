package js.apps.guessthevalue.ui

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.lifecycleScope
import js.apps.guessthevalue.R
import js.apps.guessthevalue.databinding.ActivityGameBinding
import js.apps.guessthevalue.ext.toast
import js.apps.guessthevalue.viewmodel.HomeViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    private val homeVM: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val currentLeague = intent.extras!!.getInt("league")
        homeVM._currentLeague.value = currentLeague
        lifecycleScope.launch {
            homeVM.setPlayersList()
        }
        setFlowValues()
        initListeners()
    }

    private fun initListeners() {
        binding.playerDownLayout.setOnClickListener {
            with(homeVM) {
                if (validate()) {
                    Log.w(TAG, playerList.value.toString())
                    cambiarTexto()
                    toast("corrcto")
                } else {
                    goToResult(valor.value, aciertos.value)
                }
                binding.playerUpLayout.setOnClickListener {
                    if (!validate()) {
                        Log.w(TAG, playerList.value.toString())
                        cambiarTexto()
                        toast("corrcto")
                    } else {
                        goToResult(valor.value, aciertos.value)
                    }
                }
            }
        }
    }

    private fun goToResult(valor: Double, aciertos: Int) {

        Intent(this, ResultActivity::class.java).apply {
            putExtra("valor", valor)
            putExtra("aciertos", aciertos)
            startActivity(this)
        }

    }

    private fun setFlowValues() {
        lifecycleScope.launch {
            homeVM.playerState.collect {
                Log.w(TAG, "In value: $it")
                binding.apply {
                    if (it.pic != null) {
                        binding.playerUpPic.setImageResource(it.pic)
                    }
                    if (it.isPlayerLeft) {
                        Log.w(TAG, "left")
                        viewRight.visibility = View.VISIBLE
                        viewLeft.visibility = View.GONE
                        tvNamePlayerUpRight.visibility = View.VISIBLE
                        tvNamePlayerUp.visibility = View.INVISIBLE
                        tvNamePlayerUpRight.text = it.name
                        tvTeamPlayerUpRight.visibility = View.VISIBLE
                        tvTeamPlayerUp.visibility = View.INVISIBLE
                        tvTeamPlayerUpRight.text = it.equipo.key
                        tvValuePlayerRight.visibility = View.VISIBLE
                        tvPlayerValue.visibility = View.INVISIBLE
                        tvValuePlayerRight.text = "Valor: ${it.marketPrice}"
                    } else {
                        Log.w(TAG, "right")
                        viewRight.visibility = View.GONE
                        viewLeft.visibility = View.VISIBLE
                        tvNamePlayerUpRight.visibility = View.INVISIBLE
                        tvNamePlayerUp.visibility = View.VISIBLE
                        tvTeamPlayerUpRight.visibility = View.INVISIBLE
                        tvTeamPlayerUp.visibility = View.VISIBLE
                        tvNamePlayerUp.text = it.name
                        tvTeamPlayerUp.text = it.equipo.key
                        tvValuePlayerRight.visibility = View.INVISIBLE
                        tvPlayerValue.visibility = View.VISIBLE
                        tvPlayerValue.text = "Valor: ${it.marketPrice}"
                    }

                }
            }

        }
        lifecycleScope.launch {
            homeVM.leftPlayer.collect {
                if (it.pic != null) {
                    binding.playerDownPic.setImageResource(it.pic)
                }
                binding.apply {
                    if (it.isPlayerLeft) {
                        viewPlayerDownLeft.visibility = View.GONE
                        viewPlayerDownRight.visibility = View.VISIBLE
                        tvNamePlayerDownRight.visibility = View.VISIBLE
                        tvTeamPlayerDownRight.visibility = View.VISIBLE
                        tvNamePlayerDown.visibility = View.GONE
                        tvTeamPlayerDown.visibility = View.GONE
                        tvNamePlayerDownRight.text = it.name
                        tvTeamPlayerDownRight.text = it.equipo.key
                        viewPlayerDownLeft.visibility = View.GONE
                        viewPlayerDownRight.visibility = View.VISIBLE
                    } else {
                        viewPlayerDownLeft.visibility = View.VISIBLE
                        viewPlayerDownRight.visibility = View.GONE
                        tvNamePlayerDownRight.visibility = View.INVISIBLE
                        tvTeamPlayerDownRight.visibility = View.INVISIBLE
                        tvNamePlayerDown.visibility = View.VISIBLE
                        tvTeamPlayerDown.visibility = View.VISIBLE
                        tvNamePlayerDown.text = it.name
                        tvTeamPlayerDown.text = it.equipo.key
                    }
                }
            }
        }
    }
}