package br.com.ifpe.oxefood.modelo.produto;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import br.com.ifpe.oxefood.util.entity.GenericService;

@Service
public class ProdutoService extends GenericService {

    @Autowired
    private ProdutoRepository repository;

    @Transactional
    public Produto save(Produto produto) {

        super.preencherCamposAuditoria(produto);
        return repository.save(produto);
    }

    public List<Produto> listarTodos() {

        return repository.findAll();
    }

    public Produto obterPorID(Long id) {

        return repository.findById(id).get();
    }

    // codigo, descricao, tempo_entrega_maximo, tempo_entrega_minimo, titulo, valor_unitario

    @Transactional
    public void update(Long id, Produto produtoAlterado) {
 
       Produto produto = repository.findById(id).get();
       produto.setCodigo(produtoAlterado.getCodigo());
       produto.setDescricao(produtoAlterado.getDescricao());
       produto.setTempoEntregaMaximo(produtoAlterado.getTempoEntregaMaximo());
       produto.setTempoEntregaMinimo(produtoAlterado.getTempoEntregaMinimo());
       produto.setTitulo(produtoAlterado.getTitulo());
       produto.setValorUnitario(produtoAlterado.getValorUnitario());
         
       super.preencherCamposAuditoria(produto);
       repository.save(produto);
   }

    @Transactional
   public void delete(Long id) {

       Produto produto = repository.findById(id).get();
       produto.setHabilitado(Boolean.FALSE);
       super.preencherCamposAuditoria(produto);

       repository.save(produto);
   }

}
