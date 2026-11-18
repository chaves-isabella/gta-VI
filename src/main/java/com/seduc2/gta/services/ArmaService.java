package com.seduc2.gta.services;

import com.seduc2.gta.entities.Arma;
import com.seduc2.gta.repositories.ArmaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArmaService {

    private final ArmaRepository armaRepository;
    public ArmaService(ArmaRepository armaRepository) {
        this.armaRepository = armaRepository;
    }

    public List<Arma> buscarTodos (){
        List<Arma> armas = new ArrayList<>();
        return armaRepository.findAll();
    }

    public void cadastrar (Arma a) {
        Arma arma = new Arma(a.getNome(), a.getCategoria(), a.getFabricante(), a.getImagem(), a.getImagem());
        armaRepository.save(arma);
    }

    public void deletar (@PathVariable Long id){
        armaRepository.deleteById(id);
    }

    @Transactional
    public void alterar (@PathVariable Long id, @RequestBody Arma a){
        Arma arma = armaRepository.getReferenceById(id);
        arma.setNome(a.getNome());
        arma.setCategoria(a.getCategoria());
        arma.setDescricao(a.getDescricao());
        arma.setImagem(a.getImagem());
        arma.setFabricante(a.getFabricante());
    }
}
