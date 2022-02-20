package com.example.tarea.ui.lugar

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.tarea.model.Carro
import com.example.tarea1.R
import com.lugares.viewmodel.CarroViewModel

class UpdateCarroFragment : Fragment() {

    private lateinit var carroViewModel : CarroViewModel
    private val args by navArgs<UpdateCarroFragmentArgs>()
    private var _binding: FragmentUpdateCarroBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        carroViewModel = ViewModelProvider(this)[CarroViewModel::class.java]
        _binding = FragmentUpdateCarroBinding.inflate(inflater,container,false)

        binding.etMarca.setText(args.lugar.marca)
        binding.etPlaca.setText(args.lugar.placa)
        binding.etColor.setText(args.lugar.color)
        binding.etModelo.setText(args.lugar.modelo)

        binding.btActualizar.setOnClickListener{
          updateCarro()
        }

    setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_delete){
            deleteCarro()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun updateCarro(){

        val marca = binding.etMarca.text.toString()
        val placa = binding.etPlaca.text.toString()
        val color = binding.etColor.text.toString()
        val modelo = binding.etModelo.text.toString()
        val carro = Carro(0,marca,placa,color,modelo,0.0,0.0,0.0,"","")
        carroViewModel.updateCarro(carro)
        Toast.makeText(requireContext(),getString(R.string.msg_agregado), Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_nav_lugar_to_addLugarFragment)


    }

        private fun deleteCarro(){
            val builder= AlertDialog.Builder(requireContext())
            builder.setPositiveButton(getString(R.string.si)){_,_->
                carroViewModel.deleteCarro(args.lugar)
                findNavController().navigate(R.id.action_updateLugarFragment_to_nav_lugar)
            }
            builder.setNegativeButton(getString(R.string.no)){_,_->}
            builder.setTitle(R.string.menu_delete)
            builder.setMessage(getString(R.string.msg_seguro_borrar)+" ${args.lugar.nombre}?")
            builder.create().show()

        }
            override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }
}