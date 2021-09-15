package com.poo.lista1.exe5;

/**
 * 
 * @author Rafael Barbosa Kretzer
 *
 */
public class InteiroPositivo {
    
	private int x;

    public void setValor(int valor){
        if (valor >= 0){
            this.x = valor;
        }
    }

    public int getValorMultiplicado(InteiroPositivo inteiroPositivo) {
        return this.x * inteiroPositivo.getValor();
    }
    
    public int getValor(){
        return this.x;
    }
    
    public long fatorialX() {
        long fatorial = 1;
        
        for (int i = 1; i <= this.x; i++) {
            fatorial *= i;
        }    
        return fatorial;
    }    
    
    public String divisoresInteiros() {
        String divisores = "Os divisores são"; 
        int count = 0;
        if (this.x != 0) {
            for (int i = 1; i <= this.x; i++) {
                if (this.x % i == 0) {
                    count++;
                    divisores += " " + i + ",";
                }    
            }
        } else {
            divisores += " 0";    
        }    
        divisores = divisores.substring(0, divisores.lastIndexOf(",")) + " e a quantidade de divisores é "+count+".";
        return divisores;
    } 
    
    public int[] fibonacci() {
        int[] resultado = new int[this.x];
        if (this.x != 0) {
            int anterior = 0;
            int atual = 1;
            resultado[0] = 1;
            for (int i = 1; i < this.x; i++){
                resultado[i] = anterior + atual;
                anterior = atual;
                atual = resultado[i];
            }
        }    
        return resultado;
    }    
    
    public double valorH() {
        if (this.x != 0) {
            double valorH = 1.0;
            for (int i = 2; i <= this.x; i++) {
                valorH += 1/(double)i;
            }
            return valorH;
        }   
        return 0;
    }
    
    public double valorI() {
        if (this.x != 0) {
            double valorI = 0;
            for (int i = 0; i < this.x; i++) {
                valorI += (1+(double)i)/(this.x-(double)i);
            }  
            return valorI;
        }
        return 0;
    } 
    
    public long fatorial(int valor) {
        long fatorial = 1;
        
        for (int i = 1; i <= valor; i++) {
            fatorial *= i;
        }    
        return fatorial;
    }
    
    public double valorP() {
        if (this.x != 0) {
            int pa = 2;
            double valorPmenor =0;
            double valorP = 0;
            for (int i = 1; i <= this.x;i++) {
                if (i % 2 != 0) {
                   valorP += i / (double) (fatorial(pa));
                } else {
                   valorPmenor +=  i / (double) fatorial(pa);
                }
                pa += 2;
            }
            return valorP-valorPmenor;
        }
        return 0;
    }
}
