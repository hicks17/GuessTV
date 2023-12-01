package js.apps.guessthevalue.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import js.apps.guessthevalue.data.PlayersProvider
import js.apps.guessthevalue.ext.createRandomNums
import js.apps.guessthevalue.model.Player
import js.apps.guessthevalue.model.Teams
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    var _currentLeague: MutableStateFlow<Int> = MutableStateFlow(0)
    val currentLeague: StateFlow<Int> = _currentLeague.asStateFlow()

    private var _onPressedDiffLeft = MutableLiveData(false)
    var onPressedDiffLeft: LiveData<Boolean> = _onPressedDiffLeft

    private var _playersList = MutableLiveData<List<Player>>()
    val playerList:LiveData<List<Player>> = _playersList

    private var _counter = MutableStateFlow(1)
    val counter:StateFlow<Int> = _counter.asStateFlow()

    private var _valor = MutableStateFlow(0.0)
    val valor:StateFlow<Double> = _valor.asStateFlow()

    private var _aciertos = MutableStateFlow(0)
    val aciertos:StateFlow<Int> = _aciertos.asStateFlow()

    private val _playerState = MutableStateFlow(Player("", Teams.ARS, 0))
    val playerState: StateFlow<Player> = _playerState.asStateFlow()

    private val _leftPlayer = MutableStateFlow(Player("", Teams.ARS, 0))
    val leftPlayer: StateFlow<Player> = _leftPlayer.asStateFlow()

    fun cambiarTexto() {
        _leftPlayer.value = playerList.value!![counter.value.plus(1)]
        _playerState.value = playerList.value!![counter.value]
        Log.w(TAG, _playerState.value.toString())
        Log.w(TAG, _leftPlayer.value.toString())
        _counter.value += 1
        _valor.value += 0.25
    }


    fun changeLeague(plusOrMin: Boolean) {
        _onPressedDiffLeft.value = plusOrMin
        if (plusOrMin) {
            _currentLeague.value += 1
        } else {
            _currentLeague.value -= 1
        }
    }

    fun validate() = _leftPlayer.value.marketPrice > _playerState.value.marketPrice


    suspend fun setPlayersList() {

        when (currentLeague.value) {
            0 -> {
                    Log.w(TAG, "updated")
                    val players = PlayersProvider().createPremPlayersList(createRandomNums(58, 58))
                    Log.w(TAG, players.toString())
                _playerState.update { players[0]}
                Log.w(TAG, _playerState.value.toString())
                _leftPlayer.update { players[1]}
                Log.w(TAG, _leftPlayer.value.toString())

                    _playersList.value = players

            }

            else -> viewModelScope.launch {
                _playersList.value =
                    PlayersProvider().createPremPlayersList(createRandomNums(58, 58)).toMutableList()
            }
        }
    }
}
