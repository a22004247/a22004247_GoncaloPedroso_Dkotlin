package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.util.*

abstract class Veiculo(open val identificador: String) : Movimentavel {
    var posicao = Posicao(0, 0)
    var dataDeAquisicao : Date = Date()

    fun setDataDeAquisicao() {
        dataDeAquisicao = Date()
    }

    override fun moverPara(x: Int, y: Int) {
        posicao.alterarPosicaoPara(x, y)
    }

    abstract fun requerCarta(): Boolean
}