package com.java10x.CadastroDeUsuarios.Tarefas;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    private TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository){
        this.tarefaRepository = tarefaRepository;
    }

    // Listar tarefas
    public List<TarefaModel> listarTarefas(){
        return tarefaRepository.findAll();
    }

    // Criar tarefa
    public TarefaModel criarTarefa(TarefaModel tarefa){
       return tarefaRepository.save(tarefa);
    }

    //Deletar Tarefa
    public void deletarTarefaPorId(Long id){
        tarefaRepository.deleteById(id);
    }

    //Alterar tarefa
    public TarefaModel alterarTarefa(Long id, TarefaModel tarefaAtualizada){
        if (tarefaRepository.existsById(id)){
            tarefaAtualizada.setId(id);
            return tarefaRepository.save(tarefaAtualizada);
        }
        else {
            return null;
        }
    }

}
