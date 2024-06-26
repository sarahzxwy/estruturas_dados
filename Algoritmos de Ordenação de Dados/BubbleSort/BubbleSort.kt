/* Compara de dois a dois, se a for menor q p, não faço nada, a passa a ser a outro p,
na passada do for o maior elemento vai pra ultima
 */
class BubbleSort(private var dados: Array<Int>): Ordenavel {

    //swap
    private fun trocar(i: Int, j: Int) {
        val temp = dados[i]
        dados[i] = dados[j]
        dados[j] = temp
    }

    //print
    override fun imprimir() {
        for (item in dados) {
            print("$item ")
        }
        println("")
    }

    //sort
    override fun ordenar() {
        for (i in 0 until dados.size-1) {
            for (j in 0 until dados.size-i-1) {
                if (dados[j] > dados[j+1])
                    trocar(j, j+1)             
            }
        }
    }
}