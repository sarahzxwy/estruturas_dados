/*
Árvore Binária de Pesquisa Genérica
<T> é o tipo genérico que pode ser qualquer tipo de dado.

fornece funcionalidades para manipulação da árvore, como inserção, impressão e limpeza.

 */

class ABP<T>: Arborizavel<T> {

    private var raiz: NoTriplo<T>? = null
  
    override fun getRaiz(): NoTriplo<T>? {
        return raiz
    }
 
    override fun limpar() {
        raiz = null
    }

    override fun inserir(dado: T?) {
        val novoNo = NoTriplo<T>(dado)
    
        
        if (raiz == null) {
            raiz = novoNo
        } else {
            var noAuxiliar = raiz
            while (noAuxiliar != null) {
                if ((noAuxiliar.dado as Int) > (dado as Int)) {
                     if (noAuxiliar.esquerda != null) {
                        noAuxiliar = noAuxiliar.esquerda
                    } else {
                        noAuxiliar.esquerda = novoNo
                        novoNo.genitor = noAuxiliar
                        break
                    }
                } else {
                    if (noAuxiliar.direita != null) {
                        noAuxiliar = noAuxiliar.direita
                    } else {
                        noAuxiliar.direita = novoNo
                        novoNo.genitor = noAuxiliar
                        break
                    }
                }
            }
        }
    }

    override fun apagar(dado: T?): Boolean {
        return false
    }    

    override fun buscar(dado: T): NoTriplo<T>? {
        return null
    }

    override fun existe(dado: T?): Boolean {
        return false
    }
    //imprimir
    override fun imprimirPreOrdem(): String {
        return formataSaida(imprimirPreOrdemRec(raiz))
    }

    override fun imprimirEmOrdem(): String {
        return formataSaida(imprimirEmOrdemRec(raiz))
    }

    override fun imprimirPosOrdem(): String {
        return formataSaida(imprimirPosOrdemRec(raiz))
    }

    private fun imprimirPreOrdemRec(raiz: NoTriplo<T>?): String {
        var resultado = ""
        if (raiz != null)
            resultado = "${raiz.dado} ${imprimirPreOrdemRec(raiz.esquerda)} ${imprimirPreOrdemRec(raiz.direita)}"

        return resultado
    }

    private fun imprimirEmOrdemRec(raiz: NoTriplo<T>?): String {
        var resultado = ""     
        if (raiz != null)
            resultado = "${imprimirEmOrdemRec(raiz.esquerda)} ${raiz.dado} ${imprimirEmOrdemRec(raiz.direita)}"
        
        return resultado 
    }

    private fun imprimirPosOrdemRec(raiz: NoTriplo<T>?): String {
        var resultado = ""       
        if (raiz != null) 
            resultado = "${imprimirPosOrdemRec(raiz.esquerda)} ${imprimirPosOrdemRec(raiz.direita)} ${raiz.dado}"

        return resultado            
    }

    private fun formataSaida(msg: String): String {
        var resultado: String
        var mensagem = msg
        do {
            resultado = mensagem
            mensagem = mensagem.replace("  ", " ")
        } while (mensagem != resultado)
        mensagem = mensagem.trim() 
        mensagem = mensagem.replace(" ", ",") 
        return "[$mensagem]"
    }
}