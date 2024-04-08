class ArvoreBinariaHeapMinimo(private val tamanho: Int = 10): Amontoavel {
    // esta estrutura guarda a prioridade do dado, não o dado em si
    // array de inteiros, sempre trabalha com números


    // estrutura de array
	private var dados = IntArray(tamanho){0}
    private var ponteiroFim = -1 
	
    override fun inserir(dado: Int) {
        // abro um espaço no array, passo o dado pra ultima posição e ajusto
        if (!estaCheia()) {
			// ponteiroFim = ponteiroFim.inc()
            ponteiroFim++
            dados[ponteiroFim] = dado
			ajustarAcima(ponteiroFim)
        } else {
			println("Heap está Cheio!")
		}
    }

    private fun ajustarAcima(indice: Int) {
        // criar uma váriavel para atribuir o valor, que pode ser alterdao dentro do método, já que indice não pode
        var indiceAux = indice
        while (indiceAux != 0) {
            var pai = indicePai(indiceAux)
            var filho = indiceAux
            if (dados[pai] > dados[filho]) {
                troca(pai, filho)
                indiceAux = pai
            } else {
                break
            }
        }
    }

    override fun extrair(): Int {
		var raiz = 0
        if (!estaVazia()) {
            // retorno o que esta na raiz
            // ultimo dados inserido que esta em ponteiroFim
            // r coloco na raiz
            // ajutar abaixo
			raiz = dados[0]
			dados[0] = dados[ponteiroFim]
            ponteiroFim--
			// ponteiroFim = ponteiroFim.dec()
			ajustarAbaixo(0)
        } else {
			println("Heap Vazia!")
		}
        return raiz
    }

    private fun ajustarAbaixo(pai: Int) {
        val filhoEsquerdo = indiceFilhoEsquerdo(pai)
        val filhoDireito = indiceFilhodDireito(pai)
        var menor = pai

        // verifica se está dentro dos valores válidos do array
        if (filhoEsquerdo <= ponteiroFim) { 
            if (dados[menor] > dados[filhoEsquerdo])
                menor = filhoEsquerdo
        }

        // verifica se está dentro dos valores válidos do array
        if (filhoDireito <= ponteiroFim) { 
            if (dados[menor] > dados[filhoDireito])
                menor = filhoDireito
        } 

        if (menor != pai) {
            troca(menor, pai)
            ajustarAbaixo(menor)
        }
    }

    
	
    private fun troca(i: Int, j: Int) {
        val temp = dados[i]
        dados[i] = dados[j]
        dados[j] = temp
    }

    private fun indicePai(indiceFilho: Int): Int {
        return (indiceFilho-1)/2
    }
    private fun indiceFilhoEsquerdo(indicePai: Int): Int {
        return indicePai * 2 + 1
    }
    private fun indiceFilhodDireito(indicePai: Int): Int {
        return indicePai * 2 + 2
    }

    override fun atualizar (dado: Int) {
        // dado passado como paramentro, colocar ele na raiz
        // depois chamar ajustarAbaixo para que continue como heap
        if(!estaVazia()){
            dados[0] = dado
            ajustarAbaixo(0)
        } else {
            print("Heap Vazia!")
        }
    }

    override fun obter(): Int {
        // pega o que esta na raiz e retorna
        var raiz: Int = 0
        if (!estaVazia())
            raiz = dados[0]

        return raiz
    }
        
	override fun estaVazia(): Boolean {
        return ponteiroFim == -1
    }

	override fun estaCheia(): Boolean {
		return ponteiroFim == dados.size - 1
        // última posição valida
    }



	override fun imprimir(): String {
		var resultado = "["
        // para iterar os elementos
		for (i in 0..ponteiroFim) {
            resultado += "${dados[i]}"
            // se não for o ultimo elemento
			if (i != ponteiroFim)
				resultado += ","
		}
		return "$resultado]"
	}
}