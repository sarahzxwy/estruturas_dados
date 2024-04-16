// Estruturas dinâmicas - baseadas em objetos
class PilhaDinamica(var tamanho: Int = 10): EmpilhavelDinamica {
    // var tamanho aqui é diferente da estática, serve como tamanho máximo, para estabelecer um limite
   private var ponteiroTopo: NoDuplo? = null
    // ponteiroTopo vai guardar o objeto do tipo NoDuplo
   private var quantidade = 0

   override fun estaVazia(): Boolean {
    return quantidade == 0
   }

   override fun estaCheia(): Boolean {
    return quantidade == tamanho
   }

   override fun desempilhar(): Any? {
    var dadoTopo: Any? = null
    if(!estaVazia()){
        dadoTopo = ponteiroTopo?.dado // quando ponteiroTopo pode ser nulo adiciono "?"
        // voltar ponteirotopo pro No anterior
        ponteiroTopo = ponteiroTopo?.anterior
        if(ponteiroTopo != null)
        ponteiroTopo?.proximo = null
        quantidade = quantidade.dec()
        // quantidade--
       } else {
           println("vazia!")
       }
       return dadoTopo
   }

   override fun empilhar(dado: Any?) {
    if(!estaCheia()){
    var novoNo = NoDuplo(dado) // alocando memoria
       novoNo.anterior = ponteiroTopo // posso chamar esse set msm que seja nulo, nese caso nao é
       if (!estaVazia()) /// se estiver vazia ponteiroTopo ta nulo
       ponteiroTopo?.proximo = novoNo // quando ponteiroTopo pode ser nulo adiciono "?"
       ponteiroTopo = novoNo
       quantidade = quantidade.inc() 
        // quantidade++
       } else {
        println("Esta cheia")
       }
   }


   override fun espiar(): Any?{   
    var dadoTopo: Any? =null
    if(!estaVazia()){
     dadoTopo = ponteiroTopo?.dado
    } else {
        println("vazia!")
    }
    return dadoTopo
   }

   override fun atualizar(dado: Any?){
    // ponteiroTopo.dado = dado
    if(!estaVazia()){
        ponteiroTopo?.dado = dado
    } else {
        println("Esta vazia")
    }
    
   }

   override fun imprimir(): String {
    var ponteiroAuxiliar = ponteiroTopo
    var resultado = "["
    for(i in 0 until quantidade){
          resultado += ponteiroAuxiliar?.dado
        if ( i !== quantidade-1) 
        resultado +=","

        ponteiroAuxiliar = ponteiroAuxiliar?.anterior
    }

    return "$resultado]"
   }


 }