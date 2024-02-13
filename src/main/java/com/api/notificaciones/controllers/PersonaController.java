package com.api.notificaciones.controllers;

import com.api.notificaciones.models.PersonaModel;
import com.api.notificaciones.services.ServicePersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/personas")
public class PersonaController {

  @Autowired
    private ServicePersona personaService;


    @GetMapping
    public List<PersonaModel> personas(){
        return  this.personaService.listarPersonas();
    }
    @PostMapping
    public PersonaModel savePersona(@RequestBody PersonaModel personaModel){
       return   this.personaService.savePersona(personaModel);
    }
    @GetMapping(path = "/{id}")
    public Optional<PersonaModel> getPersonasById(@PathVariable Long id){
        return  this.personaService.getById(id);
    }


    @GetMapping(path = "documento/{tipoD}/{document}")
    public List<PersonaModel> getPersonasByDocument(@PathVariable String tipoD,@PathVariable String document){
        Optional<PersonaModel> personaOptional = this.personaService.getDocumentPerson(tipoD, document);
        if (personaOptional.isPresent()) {
            return Collections.singletonList(personaOptional.get());
        } else {
            return Collections.emptyList();

        }
    }
    @GetMapping(path = "login/{user}/{pass}")
    public String getPersonalogin(@PathVariable String user,@PathVariable String pass){
        Optional<PersonaModel> personaOptional = this.personaService.getByuser(user);
        if (personaOptional.isPresent()) {
            return personaOptional.get().getContrasena().equals(pass)?"ok":"noOk";
        } else {
            return"noOk";

        }
    }

    @PutMapping(path = "/{id}")
    public PersonaModel updatePersonasById(@RequestBody PersonaModel personaModel,@PathVariable Long id){
        return  this.personaService.updatePersonaByid(personaModel,id);
    }
    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable Long id) {
       boolean ok=this.personaService.deletePersona(id);
       if(ok){
           return  "Persona on id "+id+"fue eliminada";
       }else{
           return  "Error eliminando Persona on id "+id;
       }
    }

}
