package com.java10x.CadastroDeUsuarios.Tarefas;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tarefas")
public class TarefaController {


    //GET - mandar um requisiçao para MOSTRAR as tarefas
    @GetMapping("/listar")
        public String listarTarefas(){
            return "Tarefas listadas";
        }

    //POST - mandar um requisiçao para CRIAR as tarefas
    @PostMapping("/criar")
        public String criarTarefa(){
            return "Terafa criada";
        }

    //PUT - mandar um requisiçao para ALTERAR as tarefas
    @PutMapping("/alterar")
    public String alterarTarefa(){
        return "Terafa alterada";
    }


    //DELETE - mandar um requisiçao para DELETAR as tarefas
    @DeleteMapping("/deletar")
    public String deletarTarefa(){
        return "Terafa deletada";
    }


}
