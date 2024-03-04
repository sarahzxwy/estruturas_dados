class PilhaEstatica : Empilhavel {

    // variáveis globais (de instância)
    // val é constante, nesse caso será var 
    private var ponteiroTopo: Int
    private var dados: Array<Any?>

    constructor(tamanho: Int) {
        dados = arrayOfNulls(tamanho)
        ponteiroTopo = -1
    }
    
    // construtores são públicos para conseguir criar objetos normalmente
    // privados, geralmente, usamos em banco de dados Singletan
    constructor() : this(10)
    
    // override = sobrescrevendo o método da interface
    override fun empilhar(dado: Any?) {
        if (!estaCheia()) {
            ponteiroTopo++
            dados[ponteiroTopo] = dado
        } else {
            println("Stack is full")
        }
    }

    override fun desempilhar(): Any? {
        var dadoTopo: Any? = null
        if (!estaVazia()) {
            dadoTopo = dados[ponteiroTopo]
            ponteiroTopo--
        } else {
            println("Stack is empty!")
        }
        return dadoTopo
    }

    override fun estaCheia(): Boolean {
        return (ponteiroTopo == dados.size - 1)

        /* if (ponteiroTopo == dados.size -1)
              return true
           else
               return false */
    }

    override fun estaVazia(): Boolean {
        return (ponteiroTopo == - 1)
    }

    override fun imprimir(): String {
        var resultado = "["
    // iterar a pilha e no final retornar os elementos
        for( i in ponteiroTopo downTo 0) {
        // 'step to 2' pula os valores do array de 2 em 2
            if (i == 0)
            resultado += "${dados[i]}"
            else
            resultado += "${dados[i]},"
        }
        return "$resultado]"
    }



}