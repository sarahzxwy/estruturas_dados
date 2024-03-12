class FilaEstaticaDuplaTermina(private val tamanho: Int = 10) : DuplaEnfileiravel {

    // atributos
    private var ponteiroInicial = 0
    private var ponteiroFinal = -1
    private var quantidade = 0
    private var dados: Array<Any?> = arrayOfNulls(tamanho)

    override fun atualizarInicio(dado: Any?) {
        if (!estaVazia())
        dados[ponteiroInicial] = dado
        else
        println("Queue is empty!")
    }

    override fun atualizarFim(dado: Any?) {
        if (!estaVazia())
        dados[ponteiroFinal] = dado
        else
        println("Queue is empty!")
    }

    override fun enfileirarInicio(dado: Any?) {
        if (!estaCheia()){
            ponteiroInicial--
            //pra fila funcionar de forma circular
            if (ponteiroInicial == -1) {
                ponteiroInicial = dados.size-1
                if (quantidade == 0)
                ponteiroFinal = dados.size-1
            }
            quantidade++
            // fim
            dados[ponteiroInicial] = dado 
        } else {
            println("Queue is full!")
        }
        }
    }

    override fun enfileirarFim(dado: Any?) {
        if (!estaCheia()){
            ponteiroFinal++
            //pra fila funcionar de forma circular
            if (ponteiroFinal == dados.size) {
                ponteiroFinal = 0
            }
            quantidade++
            // fim
            dados[ponteiroFinal] = dado 
        } else {
            println("Queue is full!")
        }

    override fun desenfileirarInicio(): Any? {
		var aux: Any? = null
		if (!estaVazia()) {
			aux = dados[ponteiroInicio]
			ponteiroInicial++
			//  pra fila funcionar de forma circular
			if (ponteiroInicial == dados.size)
				ponteiroInicial = 0
			quantidade--
			//fim	
		} else {
			println("Queue is empty!")
		}
		return aux
	}

    override fun desenfileirarFim(): Any? {
		var aux: Any? = null
		if (!estaVazia()) {
			aux = dados[ponteiroFinal]
			ponteiroFinal--
			//  pra fila funcionar de forma circular
			if (ponteiroFinal == -1)
				ponteiroFinal = dados.size-1
			quantidade--
			//fim	
		} else {
			println("Queue is empty!")
		}
		return aux
	}

    override fun frente(): Any? {
        var aux: Any? = null
        if (!estaVazia()) {
            aux = dados[ponteiroInicial]
        }else {
            println("Queue is empty!")
        }
        return aux    
    }

    override fun tras(): Any? {
        var aux: Any? = null 
        if (!estaVazia()) {
            aux = dados[ponteiroFinal]
        } else {
            println("Queue is empty!")
        }
        return aux
    }

    override fun estaCheia(): Boolean {
		return quantidade == dados.size
	}
	
	override fun estaVazia(): Boolean {
		return quantidade == 0
	}
	
    override fun imprimirFrentePraTras(): String {
		var resultado = "["
		var ponteiroAux = ponteiroInicial
		for (i in 0 .. quantidade-1) {
			if (i == quantidade-1)
				resultado += "${dados[ponteiroAux]}"
			else
				resultado += "${dados[ponteiroAux]},"
			ponteiroAux++
            if (ponteiroAux == dados.size)
            ponteiroAux = 0			
		}
		return "$resultado]"
	}

    override fun imprimirTrasPraFrente(): String {
		var resultado = "["
		var ponteiroAux = ponteiroInicial
		for (i in 0 .. quantidade-1) {
			if (i == 0)
				resultado += "${ponteiroAux]}"
			else
				resultado += "${ponteiroAux]},"
			ponteiroAux--
            if (ponteiroAux == -1)
            ponteiroAux = dados.size-1		
		}
		return "$resultado]"
	}


}