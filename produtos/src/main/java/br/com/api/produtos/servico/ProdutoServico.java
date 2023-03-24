package br.com.api.produtos.servico;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.api.produtos.modelo.ProdutoModelo;
import br.com.api.produtos.modelo.RespostaModelo;
import br.com.api.produtos.repositorio.IProdutoRepositorio;

@Service
public class ProdutoServico {
    
    @Autowired
    private IProdutoRepositorio produtoRepositorio;

    @Autowired
    private RespostaModelo respostaModelo;

    // Método para listar todos os produtos;
    public Iterable<ProdutoModelo> listar() {
        return produtoRepositorio.findAll();
    }

    // Método para cadastrar ou alterar produtos
    public ResponseEntity<?> cadastrarAlterar(ProdutoModelo produtoModelo, String acao) {
        if(produtoModelo.getNome().equals("")) {
            respostaModelo.setMensagem("O nome do produto é obrigatório!");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else if(produtoModelo.getMarca().equals("")) {
            respostaModelo.setMensagem("O nome da marca é obrigatório!");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else {
            if(acao.equals("cadastrar")) {
                return new ResponseEntity<ProdutoModelo>(produtoRepositorio.save(produtoModelo), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<ProdutoModelo>(produtoRepositorio.save(produtoModelo), HttpStatus.OK);
            }
        }
    }
}
