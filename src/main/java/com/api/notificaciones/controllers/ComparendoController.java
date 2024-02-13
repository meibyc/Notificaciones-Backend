package com.api.notificaciones.controllers;

import com.api.notificaciones.models.ComparendoModel;
import com.api.notificaciones.models.PersonaModel;
import com.api.notificaciones.services.ComparendoService;
import com.api.notificaciones.services.ServicePersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/comparendos")
public class ComparendoController {

  @Autowired
    private ComparendoService comparendoService;

    @Autowired
    private ServicePersona personaService;

    @GetMapping
    public List<ComparendoModel> comparendos(){
        return  this.comparendoService.listarComparendos();
    }
    @PostMapping
    public ComparendoModel savePersona(@RequestBody ComparendoModel comparendoModel){
       return   this.comparendoService.saveComparendo(comparendoModel);
    }
    @GetMapping(path = "/{id}")
    public Optional<ComparendoModel> getComparendoById(@PathVariable Long id){
        return  this.comparendoService.getById(id);
    }
    @PutMapping(path = "/{id}")
    public ComparendoModel updatePersonasById(@RequestBody ComparendoModel comparendoModel,@PathVariable Long id){
        return  this.comparendoService.updateComparendoByid(comparendoModel,id);
    }
    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable Long id) {
       boolean ok=this.comparendoService.deleteComparendo(id);
       if(ok){
           return  "Comparendo con id "+id+"fue eliminado";
       }else{
           return  "Error eliminando Comparendo on id "+id;
       }
    }
    @GetMapping(path = "comparendodocumento/{tipoD}/{document}")
    public List<ComparendoModel> getComparendoByPersona(@PathVariable String tipoD,@PathVariable String document){
        Optional<PersonaModel>personaModel=  this.personaService.getDocumentPerson(tipoD,document);
        if (personaModel.isPresent()) {
            return  this.comparendoService.findByPersonaId(personaModel.get().getIdPersona());
        } else {
            return Collections.emptyList();

        }

    }

}
