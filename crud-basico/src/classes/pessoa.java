/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author dbezerra
 */
public class pessoa {
    
    private String nome;
     private int  idade;
    private String cpf;


    public pessoa() {}
    
    public pessoa(String nome, int idade,String cpf){
    this.nome = nome;
    this.idade = idade;
    this.cpf = cpf;

    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String MostrarDados(){
        return "nome: " + getNome() + ", Idade: " + getIdade() + ", cpf:  " + getCpf();  
    
    }
    
}
