package br.com.cadastroPessoas.api.controller;


import br.com.cadastroPessoas.api.endereco.Endereco;
import br.com.cadastroPessoas.api.endereco.EnderecoServico;
import br.com.cadastroPessoas.api.pessoa.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadastropessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private EnderecoServico enderecoServico;

    @PostMapping
    public @ResponseBody Pessoa create(@RequestBody Pessoa pessoa) {
        for (Endereco enderecos : pessoa.getEnderecos()) {
            enderecoServico.save(enderecos);
        }
        return pessoaService.save(pessoa);
    }
/*
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPessoa dados) {
        repository.save(new Pessoa(dados));

    } */
    @GetMapping
    public List<Pessoa> listar(){
        return repository.findAll();
    }


    @PutMapping
    @org.springframework.transaction.annotation.Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPessoa dados) {
        var pessoa = repository.getReferenceById(dados.id());
        pessoa.atualizarInformacoes(dados);
    }

}