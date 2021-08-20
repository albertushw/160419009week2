package com.ubaya.adv160419009week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*


class GameFragment : Fragment() {
    var skor = 0
    var number1 = 0
    var number2 = 0
    var result = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments!= null){
            var playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName //dapetin nama playernya
            txtTurn.text = "$playerName's Turn" //tampilin namanya
        }
        randomizeNum()

        btnSubmit.setOnClickListener{
            var hasilUser =  txtAnswer.text.toString().toInt()
            if(result != hasilUser){
                val action = GameFragmentDirections.actionEndFragment(skor.toString());
                Navigation.findNavController(it).navigate(action)
            }
            else{
                skor += 1
                txtResult.text = skor.toString()
                randomizeNum()
            }

        }
    }

    fun randomizeNum(){
        number1 = (10..20).random()
        number2 = (10..20).random()

        txtNum1.text = number1.toString()
        txtNum2.text = number2.toString()

        result = number1 + number2
    }
}