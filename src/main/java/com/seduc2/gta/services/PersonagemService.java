package com.seduc2.gta.services;

import com.seduc2.gta.entities.Personagem;
import com.seduc2.gta.repositories.PersonagemRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonagemService {

    private final PersonagemRepository personagemRepository;
    public PersonagemService(PersonagemRepository personagemRepository) {
        this.personagemRepository = personagemRepository;
    }

    public List<Personagem> buscarTodos (){
        List<Personagem> personagens = new ArrayList<>();
        return personagemRepository.findAll();
    }

    public void cadastrar (Personagem p){
        Personagem personagem = new Personagem(p.getNome(), p.getCategoria(), p.getApelido(), p.getDescricao(), p.getImagem());
        personagemRepository.save(personagem);
    }

    public void deletar (@PathVariable Long id){
        personagemRepository.deleteById(id);
    }

    @Transactional
    public void alterar (@PathVariable Long id, @RequestBody Personagem p){
        Personagem personagem = personagemRepository.getReferenceById(id);
        personagem.setNome(p.getNome());
        personagem.setCategoria(p.getCategoria());
        personagem.setApelido(p.getApelido());
        personagem.setDescricao(p.getDescricao());
        personagem.setImagem(p.getImagem());
    }
}
