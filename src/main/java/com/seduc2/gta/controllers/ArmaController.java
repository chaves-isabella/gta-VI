package com.seduc2.gta.controllers;

import com.seduc2.gta.entities.Arma;
import com.seduc2.gta.services.ArmaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/armas")
public class ArmaController {

    private final ArmaService armaService;

    public ArmaController(ArmaService armaService) {
        this.armaService = armaService;
    }

    @GetMapping
    public List<Arma> mostrar (){
        return armaService.buscarTodos();
    }

    @PostMapping
    public void cadastrar (@RequestBody Arma a){
        armaService.cadastrar(a);
    }

    @DeleteMapping ("/{id}")
    public void deletar (@PathVariable Long id){
        armaService.deletar(id);
    }

    @PutMapping ("/{id}")
    public void alterar (@PathVariable Long id, @RequestBody Arma a){
        armaService.alterar(id, a);
    }
}
