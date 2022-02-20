package com.example.tarea.ui.lugar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tarea.adapter.CarroAdapter
import com.example.tarea1.R
import com.example.tarea.databinding.FragmentLugarBinding
import com.lugares.viewmodel.CarroViewModel

class CarroFragment : Fragment() {

    private lateinit var carroViewModel : CarroViewModel
    private var _binding: FragmentCarroBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        carroViewModel = ViewModelProvider(this)[CarroViewModel::class.java]
        _binding = FragmentCarroBinding.inflate(inflater,container,false)

        binding.addCarroFabButton.setOnClickListener{
            findNavController().navigate(R.id.action_nav_lugar_to_addLugarFragment)
        }

        val carroAdapter = CarroAdapter()
        var reciclador = binding.reciclador
        reciclador.adapter = carroAdapter

        reciclador.layoutManager = LinearLayoutManager(requireContext())

        carroViewModel = ViewModelProvider(this)[CarroViewModel::class.java]

        carroViewModel.getAllData.observe(viewLifecycleOwner){ carros->
            carroAdapter.setData(carros)
        }

        return binding.root
    }


    override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }
}