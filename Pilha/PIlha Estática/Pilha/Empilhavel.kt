interface Empilhavel {
    
    // Métodos principais
    fun empilhar(dado: Any?)
    fun desempilhar(): Any?
    fun topo(): Any?

    // Métodos auxiliares
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
    
}
