interface Enfileiravell {

    // Metodos principais
    fun enfileirar(dado: Any?)
    fun desenfileirar(): Any?
    fun espiar(): Any?
    
    // Metodos auxiliares
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}