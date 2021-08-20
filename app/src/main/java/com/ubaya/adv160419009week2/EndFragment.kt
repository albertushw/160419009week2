package com.ubaya.adv160419009week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_end.*

class EndFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_end, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments!= null){
            var skorFinal = EndFragmentArgs.fromBundle(requireArguments()).score
            txtScore.text = "Your Score is $skorFinal"
        }
        btnBack.setOnClickListener {
            val action = EndFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}