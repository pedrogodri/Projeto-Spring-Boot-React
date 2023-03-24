package br.com.api.produtos.controle;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import br.com.api.produtos.modelo.ProdutoModelo;
import br.com.api.produtos.servico.ProdutoServico;

@RestController
public class ProdutoControle {
    
    @Autowired
    private ProdutoServico produtoServico;

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody ProdutoModelo produtoModelo) {
        return produtoServico.cadastrarAlterar(produtoModelo, "alterar");
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody ProdutoModelo produtoModelo) {
        return produtoServico.cadastrarAlterar(produtoModelo, "cadastrar");
    }

    @GetMapping("/listar")
    public Iterable<ProdutoModelo> listar() {
        return produtoServico.listar();
    }


    @GetMapping("/")
    public String Rota() {{
        return "API de produtos funcionando!";
    }}
}
