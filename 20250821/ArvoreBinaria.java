/**
 * 
 * Lethicia Ribeiro Silva- atividade
 * 
 *
 * 
 * Implementação de uma Árvore Binária de Busca.
 * Foco em operações recursivas para inserção, busca e remoção.
 * * @author Equipe da Disciplina
 * @version 2025.08.14
 */
public class ArvoreBinaria implements Arvore {

    private NodoArvore raiz;
        /**
         * Construtor da árvore. Inicia uma árvore vazia.
         */
        public ArvoreBinaria() {
            this.raiz = null;
        }
    
        // --- MÉTODO DE INSERÇÃO ---
        /**
         * Método público para inserir um novo valor na árvore.
         * Ele chama o método auxiliar recursivo para encontrar a posição correta. [cite: 7]
         * @param valor O valor inteiro a ser inserido.
         */
        @Override
        public void inserir(int valor) {
            this.raiz = inserirRecursivo(this.raiz, valor);
        }
    
        /**
         * Método auxiliar recursivo para inserir um novo nó. A lógica segue o pseudocódigo "função insere". 
         * Se a subárvore atual é nula, o novo nó é inserido aqui.
         * Caso contrário, a busca continua recursivamente pela subárvore esquerda ou direita. [cite: 1, 7]
         * @param noAtual O nó raiz da subárvore atual.
         * @param valor O valor a ser inserido.
         * @return O nó raiz da subárvore modificada.
         */
        private NodoArvore inserirRecursivo(NodoArvore noAtual, int valor) {
    
            // Caso base: se a árvore (ou subárvore) estiver vazia, cria o novo nó.
            if (noAtual == null) {
                return new NodoArvore(valor);
            }
    
            // Caso recursivo: desce na árvore
            if (valor < noAtual.chave) {
                noAtual.filhoEsquerda = inserirRecursivo(noAtual.filhoEsquerda, valor);
            } else if (valor > noAtual.chave) {
                noAtual.filhoDireita = inserirRecursivo(noAtual.filhoDireita, valor);
            }
            return noAtual;
            // Se o valor já existe, não faz nada e retorna o nó como está.
            
        }
    
        
    
        /**
         * --- MÉTODO DE PESQUISA ---
         * Método público para pesquisar um valor na árvore.
         * @param valor O valor a ser procurado.
         * @return O nó que contém o valor, ou null se não for encontrado.
         */
        @Override
        public NodoArvore pesquisa(int valor) {
            return pesquisaRecursivo(this.raiz, valor);
        
        }
     private NodoArvore pesquisaRecursivo(NodoArvore noAtual,int valor){
        if (noAtual == null|| noAtual.chave == valor){
            return noAtual;
        }
        if (valor < noAtual.chave){
            return pesquisaRecursivo(noAtual.filhoEsquerda, valor);
        }
        else{
            return pesquisaRecursivo(noAtual.filhoDireita, valor);
        }
     
     }
       
        
        // --- MÉTODO DE IMPRESSÃO (CAMINHAMENTO) ---
        
        /**
         * Imprime os elementos da árvore usando o caminhamento pré-fixado. [cite: 7]
         * Raiz -> Esquerda -> Direita. 
         */
    //    @Override
        /*public void PreFixadoRecursivo (NodoArvore noAtual) {
            if(noAtual != null){
                System.out.print(noAtual.valor + " ");
                prefixado(noAtual.filhoEsquerda);
                prefixado(noAtual.filhoDireita);
            }
        }*/
        
        /**
         * Método auxiliar recursivo para o caminhamento pré-fixado.
         * @param no O nó raiz da subárvore a ser impressa.
         */
    
         @Override
         public void imprimePreFixado() {
             imprimePreFixadoRecursivo(this.raiz);
         }
    
         
        //prefixado 
        public void imprimePreFixadoRecursivo(NodoArvore noAtual) {
            if (noAtual != null) {
                System.out.print(noAtual.chave + " ");       // visita raiz
                imprimePreFixadoRecursivo(noAtual.filhoEsquerda);     // recursão esquerda
                imprimePreFixadoRecursivo(noAtual.filhoDireita);      // recursão direita
            }
        }
    
        @Override
        public void remover(int valor) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    
    
    
        
        public void imprimePosFixado(NodoArvore noAtual) {
        if (noAtual != null) {
            imprimePosFixado(noAtual.filhoEsquerda);     // recursão esquerda
            imprimePosFixado(noAtual.filhoDireita);      // recursão direita
            System.out.print(noAtual.chave + " ");       // visita raiz
        }
    }
    
    
    
        }