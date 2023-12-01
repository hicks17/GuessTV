package js.apps.guessthevalue.ext

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import js.apps.guessthevalue.viewmodel.HomeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.random.Random

suspend fun HomeViewModel.createRandomNums(size:Int, range:Int):List<Int> {

    val s = LinkedHashSet<Int>(size)
    Log.d(TAG, range.toString())
    while (s.size < size) {
        val randomGenerator = Random(System.currentTimeMillis())
        s += randomGenerator.nextInt(0, range)


    }
    return withContext(Dispatchers.IO) {

        Log.d(TAG, s.toString())
        Log.d(TAG, size.toString())
        s.toList()
    }
}

fun AppCompatActivity.toast(text:String){
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}