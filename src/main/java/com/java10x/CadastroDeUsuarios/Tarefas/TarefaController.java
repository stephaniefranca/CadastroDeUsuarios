package com.java10x.CadastroDeUsuarios.Tarefas;
import com.java10x.CadastroDeUsuarios.Usuarios.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation (summary = "Listar todas as tarefas", description = "Essa rota lista todas as tarefas cadastrados no banco de dados")
        public List<TarefaModel> listarTarefas(){
            return tarefaService.listarTarefas();
        }

    //POST - mandar um requisiçao para CRIAR as tarefas
    @PostMapping("/criar")
    @Operation (summary = "Criar tarefas", description = "Essa rota cria uma nova tarefa e insere no banco de dados.")
        public TarefaModel criarTarefa(@RequestBody TarefaModel tarefa){
            return tarefaService.criarTarefa(tarefa);
        }

    //PUT - mandar um requisiçao para ALTERAR as tarefas
    @PutMapping("/alterar/{id}")
    @Operation (summary = "Altera a tarefa por ID", description = "Essa rota altera uma tarefa pelo seu ID")
    public TarefaModel alterarTarefa(@PathVariable Long id,@RequestBody TarefaModel tarefaAtualizada){
        return tarefaService.alterarTarefa(id, tarefaAtualizada);
    }


    //DELETE - mandar um requisiçao para DELETAR as tarefas
    @DeleteMapping("/deletar/{id}")
    @Operation (summary = "Deleta uma tarefa por ID", description = "Essa rota deleta uma tarefa pelo seu ID")
    public void  deletarTarefaPorId(@PathVariable Long id){
         tarefaService.deletarTarefaPorId(id);
    }


}
