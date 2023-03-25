package pt.ulusofona.cm.kotlin.challenge.models;
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.util.*;

class Pessoa(val nome: String, val dataDeNascimento: Date) {
    val veiculos = mutableListOf<Veiculo>()
    var carta: Carta? = null
    var posicao = Posicao(0, 0)

    fun comprarVeiculo(veiculo: Veiculo) {
        veiculos.add(veiculo)
    }

    fun pesquisarVeiculo(identificador: String): Veiculo? {
        return veiculos.find { it.identificador == identificador }
    }

    fun venderVeiculo(identificador: String, comprador: Pessoa) {
        val veiculo = pesquisarVeiculo(identificador)
        if (veiculo != null) {
            veiculos.remove(veiculo)
            comprador.comprarVeiculo(veiculo)
        }
    }

    fun moverVeiculoPara(identificador: String, x: Int, y: Int) {
        val veiculo = pesquisarVeiculo(identificador)
        if (veiculo != null && veiculo.requerCarta() && temCarta()) {
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

class Posicao(var x: Int, var y: Int) {
    fun alterarPosicaoPara(x: Int, y: Int) {
        this.x = x
        this.y = y
    }
}

class Motor(val cavalos: Int, val cilindrada: Int) : Ligavel {
        var ligado = false

        override fun ligar() {
        ligado = true
        }

        override fun desligar() {
        ligado = false
        }

        override fun estaLigado(): Boolean {
        return ligado
        }
        }

class Carro(override val identificador: String, val motor: Motor) : Veiculo(identificador) {
        override fun requerCarta(): Boolean {
        return true
        }
        }

class Bicicleta(override val identificador: String) : Veiculo(identificador) {
        override fun requerCarta(): Boolean {
        return false
        }
        }

abstract class Veiculo(open val identificador: String) : Movimentavel {
        var posicao = Posicao(0, 0)
        var dataDeAquisicao = Date()

        override fun moverPara(x: Int, y: Int) {
        posicao.alterarPosicaoPara(x, y)
        }

abstract fun requerCarta(): Boolean
        }

class Carta {
    val dataDeEmissao: Date = Date();
}


