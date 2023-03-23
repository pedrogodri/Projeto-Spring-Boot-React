package br.com.api.produtos.servico;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import org.springframework.stereotype.Service;
import br.com.api.produtos.modelo.ProdutoModelo;

import br.com.api.produtos.repositorio.IProdutoRepositorio;

@Service
public class ProdutoServico {
    
    @Autowired
    private IProdutoRepositorio produtoRepositorio;

    // Método para listar todos os produtos;
    public Iterable<ProdutoModelo> listar() {
        return produtoRepositorio.findAll();
    }
}
