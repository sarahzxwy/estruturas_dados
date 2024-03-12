fun main() {
    var fila: DuplaEnfileiravel = FilaEstaticaDuplaTermina()
    fila.enfileirarInicio("A")
    println(fila.imprimirFrentePraTras()) 
    println(fila.tras())
    println(fila.frente())
    fila.enfileirarInicio("B")
    fila.desenfileirarFim()
    fila.enfileirarFim("c")
    fila.atualizarFim("C")
    fila.desenfileirarInicio()
	fila.enfileirarInicio("D") 
	println(fila.imprimirFrentePraTras()) //[D,C]
	fila.frente() 
	fila.desenfileirarFim()
	println(fila.tras()) //D    
	fila.enfileirarInicio("e")
	fila.atualizarInicio("E")    
	println(fila.imprimirFrentePraTras())//[E,D]
	fila.enfileirarFim("F")
	fila.desenfileirarInicio()
	fila.enfileirarFim("G")
	println(fila.tras()) //G
	fila.enfileirarInicio("H")
	fila.desenfileirarFim()
	fila.enfileirarFim("I")
	println(fila.imprimirFrentePraTras()) 
	fila.enfileirarInicio("J")
	fila.enfileirarFim("K")
	fila.enfileirarFim("L")
	println(fila.frente()) 
	fila.desenfileirarInicio()
	println(fila.imprimirFrentePraTras()) 
}