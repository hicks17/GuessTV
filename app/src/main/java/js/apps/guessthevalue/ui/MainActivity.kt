package js.apps.guessthevalue.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import js.apps.guessthevalue.databinding.ActivityMainBinding
import js.apps.guessthevalue.viewmodel.HomeViewModel
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import js.apps.guessthevalue.R
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var slideInLeft: Animation
    private lateinit var inFromRight:Animation
    private lateinit var binding: ActivityMainBinding
    private val homeVM:HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        slideInLeft = AnimationUtils.loadAnimation(this, R.anim.slide_in_left)
        inFromRight = AnimationUtils.loadAnimation(this, R.anim.in_from_right)
        initListeners()
        initFlows()
    }

    private fun initFlows() {

        lifecycleScope.launch {
            homeVM.currentLeague.collect {
                when (it) {
                    0 -> {
                        binding.apply {
                            league.displayedChild = 0
                            nextLeague.visibility = View.VISIBLE
                            backLeague.visibility = View.GONE
                        }
                    }

                    1 -> {
                        binding.apply {
                            league.displayedChild = 1
                            nextLeague.visibility = View.VISIBLE
                            backLeague.visibility = View.VISIBLE
                        }
                    }

                    2 -> {
                        binding.apply {
                            league.displayedChild = 2
                            nextLeague.visibility = View.GONE
                            backLeague.visibility = View.VISIBLE
                        }
                    }
                }
            }
        }
        homeVM.onPressedDiffLeft.observe(this) {
            if (it) {
                binding.league.inAnimation = inFromRight
            } else {
                binding.league.inAnimation = slideInLeft
            }
        }
    }

    private fun initListeners() {
        binding.apply {
            nextLeague.setOnClickListener { homeVM.changeLeague(true)}
            backLeague.setOnClickListener { homeVM.changeLeague(false) }
            playBtn.setOnClickListener {

                val intent = Intent(this@MainActivity, GameActivity::class.java)
                intent.putExtra("league", homeVM.currentLeague.value)
                startActivity(intent) }
        }
    }

}