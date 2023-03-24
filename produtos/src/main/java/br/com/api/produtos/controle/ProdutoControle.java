package br.com.api.produtos.controle;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import br.com.api.produtos.modelo.ProdutoModelo;
import br.com.api.produtos.modelo.RespostaModelo;
import br.com.api.produtos.servico.ProdutoServico;

@RestController
@CrossOrigin(origins = "*")
public class ProdutoControle {
    
    @Autowired
    private ProdutoServico produtoServico;

    @DeleteMapping("/remover/{codigo}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable long codigo) {
        return produtoServico.remover(codigo);
    }

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
