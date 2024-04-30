class ListaDinamica(private val tamanho: Int = 10): ListavelDinamica {
    // var tamanho aqui é diferente da estática, serve como tamanho máximo, para estabelecer um limite
    private var ponteiroInicio: NoDuplo? = null
    private var ponteiroFim: NoDuplo? = null
    private var quantidade = 0

    override fun estaCheia(): Boolean {
        return quantidade == tamanho
    }

    override fun estaVazia(): Boolean {
        return quantidade == 0
    }

    override fun apagar(posicao: Int): Any? {
		var dadoAux: Any? = null
		if (!estaVazia()) {
			if (posicao >= 0 && posicao < quantidade) {
				var ponteiroAux = ponteiroInicio
				for (i in 0 until posicao)
					ponteiroAux = ponteiroAux?.proximo
				
				dadoAux = ponteiroAux?.dado

				val ponteiroAnterior = ponteiroAux?.anterior
				val ponteiroProximo  = ponteiroAux?.proximo

				if (ponteiroAnterior != null) 
					ponteiroAnterior.proximo = ponteiroProximo
				// remocao do inicio, joga o ponteiro de inicio para o proximo nodo.
				else
					ponteiroInicio = ponteiroInicio?.proximo
				
				if (ponteiroProximo != null) 
					ponteiroProximo.anterior = ponteiroAnterior
				//remocao do fim, joga o ponteiro de fim para o nodo anterior.
				else
					ponteiroFim = ponteiroFim?.anterior

				quantidade = quantidade.dec()
			} else {
				println("Indice Inválido!")
			}
		} else {
			println("Lista Vazia!")
		}
		return dadoAux
	}


	override fun inserir(posicao: Int, dado: Any?) {
		if (!estaCheia()) {
				if (posicao >= 0 && posicao <= quantidade) {
					var ponteiroAnterior: NoDuplo? = null
					var ponteiroProximo = ponteiroInicio
	
					for(i in 0 until posicao) {
						ponteiroAnterior = ponteiroProximo
						ponteiroProximo = ponteiroProximo?.proximo
					}
	
					val novoNo = NoDuplo(dado)
					novoNo.proximo = ponteiroProximo
					novoNo.anterior = ponteiroAnterior
					
					if (ponteiroAnterior != null) //inserção em qualquer posição, menos no inicio
					ponteiroAnterior.proximo = novoNo
					else // inserção no inicio
					ponteiroInicio = novoNo
	
	
					if(ponteiroProximo != null) //inserção em qualquer posição, meno no fim
					ponteiroProximo.anterior = novoNo
					else // inserção no fim
					ponteiroFim = novoNo
	
					quantidade++
				}
			} else {
				println("Lista está cheia!")
			}
	}

	//idêntico ao enfileirar de FilaDinamica
	override fun anexar(dado: Any?) {
		// por padrão quando criamos o noTemp, o anterior e o proximo ja são nulos
		if (!estaCheia()) {
			val noTemp = NoDuplo(dado)
			//noTemp.dado = dado
			noTemp.anterior = ponteiroFim                
			if (!estaVazia())
				ponteiroFim?.proximo = noTemp
			else
				ponteiroInicio = noTemp
			
			ponteiroFim = noTemp
			quantidade = quantidade.inc()
		} else {
			println("Lista Cheia!")
		}
	}

	override fun selecionarTodos(): Array<Any?> {        
		var dadosAux: Array<Any?> = arrayOfNulls(quantidade)
		if (!estaVazia()) {
			var ponteiroAuxiliar = ponteiroInicio
			for (i in 0 until quantidade) {
				dadosAux[i] = ponteiroAuxiliar?.dado	
				ponteiroAuxiliar = ponteiroAuxiliar?.proximo
			}
		} else {
			println("Lista Vazia!")
		}
		return dadosAux
	}

	override fun selecionar(posicao: Int): Any? {
		var dadoAux: Any? = null
		if (!estaVazia()) {
			if (posicao >= 0 && posicao < quantidade) {
				//codigo de posicionamento do ponteiro auxiliar, no nodo
				//que será feita alguma operação. Esse codigo é o mesmo
				//para os metodos update, delete, select e insert
				var ponteiroAuxiliar = ponteiroInicio
				for (i in 0 until posicao)
					ponteiroAuxiliar = ponteiroAuxiliar?.proximo
				dadoAux = ponteiroAuxiliar?.dado
			} else {
				println("Indice Inválido!")	
			}
		} else {
			println("Lista Vazia!")		
		}
		return dadoAux
	}

	override fun atualizar (posicao: Int, dado: Any?) {
		if (!estaVazia()) {
			if (posicao >= 0 && posicao < quantidade) {
				//Codigo de posicionamento do ponteiro auxiliar, no nodo
				//que será feita alguma operação. Esse codigo é o mesmo
				//para os metodos update, delete, select e insert
				var ponteiroAuxiliar = ponteiroInicio
				for (i in 0 until posicao)
					ponteiroAuxiliar = ponteiroAuxiliar?.proximo
				ponteiroAuxiliar?.dado = dado
			} else {
				println("Indice Inválido!")	
			}
		} else {
			println("Lista Vazia!")		
		}
	}

	override fun limpar() {
		ponteiroInicio = null
		ponteiroFim = null
		quantidade = 0
	}

	override fun apagarTodos(): Array<Any?> {
		var dadosAux: Array<Any?> = selecionarTodos()
		limpar()
		return dadosAux
	}

	override fun tamanho(): Int {
		return quantidade
	}

	override fun imprimir(): String {
		var ponteiroAuxiliar = ponteiroInicio
		var resultado = "["
		for (i in 0 until quantidade) {
			resultado += ponteiroAuxiliar?.dado
			if (i != quantidade-1)
				resultado += ","
			
			ponteiroAuxiliar = ponteiroAuxiliar?.proximo
		}
		return "$resultado]"
	}	





}

