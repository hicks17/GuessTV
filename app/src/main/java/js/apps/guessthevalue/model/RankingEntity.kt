package js.apps.guessthevalue.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "historial")
data class HistorialEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Fecha") val fecha:Int,
    @ColumnInfo(name = "Nombre") val tipo:String,
    @ColumnInfo(name = "League") val league:String,
    @ColumnInfo(name = "Score") val score:Int)