class ArvoreBinariaHeapMaximo(private val tamanho: Int = 10): Amontoavell {
      // esta estrutura guarda a prioridade do dado, não o dado em si
     // arrray de inteiros, sempre trabalha com números

    
    // estrutura de array
    private var dados = IntArray(tamanho){0}
    private var ponteiroFim = -1 
	
    override fun inserir(dado: Int) {
        if (!estaCheia()) {
            ponteiroFim = ponteiroFim.inc()
            dados[ponteiroFim] = dado
            ajustarAcima(ponteiroFim)
        } else {
            println("Heap está Cheio!")
        }
    }
    
    private fun ajustarAcima(indice: Int) {
        // criar uma váriavel para atribuir o valor, que pode ser alterdao dentro do método, já que indice não pode
        var indiceAtual = indice
        while (indiceAtual != 0) {
            val indicePai = indicePai(indiceAtual)
            if (dados[indicePai] < dados[indiceAtual]) {
                trocar(indiceAtual, indicePai)
                indiceAtual = indicePai
            } else {
                break
            }
        }
    }

    private fun indicePai(indiceFilho: Int): Int {
        return (indiceFilho-1)/2
    }
        
    private fun indiceFilhoEsquerda(indicePai: Int): Int {
        return 2 * indicePai + 1
    }

    private fun indiceFilhoDireita(indicePai: Int): Int	{
        return (2 * indicePai + 1) + 1
    }

    private fun ajustarAbaixo(pai: Int) {
        val filhoEsquerdo = indiceFilhoEsquerda(pai)
        val filhoDireito = indiceFilhoDireita(pai)
        var maior = pai;
        
        // verificação para garantir que está dentro dos valores válidos do array
        if (filhoEsquerdo <= ponteiroFim) 
            if (dados[maior] < dados[filhoEsquerdo])
                maior = filhoEsquerdo

        // verificação para garantir que está dentro dos valores válidos do array
        if (filhoDireito <= ponteiroFim) 
            if (dados[maior] < dados[filhoDireito])
                maior = filhoDireito

        if (maior != pai) {
            trocar(pai, maior)
            ajustarAbaixo(maior)
        }
    }
	
    private fun trocar(i: Int, j: Int) {
        val temp = dados[i]
        dados[i] = dados[j]
        dados[j] = temp
    }

    override fun extrair(): Int? {
        var dadoRaiz: Int? = null
        if (!estaVazia()) {
            dadoRaiz = dados[0]
            dados[0] = dados[ponteiroFim]
            ponteiroFim = ponteiroFim.dec()
            ajustarAbaixo(0)
        } else {
            println("Heap está Vazio!")
        }
        return dadoRaiz
    }

    override fun atualizar(dado: Int){
        if (!estaVazia()) {
            dados[0] = dado
            ajustarAbaixo(0)
        } else {
            print("Heap Vazia!")
        }
    }

    override fun obter(): Int? {
        var dadoRaiz: Int? = null
        if (!estaVazia())
            dadoRaiz = dados[0]
        else
            print("Heap Vazia!")

        return dadoRaiz
    }
        
    override fun estaVazia(): Boolean {
        return ponteiroFim == -1
    }

    override fun estaCheia(): Boolean {
        return ponteiroFim == dados.size - 1
    }

    override fun imprimir(): String {
        var resultado = "["
        for (i in 0..ponteiroFim) {
            resultado += "${dados[i]}"
            if (i != ponteiroFim)
                resultado += ","
	}
	return "$resultado]"
	}
}