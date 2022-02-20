package com.example.tarea.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea.databinding.CarroFilaBinding
import com.example.tarea.model.Carro
import com.example.tarea.ui.lugar.CarroFragmentDirections

class CarroAdapter: RecyclerView.Adapter<CarroAdapter.CarrosViewHolder>() {

    private var listaCarros = emptyList<Carro>()
    inner class CarrosViewHolder(private val itemBinding: CarrosFilaBinding) :
                RecyclerView.ViewHolder(itemBinding.root){
                    fun bind9(lugar: Carro){
                        itemBinding.tvMarca.text= carro.Marca
                        itemBinding.tvPlaca.text= carro.Placa
                        itemBinding.tvColor.text= carro.Color
                        itemBinding.tvModelo.text= carro.Modelo
                        itemBinding.vistaFila.setOnClickListener {
                            val action =
                                CarroFragmentDirections.actionNavCarroToUpdateCarroFragment(carro)
                            itemView.findNavController().navigate(action)
                        }
                    }
                }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarroViewHolder {
        TODO("Not yet implemented")
        val itemBinding = CarroFilaBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return CarroViewHolder((itemBinding))
    }

    override fun onBindViewHolder(holder: CarroViewHolder, position: Int) {
            val lugar = listaCarros[position]
            holder.bind(carro)
    }

    override fun getItemCount(): Int {
      return listaCarros.size
    }

    fun setData(carros: List<Carro>){
        this.listaCarros=carros
        notifyDataSetChanged()
    }
}