package com.seduc2.gta.controllers;

import com.seduc2.gta.entities.Veiculo;
import com.seduc2.gta.services.VeiculoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping
    public List<Veiculo> mostrar (){
        return veiculoService.buscarTodos();
    }

    @PostMapping
    public void cadastrar (@RequestBody Veiculo c){
        veiculoService.cadastrar(c);
    }

    @DeleteMapping ("/{id}")
    public void deletar (@PathVariable Long id) {
        veiculoService.deletar(id);
    }

    @PutMapping ("/{id}")
    public void alterar (@PathVariable Long id, @RequestBody Veiculo c){
        veiculoService.alterar(id, c);
    }
}
