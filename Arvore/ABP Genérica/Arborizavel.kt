interface Arborizavel<T> {
    fun getRaiz(): NoTriplo<T>? // retorna a raiz
    fun inserir(dado: T?)
    fun apagar(dado: T?): Boolean
    fun existe(dado: T?): Boolean
    fun buscar(dado: T): NoTriplo<T>?
    fun limpar()
    fun imprimirPreOrdem(): String
    fun imprimirEmOrdem(): String
    fun imprimirPosOrdem(): String
}