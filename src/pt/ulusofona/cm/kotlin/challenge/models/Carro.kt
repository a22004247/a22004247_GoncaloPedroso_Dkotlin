package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel
import java.text.SimpleDateFormat

 class Carro(override val identificador: String, val motor: Motor) : Veiculo(identificador), Ligavel{
    override fun requerCarta(): Boolean {
        return true
    }

    override fun ligar() {
        motor.ligar()
    }

    override fun desligar() {
        motor.desligar()
    }

     override fun estaLigado(): Boolean {
         return motor.estaLigado()
     }

     fun estaligado(): Boolean {
        return motor.ligado
    }

    override fun moverPara(x: Int, y: Int) {
        if(estaligado()) {
            posicao.alterarPosicaoPara(x,y)
            desligar()
        } else {
            ligar()
            posicao.alterarPosicaoPara(x,y)
            desligar()
        }
    }

    fun formatarData() : String {
        val formatoData = SimpleDateFormat("aa-EE-dddd")
        val dataModificada = formatoData.format(dataDeAquisicao)
        return dataModificada.toString()
    }

    override fun toString(): String {
        return "Carro | $identificador | ${formatarData()} | $posicao"
    }
}