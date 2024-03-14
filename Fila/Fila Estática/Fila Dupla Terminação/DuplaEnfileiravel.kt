interface DuplaEnfileiravel {

    fun enfileirarInicio(dado: Any?)
	fun enfileirarFim(dado: Any?) // mesmo que enfileirar da Fila Normal
    fun desenfileirarInicio(): Any? // mesmo que desenfileirar da Fila Normal
	fun desenfileirarFim(): Any?
    fun atualizarInicio(dado: Any?)
    fun atualizarFim(dado: Any?)
    fun espiarInicio(): Any? // mesmo que espiar da Fila Normal
    fun espiarFim(): Any? 
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimirdeFrente(): String
    fun imprimirdeTras(): String
}