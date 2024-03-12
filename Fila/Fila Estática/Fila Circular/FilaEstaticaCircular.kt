// fila circular é uma estrutura de dados onde o último elemento está ligado ao primeiro, formando um círculo
class FilaEstaticaCircular(private val tamanho: Int = 10) : Enfileiravell {
 
	private var ponteiroInicio = 0
	private var ponteiroFim = -1 
	private var dados: Array<Any?> = arrayOfNulls(tamanho)
    private var quantidade = 0
	
	override fun desenfileirar(): Any? {
		var dadoInicio: Any? = null
		if (!estaVazia()) {
			dadoInicio = dados[ponteiroInicio]
			ponteiroInicio++
			//  pra fila funcionar de forma circular
			if (ponteiroInicio == dados.size)
				ponteiroInicio = 0
			quantidade--
			//fim	
		} else {
			println("Queue is empty!")
		}
		return dadoInicio
	}
    
    	override fun enfileirar(dado: Any?) {
		if (!estaCheia()) {
			ponteiroFim++
			// pra fila funcionar de forma circular
			if (ponteiroFim == dados.size)
				ponteiroFim = 0
			quantidade++
			// fim 		
			dados[ponteiroFim] = dado
		} else {
			println("Queue is full!")
		}
	}

	
	override fun espiar(): Any? {
		var dadoInicio: Any? = null
		if (!estaVazia()) {
			dadoInicio = dados[ponteiroInicio]
		} else {
			println("Queue is empty!")
		}
		return dadoInicio
	}
	
	override fun estaCheia(): Boolean {
		return quantidade == dados.size
	}
	
	override fun estaVazia(): Boolean {
		return quantidade == 0
	}
	
	override fun imprimir(): String {
		var resultado = "["
		var aux = ponteiroInicio
		for (i in 0 .. quantidade-1) {
			if (i == quantidade-1)
				resultado += "${dados[aux % dados.size]}"
			else
				resultado += "${dados[aux % dados.size]},"

			aux++			
		}
		return "$resultado]"
	}
}