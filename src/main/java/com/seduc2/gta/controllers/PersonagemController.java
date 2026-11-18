package com.seduc2.gta.controllers;

import com.seduc2.gta.entities.Personagem;
import com.seduc2.gta.services.PersonagemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/personagens")
public class PersonagemController {

    private final PersonagemService personagemService;

    public PersonagemController(PersonagemService personagemService) {
        this.personagemService = personagemService;
    }

    @GetMapping
    public List<Personagem> mostrar (){
        return personagemService.buscarTodos();
    }

    @PostMapping
    public void cadastrar (@RequestBody Personagem p){
        personagemService.cadastrar(p);
    }

    @DeleteMapping ("/{id}")
    public void deletar (@PathVariable Long id){
        personagemService.deletar(id);
    }

    @PutMapping ("/{id}")
    public void alterar (@PathVariable Long id, @RequestBody Personagem p){
        personagemService.alterar(id, p);
    }
}
