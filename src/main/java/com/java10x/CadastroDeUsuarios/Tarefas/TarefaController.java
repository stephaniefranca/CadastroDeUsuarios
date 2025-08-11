package com.java10x.CadastroDeUsuarios.Tarefas;
import com.java10x.CadastroDeUsuarios.Usuarios.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tarefas")
public class TarefaController {

    private TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    //GET - mandar um requisiçao para MOSTRAR as tarefas
    @GetMapping("/listar")
        public List<TarefaModel> listarTarefas(){
            return tarefaService.listarTarefas();
        }

    //POST - mandar um requisiçao para CRIAR as tarefas
    @PostMapping("/criar")
        public TarefaModel criarTarefa(@RequestBody TarefaModel tarefa){
            return tarefaService.criarTarefa(tarefa);
        }

    //PUT - mandar um requisiçao para ALTERAR as tarefas
    @PutMapping("/alterar/{id}")
    public TarefaModel alterarTarefa(@PathVariable Long id,@RequestBody TarefaModel tarefaAtualizada){
        return tarefaService.alterarTarefa(id, tarefaAtualizada);
    }


    //DELETE - mandar um requisiçao para DELETAR as tarefas
    @DeleteMapping("/deletar/{id}")
    public void  deletarTarefaPorId(@PathVariable Long id){
         tarefaService.deletarTarefaPorId(id);
    }


}
