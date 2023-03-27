package pt.ulusofona.cm.kotlin.challenge
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.models.*
import java.util.*

fun main() {
    val posicao = Posicao(0,0)
    val motor = Motor(150, 2000)
    val carro = Carro("ABC123", motor)
    val bicicleta = Bicicleta("XYZ987")
    val carta = Carta()
    val pessoa = Pessoa("João", Date(2000, 1, 1))

    pessoa.comprarVeiculo(carro)
    pessoa.comprarVeiculo(bicicleta)

    pessoa.moverVeiculoPara("ABC123", 10, 20)
    bicicleta.moverPara(5, 10)

    val veiculo = pessoa.pesquisarVeiculo("ABC123")
    pessoa.venderVeiculo("ABC123", Pessoa("Maria", Date(1995, 2, 2)))

    pessoa.tirarCarta()
    if (carro.requerCarta()) {
        try {
            pessoa.temCarta()
            println("Pessoa tem carta para conduzir o carro.")
        } catch (e: PessoaSemCartaException) {
            println(e.message)
        }
    }

    println(carro.toString())
    println(bicicleta.toString())
    println(pessoa.toString())
    println(posicao.toString())
    println(motor.toString())
    println(carta.toString())
}