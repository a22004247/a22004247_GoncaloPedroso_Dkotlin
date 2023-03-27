package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import java.util.*

class Pessoa(val nome: String, val dataDeNascimento: Date) {
    val veiculos = mutableListOf<Veiculo>()
    var carta: Carta? = null
    var posicao = Posicao(0, 0)

    fun comprarVeiculo(veiculo: Veiculo) {
        veiculos.add(veiculo)
    }

    fun pesquisarVeiculo(identificador: String): Veiculo {
        for(veiculo : Veiculo in veiculos) {
            if(veiculo.identificador == identificador) {
                return veiculo
            }
        }
        throw VeiculoNaoEncontradoException()
    }

    fun venderVeiculo(identificador: String, comprador: Pessoa) {
        val veiculo : Veiculo = pesquisarVeiculo(identificador)
        veiculo.setDataDeAquisicao()
        comprador.veiculos.add(veiculo)
        veiculos.remove(veiculo)
    }

    fun moverVeiculoPara(identificador: String, x: Int, y: Int) {
        val veiculo = pesquisarVeiculo(identificador)
        if (veiculo.requerCarta() && temCarta()) {
            veiculo.moverPara(x, y)
        }
    }

    fun temCarta(): Boolean {
        return carta != null
    }

    fun tirarCarta() {
        if (carta == null) {
            carta = Carta()
        }
    }
}