package com.example.tarea

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tarea.model.Carro
import com.example.tarea1.R
import com.lugares.viewmodel.CarroViewModel

class AddCarroFragment : Fragment() {

    private lateinit var carroViewModel : CarroViewModel
    private var _binding: FragmentAddCarroBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       carroViewModel = ViewModelProvider(this)[CarroViewModel::class.java]
        _binding = FragmentAddCarroBinding.inflate(inflater, container, false)
        binding.btAgregar.setOnClickListener{
            insertarCarro()
        }
        return binding.root
    }

    private fun insertarCarro() {
        val marca = binding.etMarca.text.toString()
        val placa = binding.etCorreo.text.toString()
        val color = binding.etTelefono.text.toString()
        val modelo = binding.etWeb.text.toString()
        val carro = Carro(0,marca,placa,color,modelo,0.0,0.0,0.0,"","")
        carroViewModel.addCarro(carro)

        Toast.makeText(requireContext(),getString(R.string.msg_agregado),Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_nav_lugar_to_addLugarFragment)

    }


    override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }

}