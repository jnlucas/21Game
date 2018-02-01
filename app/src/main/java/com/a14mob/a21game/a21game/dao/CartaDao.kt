package com.a14mob.a21game.a21game.dao

import com.a14mob.a21game.a21game.R
import com.a14mob.a21game.a21game.model.Carta

/**
 * Created by logonrm on 31/01/2018.
 */
class CartaDao{
    private val cartas = listOf<Carta>(
         Carta(R.drawable.as_de_espada, 1)
        ,Carta(R.drawable.cinco_de_espada, 5)
        ,Carta(R.drawable.dama_de_espada, 11)
        ,Carta(R.drawable.dez_de_espada, 10)
        ,Carta(R.drawable.dois_de_espada, 2)

    )

    fun getBaralho(): List<Carta>{
        return cartas
    }
}