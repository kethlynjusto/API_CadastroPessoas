package br.com.cadastroPessoas.api.pessoa;

import br.com.cadastroPessoas.api.endereco.EnderecoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }
    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }
        //outros metodos
}



    /*
    public Pessoa salvarEnderecos(Long idPessoa, List<Endereco> enderecos) {
        Pessoa pessoa = pessoaRepository.findById(idPessoa).get();
        pessoa.getEnderecos();
        for(Endereco endereco:enderecos) {
            enderecoRepository.save(endereco);
        }
        return pessoaRepository.save(pessoa);
    }

     */
