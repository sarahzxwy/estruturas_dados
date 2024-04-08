// anexar = enfileirar (sempre vai colocar o elemento no final)
// inserir (adiciono o elemento em qualquer lugar do array)
// selecionar (recebe uma posição, vai na posição especifica, pega o dado / maior ou igual a zero e menor que quantdade) = espiar ou frente
// atualizar (pego um dado no paramentro e substituo)
// o índice lógico é iniciado em zero
// deslocamento = shift dado pelo ponteiro início
// utilizamos posicao fisica = (ponteiroInicio + posicao) % dados.size pois é circular 
// dadoAux = dados[posicacoFisica] pois é circular

class ListaEstaticaCircular(val tamanho: Int = 10): Listavel{

    private var dados: Array<Any?> = arrayOfNulls(tamanho)
	private var quantidade = 0
	private var ponteiroInicio = 0
	private var ponteiroFim = -1
   
    override fun anexar(dado: Any?) {
		if (!estaCheia()) {
			ponteiroFim++
			if (ponteiroFim == dados.size)
				ponteiroFim = 0
			
			dados[ponteiroFim] = dado
			quantidade++
		} else {
			println("Lista cheia!")
		}
	}

    override fun selecionarTodos(): Array<Any?> {        
		var dadosAux: Array<Any?> = arrayOfNulls(quantidade)
		if (!estaVazia()) {
			var ponteiroAux = ponteiroInicio
			for (i in 0 until quantidade)
				dadosAux[i] = dados[(ponteiroAux+i)%dados.size]
            
        }
        return dadosAux
	}

    override fun selecionar (posicao: Int): Any? {
		var dadoAux: Any? = null
		if (!estaVazia()) {
            // para colocar entre índices válidos
			if (posicao >= 0 && posicao < quantidade) {
				var posicaoFisica = 
					(ponteiroInicio + posicao) % dados.size
				dadoAux = dados[posicaoFisica]
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
			// verificar se indíce e posição lógicas são válidos
			if (posicao >= 0 && 
					posicao < quantidade) {
				var posicaoFisica =	(ponteiroInicio + posicao) % dados.size
				dados[posicaoFisica] = dado
			} else {
				println("Indice Inválido!")	
			}
		} else {
			println("Lista Vazia!")		
		}
	}

    override fun inserir(posicao: Int, dado: Any?)  { // 0 a 5
        // 
        if (!estaCheia()) {
            if (posicao >=0  && posicao <=quantidade) {
              var posicaoFisica = 
              (ponteiroInicio + posicao) % dados.size
    
            var ponteiroAux = ponteiroFim+1
            for (i in posicao until quantidade) {
              var anterior = ponteiroAux-1
    
              if(ponteiroAux == dados.size) {
                ponteiroAux = 0			
              } 
              var atual = ponteiroAux
    
              dados[atual] = dados[anterior]
              ponteiroAux--
            }
    
            dados[posicaoFisica] = dado
            ponteiroFim++
            if (ponteiroFim == dados.size) {
              ponteiroFim = 0
            }
            quantidade++
          } else {
            println("Indice Inválido")
          }
        } else {
          println("Lista Cheia!")
        }
      }

    override fun apagar(posicao: Int): Any? { // 0 a 4
        // sempre vou pegando da frente e jogando pra trás
        // apagar nunca limpa a memória de verdade, para economizar tempo
        var dadoAux: Any? = null
		if (!estaVazia()) {
			// para colocar entre os índices válidos
			if (posicao >= 0 && 
					posicao < quantidade) {
           // se aumentar muito a posição vai ficando cada vez menor
				var posicaoFisica = (ponteiroInicio + posicao) % dados.size
				dadoAux = dados[posicaoFisica]
				var ponteiroAux = posicaoFisica
        // for roda quantas vezes precisar
        // pega valor na frente e joga pra trás
				for (i in 0..quantidade-posicao-1) {
          // for (i in posicao until (quantidade-1))
         // atual vai andando a cada interação do laço, ao final do laço vai pra frente
					var atual = ponteiroAux
					var proximo = (ponteiroAux+1)%dados.size

					dados[atual] = dados[proximo]
					ponteiroAux++
				}
				ponteiroFim--
        // para não atingir valor inválido -1
				if (ponteiroFim == -1) 
					ponteiroFim = dados.size - 1
				
				quantidade--
			} else {
				println("Indice Inválido!")
			}
		} else {
			println("Lista Vazia!")
		}
		return dadoAux
	}


         
	override fun estaCheia(): Boolean {
		return quantidade == dados.size
	}
	
	override fun estaVazia(): Boolean {
		return quantidade == 0
	}

    override fun imprimir(): String {
		var resultado = "["
		var ponteiroAux = ponteiroInicio
		for (i in 0 until quantidade) {
			resultado += if (i == ponteiroFim)
				"${dados[(ponteiroAux+i) % dados.size]}"
			else
				"${dados[(ponteiroAux+i) % dados.size]}, "			
		}
		return "$resultado]"
	}

}