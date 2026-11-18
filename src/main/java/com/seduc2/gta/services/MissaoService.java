package com.seduc2.gta.services;

import com.seduc2.gta.entities.Missao;
import com.seduc2.gta.repositories.MissaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class MissaoService {

    private final MissaoRepository missaoRepository;
    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    public List<Missao> buscarTodos (){
        List<Missao> missoes = new ArrayList<>();
        return missaoRepository.findAll();
    }

    public void cadastrar (Missao m) {
        Missao missao = new Missao(m.getNome(), m.getLocal(), m.getDificuldade(), m.getDescricao(), m.getImagem());
        missaoRepository.save(missao);
    }

    public void deletar (@PathVariable Long id){
        missaoRepository.deleteById(id);
    }

    @Transactional
    public void alterar (@PathVariable Long id, @RequestBody Missao m){
        Missao missao = missaoRepository.getReferenceById(id);
        missao.setNome(m.getNome());
        missao.setLocal(m.getLocal());
        missao.setDescricao(m.getDescricao());
        missao.setImagem(m.getImagem());
        missao.setDificuldade(m.getDificuldade());
    }
}
