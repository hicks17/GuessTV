package js.apps.guessthevalue.model

data class Player(
    val name:String,
    val equipo:Teams,
    val marketPrice:Int,
    val pic:Int? = null,
    val isPlayerLeft:Boolean = true,
    val isViewRequired: Boolean = true
    )