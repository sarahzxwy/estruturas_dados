//Heap = Monte
//Heapify = Organizar dados na forma de um Heap
//Heapifiable = Amontoavel
public interface Amontoavel {
    fun inserir(dado: Int)  //insert c
    fun extrair(): Int      //extract d
    fun obter(): Int        //get r
    fun atualizar(dado: Int) // update u
    
    fun imprimir(): String
    fun estaVazia(): Boolean
    fun estaCheia(): Boolean


    /* métodos privados - não precisam estar na interface */ 
    //private fun indicePai(filho: Int): Int
    //private fun trocar(i: Int, j: Int)
    //private fun ajustarAbaixo(pai: Int) //heapifyDown
    //private fun ajustarAcima(indice: Int) //heapifyUp
}