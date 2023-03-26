import { useEffect, useState } from 'react';
import './App.css';
import Formulario from './Formulario';
import Tabela from './Tabela';

function App() {

  // Pbjeto produto
  const produto = {
    codigo : 0,
    nome : '',
    marca : ''
  }

  // UseState
  const [btnCadastrar, setBtnCadastrar] = useState(true);
  const [produtos, setProdutos] = useState([]);
  const [objProduto, setObjProduto] = useState(produto);

  // UseEffect
  useEffect(() => {
    fetch("http://localhost:8080/listar")
    .then(retorno => retorno.json())
    .then(retornoConvertido => setProdutos(retornoConvertido));
  }, []);

  // Obtendo os dados do formulário
  const aoDigitar = (e) => {
    setObjProduto({...objProduto, [e.target.name]:e.target.value});
  }

  // Cadastrar produto
  const cadastrar = () => {
    fetch('http://localhost:8080/cadastrar', {
      method: 'post',
      body: JSON.stringify(objProduto),
      headers: {
        'Content-type':'application/json',
        'Accept':'application/json'
      }
    })
    .then(retorno => retorno.json())
    .then(retornoConvertido => {
      if(retornoConvertido.mensagem !== undefined) {
        alert(retornoConvertido.mensagem);
      } else {
        setProdutos([...produtos, retornoConvertido]);
        alert("Produto cadastrado com sucesso");
        limparFormulario();
      }
    });
  }

  // Remover produto
  const remover = () => {
    fetch(`http://localhost:8080/remover/${objProduto.codigo}`, {
      method: 'delete',
      headers: {
        'Content-type':'application/json',
        'Accept':'application/json'
      }
    })
    .then(retorno => retorno.json())
    .then(retornoConvertido => {
      
      //Mensagem
      alert(retornoConvertido.mensagem);

      //Cópia do vetor de produtos
      let vetorTemp = [...produtos];
      
      /// Indice
      let i = vetorTemp.findIndex((produto) => {
        return produto.codigo === objProduto.codigo;
      });

      // Remover produto do vetorTemp
      vetorTemp.splice(i, 1);

      // Atualizar o vetor de produtos
      setProdutos(vetorTemp);

      // Limpar formulário
      limparFormulario();

    });
  }

  // Limpar formulário
  const limparFormulario = () => {
    setObjProduto(produto);
    setBtnCadastrar(true);
  }

  // Selecionar produto
  const selecionarProduto = (i) => {
    setObjProduto(produtos[i]);
    setBtnCadastrar(false);
  }

  // Retorno
  return (
    <div>
      <Formulario 
        botao={btnCadastrar} 
        eventoTeclado={aoDigitar} 
        cadastrar={cadastrar} 
        obj={objProduto} cancelar={limparFormulario}
        remover={remover}
      />
      <Tabela 
        vetor={produtos} 
        selecionar={selecionarProduto} 
      />
    </div>
  );
}

export default App;
