package com.example.tarea.model
import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

@Parcelize
@Entity(tableName="carro")
data class Carro(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name="marca")
    val marca: String,
    @ColumnInfo(name="placa")
    val placa: String?,
    @ColumnInfo(name="color")
    val color: String?,
    @ColumnInfo(name="modelo")
    val modelo: String?,
    @ColumnInfo(name="latitud")
    val latitud: Double?,
    @ColumnInfo(name="longitud")
    val longitud: Double?,
@ColumnInfo(name="altura")
val altura: Double?,
@ColumnInfo(name="rutaAudio")
val rutaAudio: String?,
@ColumnInfo(name="rutaImagen")
val rutaImagen: String?,


) : Parcelable
