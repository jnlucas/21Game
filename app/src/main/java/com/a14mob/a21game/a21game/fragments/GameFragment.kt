package com.a14mob.a21game.a21game.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.a14mob.a21game.a21game.R


/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {

    lateinit var tvPontuacao: TextView


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_game, container, false)

        tvPontuacao = view!!.findViewById(R.id.tvPonto);

        iniciarPartida()
    }

    fun iniciarPartida(){
        tvPontuacao
    }

}// Required empty public constructor
