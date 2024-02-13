package com.api.notificaciones.controllers;

import com.api.notificaciones.models.ComparendoModel;
import com.api.notificaciones.models.DerechosModel;
import com.api.notificaciones.models.PersonaModel;
import com.api.notificaciones.services.DerechosService;
import com.api.notificaciones.services.ServicePersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/derechos")
public class DerechosController {

  @Autowired
    private DerechosService derechosService;
    @Autowired
    private ServicePersona personaService;

    @GetMapping
    public List<DerechosModel> derechos(){
        return  this.derechosService.listarDerechos();
    }
    @PostMapping
    public DerechosModel savePersona(@RequestBody DerechosModel derechosModel){
       return   this.derechosService.saveDerechos(derechosModel);
    }
    @GetMapping(path = "/{id}")
    public Optional<DerechosModel> getDerechosById(@PathVariable Long id){
        return  this.derechosService.getById(id);
    }
    @PutMapping(path = "/{id}")
    public DerechosModel updatePersonasById(@RequestBody DerechosModel derechosModel,@PathVariable Long id){
        return  this.derechosService.updateDerechosByid(derechosModel,id);
    }
    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable Long id) {
       boolean ok=this.derechosService.deleteDerechos(id);
       if(ok){
           return  "Derecho de transito con id "+id+"fue eliminado";
       }else{
           return  "Error eliminando Derecho de transito on id "+id;
       }
    }
    @GetMapping(path = "derechosdocumento/{tipoD}/{document}")
    public List<DerechosModel> getComparendoByPersona(@PathVariable String tipoD,@PathVariable String document){
        Optional<PersonaModel>personaModel=  this.personaService.getDocumentPerson(tipoD,document);
        if (personaModel.isPresent()) {
            return  this.derechosService.findByPersonaId(personaModel.get().getIdPersona());
        } else {
            return Collections.emptyList();


        }

    }
    @GetMapping(path = "derechosplaca/{placa}")
    public List<DerechosModel> getDerechosByPlaca(@PathVariable String placa){
        return  this.derechosService.getByPlaca(placa);
    }

}
