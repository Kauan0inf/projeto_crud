package br.com.anm.crud_projetos.projeto_crud.controle;

import org.springframework.web.bind.annotation.RestController;

import br.com.anm.crud_projetos.projeto_crud.modelo.ProdutoModelo;
import br.com.anm.crud_projetos.projeto_crud.modelo.RespostaModelo;
import br.com.anm.crud_projetos.projeto_crud.servico.ProdutoServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ProdutoControle {

  @Autowired
  private ProdutoServico ps;

  @DeleteMapping("/remover/{codigo}")
  public ResponseEntity<RespostaModelo> remover(long codigo) {
    return ps.remover(codigo);
  }

  // @PostMapping("/cadastrar")
  @PostMapping("/cadastrar")
  public ResponseEntity<?> cadastrar(@RequestBody ProdutoModelo pm) {
    return ps.cadastrarAlterar(pm, "cadastrar");
  }

  @PutMapping("/alterar")
  public ResponseEntity<?> alterar(@RequestBody ProdutoModelo pm) {
    return ps.cadastrarAlterar(pm, "alterar");
  }

  @GetMapping("/listar")
  public Iterable<ProdutoModelo> listar() {
    return ps.listar();
  }

  @GetMapping("/")
  public String rota() {
    return "A API está funcionando!";
  }
  

}