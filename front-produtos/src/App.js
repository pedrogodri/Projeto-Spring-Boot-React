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

  // Retorno
  return (
    <div>
      <div>{JSON.stringify(objProduto)}</div>
      <Formulario botao={btnCadastrar} />
      <Tabela vetor={produtos} />
    </div>
  );
}

export default App;
