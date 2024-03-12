class FilaEstatica(private val tamanho: Int = 10): Enfileiravel {
    // variáveis de instancia
    private var ponteiroInicio = 0
    private var ponteiroFim = -1
    private var dados: Array<Any?> = arrayOfNulls(tamanho)
    //private var nome: String
    
    
    // construtores, usamos para inicializar as variaveis
    // this chama a classe, this. chama métodos ou variaveis
   /* constructor(tamanho: Int) {
        // esse cria o objeto
       ponteiroInicio = 0
       ponteiroFim = 0
       dados = arrayOfNulls(tamanho)
        
    }
    
    constructor() {
        this(10)
    } */
    
    /* constructor(nome: String) {
       this.nome = nome
        
    }
    
    constructor() {
        this(Claudio)
    } */
    
    // metodos auxiliares

    override fun atualizar(dado: Any?) {
        if (!estaVazia())
        dados[ponteiroInicio] = dado
        else
        println("Cant do it")
    }

    override fun enfileirar(dado: Any?) {
        if (!estaCheia()){
        ponteiroFim++
        dados[ponteiroFim] = dado
        }
        else {
            println("Full!")
            
        }
        
    }

    override fun desenfileirar() : Any? {
        var dadoInicio: Any? = null
        if (!estaVazia()) {
          dadoInicio = dados[ponteiroInicio]
          ponteiroInicio++
        }else {
            println("Queue is empty")
        }
        return dadoInicio
    }

    override fun espiar() : Any? {
        var dadoInicio: Any? = null
        if (!estaVazia())
          dadoInicio = dados[ponteiroInicio]
        else
            println("Queue is empty")
        return dadoInicio
    }

    
    override fun estaCheia(): Boolean {
        return (ponteiroFim == dados.size - 1)
    }
    
    override fun estaVazia(): Boolean {
        return (ponteiroFim + 1 == ponteiroInicio)
    }
    

    override fun imprimir() : String {
    /*FIFO = First In First Out
    LIFO = Last In Last Out */
        var resultado = "["
        for (i in ponteiroInicio .. ponteiroFim)
        if (i == ponteiroFim)
        resultado += "${dados[i]}"
        else
        resultado += "${dados[i]},"
        return "$resultado]"
    }

}
