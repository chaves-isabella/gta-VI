package com.seduc2.gta.controllers;

import com.seduc2.gta.entities.Missao;
import com.seduc2.gta.services.MissaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/missoes")
public class MissaoController {

    private final MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @GetMapping
    public List<Missao> mostrar (){
        return missaoService.buscarTodos();
    }

    @PostMapping
    public void cadastrar (@RequestBody Missao m){
        missaoService.cadastrar(m);
    }

    @DeleteMapping ("/{id}")
    public void deletar (@PathVariable Long id){
        missaoService.deletar(id);
    }

    @PutMapping ("/{id}")
    public void alterar (@PathVariable Long id, @RequestBody Missao m){
        missaoService.alterar(id, m);
    }

}
