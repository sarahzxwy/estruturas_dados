// NoDuplo serve pra todas as estruturas dinâmicas.
data class NoDuplo (var dado: Any? = null){
    var anterior: NoDuplo? = null
     var proximo: NoDuplo? = null
   
     /* diferença de data pra class normal =  essa classe serve para saber o mapeamento,
      automaticamwnte vai criar os getters e setters
*/ 
}