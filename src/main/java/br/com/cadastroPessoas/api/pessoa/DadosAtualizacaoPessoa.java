package br.com.cadastroPessoas.api.pessoa;

import br.com.cadastroPessoas.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPessoa(

        @NotNull
        Long id,
        String nome,
        String dataNascimento,
        DadosEndereco enderecos
) {
}
