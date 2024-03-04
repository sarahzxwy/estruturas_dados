class PilhaEstaticaInvertida : Empilhavell {
    
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
            ponteiroTopo--
            dados[ponteiroTopo] = dado
        } else {
            println("Stack is full")
        }
    }

    override fun desempilhar(): Any? {
        var dadoTopo: Any? = null
        if (!estaVazia()) {
            dadoTopo = dados[ponteiroTopo]
            ponteiroTopo++
        } else {
            println("Stack is empty!")
        }
        return dadoTopo
    }

    override fun topo(): Any? {
        var dadoTopo: Any? = null
        if (!estaVazia()) {
            dadoTopo = dados[ponteiroTopo]
        } else {
            println("Stack is empty!")
        }
        return dadoTopo
    }

    override fun estaCheia(): Boolean {
        return (ponteiroTopo == 0)

        /* if (ponteiroTopo == dados.size -1)
              return true
           else
               return false */
    }

    override fun estaVazia(): Boolean {
        return (ponteiroTopo == dados.size)
    }

    override fun imprimir(): String {
        var resultado = "["
    // iterar a pilha e no final retornar os elementos
        for( i in ponteiroTopo .. dados.size-1) {
            if (i == dados.size-1)
            resultado += "${dados[i]}"
            else
            resultado += "${dados[i]},"
        }
        return "$resultado]"
    }



}


