fun main() {
    var arvore: Arborizavel<Int> = ABP()
    do {
        exibirMenu()
        val opcao = readLine()!!.toInt()
        when(opcao) {
           
            1 -> {
                print("Informe o valor: ")
                val valor = readLine()!!.toInt()
                arvore.inserir(valor)
            }
            2 -> {
                print("Informe o valor: ")
                val valor = readLine()!!.toInt()            
                arvore.apagar(valor)
            }
            3 -> {
                print("Informe o valor: ")
                val valor = readLine()!!.toInt()
                println(arvore.existe(valor))
            }
            4 -> {
                menuImprimirEmOrdem()
                val opcaoImpressao = readLine()!!.toInt()
                when(opcaoImpressao) {
                    1 -> println("\nPre-Ordem: ${arvore.imprimirPreOrdem()}\n")
                    2 -> println("\nEm-Ordem: ${arvore.imprimirEmOrdem()}\n")                        
                    3 -> println("\nPos-Ordem: ${arvore.imprimirPosOrdem()}\n");
                    else -> println("Opçao invalida.");
                }
            }
            5 -> {                    
                arvore.limpar()
                println("Arvore Limpa!")
            } 
            
            6 -> println("Encerrando...")

            else -> {
                print("Opcao inválida. ")
            } 
           
        }
    } while (opcao != 6)
}

fun exibirMenu() {
    println("*****Árvore Binaria de Pesquisa*****")
    println("1. Inserir")
    println("2. Apagar")
    println("3. Existe?")      
    println("4. Imprimir")
    println("5. Limpar")    
    println("6. SAIR") 
    println("************************************")
    print("Escolha uma opcao (0-5): ")
}   

fun menuImprimirEmOrdem() {
    println("1. Imprimir Pre-Ordem")
    println("2. Imprimir Em-Ordem")
    println("3. Imprimir Pos-Ordem")               
    print("Escolha uma opcao (1-3): ")
}