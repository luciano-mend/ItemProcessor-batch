package br.luciano.ItemProcessor_batch.dominio;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

public class Cliente {
    @NotNull
    @Size(min = 1, max = 100)
    @Pattern(regexp = "[a-zA-Z\\s]+", message = "Nome deve ser alfabético")
    private String nome;
    @NotNull
    @Range(min = 18, max = 200, message = "Idade deve estar entre 18 e 200 anos")
    private Integer idade;
    @NotNull
    @Size(min = 1, max = 50)
    @Email(message = "Email inválido")
    private String email;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + "'" +
                ", idade='" + idade + "'" +
                ", email='" + email + "'" +
                '}';
    }
}
