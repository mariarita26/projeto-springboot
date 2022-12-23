package com.example.demo.model.service;

import com.example.demo.model.entity.Pessoa;
import com.example.demo.model.repository.PessoaIF;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
public class PessoaServiceTeste {

    @InjectMocks
    private PessoaService pessoaService;

    @Mock
    private PessoaIF pessoaIF;


    private Pessoa pessoa;

    @Before
    public void setup() {
        this.pessoa = new Pessoa();
        pessoa.setNome("Paulo");
        pessoa.setId(1L);
        pessoa.setCpf("12121212156");
        pessoa.setTelefone("83995864217");
        pessoa.setImagem("null");
        pessoa.setSenha("paulopistolinha");
        pessoa.setEmail("paulopistolinha@gmail.com");
    }

    @Test
    public void deveEncontrarPessoaComSucesso() {
        Mockito.when(pessoaIF.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(this.pessoa));

        Pessoa pessoaEncontrada = this.pessoaService.getPessoaPorId(this.pessoa.getId());

        Assertions.assertEquals(pessoaEncontrada.getId(), this.pessoa.getId());
        Assertions.assertEquals(pessoaEncontrada.getNome(), this.pessoa.getNome());
        Assertions.assertEquals(pessoaEncontrada.getCpf(), this.pessoa.getCpf());
        Assertions.assertEquals(pessoaEncontrada.getTelefone(), this.pessoa.getTelefone());
        Assertions.assertEquals(pessoaEncontrada.getImagem(), this.pessoa.getImagem());
        Assertions.assertEquals(pessoaEncontrada.getSenha(), this.pessoa.getSenha());
        Assertions.assertEquals(pessoaEncontrada.getEmail(), this.pessoa.getEmail());
    }

    @Test
    public void deveInserirOuAtualizarPessoa() {
        Mockito.when(pessoaIF.save(Mockito.any(Pessoa.class))).thenReturn(this.pessoa);

        Pessoa pessoaInserida = this.pessoaService.inserirOuAtualizar(this.pessoa);

        Assertions.assertEquals(pessoaInserida.getId(), this.pessoa.getId());
        Assertions.assertEquals(pessoaInserida.getNome(), this.pessoa.getNome());
        Assertions.assertEquals(pessoaInserida.getCpf(), this.pessoa.getCpf());
        Assertions.assertEquals(pessoaInserida.getTelefone(), this.pessoa.getTelefone());
        Assertions.assertEquals(pessoaInserida.getImagem(), this.pessoa.getImagem());
        Assertions.assertEquals(pessoaInserida.getSenha(), this.pessoa.getSenha());
        Assertions.assertEquals(pessoaInserida.getEmail(), this.pessoa.getEmail());
    }

    @Test
    public void deveApagarPessoa() {
        pessoaService.apagar(this.pessoa.getId());

        Mockito.verify(pessoaIF).deleteById(Mockito.anyLong());
    }
}
