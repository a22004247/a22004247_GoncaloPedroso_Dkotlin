package pt.ulusofona.cm.kotlin.challenge.models
import java.text.SimpleDateFormat

class Bicicleta(override val identificador: String) : Veiculo(identificador) {
    override fun requerCarta(): Boolean {
        return false
    }

    fun formatarData() : String {
        val formatoData = SimpleDateFormat("aa-EE-dddd")
        val dataModificada = formatoData.format(dataDeAquisicao)
        return dataModificada.toString()
    }
    override fun toString(): String {
        return "Bicicleta | $identificador | ${formatarData()} | $posicao"
    }
}