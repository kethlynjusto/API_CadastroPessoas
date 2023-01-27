package br.com.cadastroPessoas.api.pessoa;

import br.com.cadastroPessoas.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroPessoa(
        @NotBlank
        String nome,
        @NotBlank
        @Pattern(regexp="\\d{2}/\\d{2}/\\d{4}")
        String dataNascimento,
        @Valid
        DadosEndereco enderecos) {}


