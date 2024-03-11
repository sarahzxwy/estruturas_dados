fun main(args: Array<String>) {

    var pilha : Empilhavell = PilhaEstaticaInvertida(9)
    pilha.empilhar("Instituto")
    pilha.empilhar("Federal")
    println("Topo: ${pilha.topo()}")
    pilha.empilhar("de")
    pilha.empilhar("Educação")
    pilha.empilhar("Ciência")
    pilha.empilhar("e")
    println("Topo: ${pilha.topo()}")
    val conteudo = pilha.desempilhar()
    pilha.desempilhar()
    pilha.empilhar("Tecnologia")
    pilha.empilhar("da")
    pilha.empilhar("Bahia")
    pilha.empilhar(pilha.desempilhar())
    pilha.empilhar(conteudo)
    println("Pilha=${pilha.imprimir()}")

}