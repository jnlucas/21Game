package com.a14mob.a21game.a21game.fragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.a14mob.a21game.a21game.EstouroPontuacaoActivity

import com.a14mob.a21game.a21game.R
import com.a14mob.a21game.a21game.dao.CartaDao
import com.a14mob.a21game.a21game.model.Carta
import kotlinx.android.synthetic.main.fragment_game.*
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {

    lateinit var tvPontuacao: TextView
    var cartas: MutableList<Carta> = ArrayList();
    val CartaDao = CartaDao();
    val gerador = Random()
    lateinit var  btProximo: Button
    lateinit var  btRecomecar: Button





    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_game, container, false)

        tvPontuacao = view!!.findViewById(R.id.tvPonto);

        iniciarPartida()
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btProximo = view!!.findViewById(R.id.btProximo);
        this.tvPontuacao = view!!.findViewById(R.id.tvPonto)

        btRecomecar = view!!.findViewById(R.id.btRecomecar);
        
        btRecomecar.setOnClickListener({
            iniciarPartida();
        })



        btProximo.setOnClickListener({
            realizaJogada();
        })
    }

    fun iniciarPartida(){
        this.tvPontuacao.setText("0");
        this.cartas = CartaDao.getBaralho().toMutableList();
        val posicaoCartaSelecionada: Int = this.gerador.nextInt(cartas.size)
        var cartaSelecionada: Carta = cartas.get(posicaoCartaSelecionada)

        ivCarta.setImageDrawable(ContextCompat.getDrawable(context,cartaSelecionada.resouceId))
    }

    fun realizaJogada(){
        this.cartas = CartaDao.getBaralho().toMutableList();
        val posicaoCartaSelecionada: Int = this.gerador.nextInt(cartas.size)
        var cartaSelecionada: Carta = cartas.get(posicaoCartaSelecionada)
        var pontuacaoAtualizada: Int = (this.tvPontuacao.text.toString().toInt() + cartaSelecionada.pontuacao)


        tvPontuacao.text = pontuacaoAtualizada.toString()


        if(pontuacaoAtualizada < 21){
            cartas.removeAt(posicaoCartaSelecionada);
            ivCarta.setImageDrawable(ContextCompat.getDrawable(context,cartaSelecionada.resouceId))
        }else{
            val intent = Intent(context,EstouroPontuacaoActivity::class.java)
            intent.putExtra("PONTUACAO",tvPontuacao.text.toString());
            startActivity(intent)

        }

    }

}// Required empty public constructor
