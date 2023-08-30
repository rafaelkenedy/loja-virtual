package modelo;

import lombok.Data;

@Data
public class Produto {
    private Integer id;
    private String nome;
    private String descricao;

    public Produto(Integer id, String nome, String descricao){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }
    public Produto(String nome, String descricao) {
        super();
        this.nome = nome;
        this.descricao = descricao;
    }
}
