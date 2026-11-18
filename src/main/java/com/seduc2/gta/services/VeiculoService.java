package com.seduc2.gta.services;

import com.seduc2.gta.entities.Veiculo;
import com.seduc2.gta.repositories.CarroRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class VeiculoService {

    private final CarroRepository carroRepository;
    public VeiculoService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    public List<Veiculo> buscarTodos (){
        List<Veiculo> carros = new ArrayList<>();
        return carroRepository.findAll();
    }

    public void cadastrar (Veiculo c){
        Veiculo carro = new Veiculo(c.getNome(), c.getCategoria(), c.getMarca(), c.getDescricao(), c.getImagem());
        carroRepository.save(carro);
    }

    public void deletar (@PathVariable Long id){
        carroRepository.deleteById(id);
    }

    @Transactional
    public void alterar (@PathVariable Long id, @RequestBody Veiculo c){
        Veiculo carro = carroRepository.getReferenceById(id);
        carro.setNome(c.getNome());
        carro.setCategoria(c.getCategoria());
        carro.setDescricao(c.getDescricao());
        carro.setImagem(c.getImagem());
        carro.setMarca(c.getMarca());
    }
}
