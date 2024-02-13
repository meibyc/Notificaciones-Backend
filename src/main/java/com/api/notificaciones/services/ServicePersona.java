package com.api.notificaciones.services;

import com.api.notificaciones.models.PersonaModel;
import com.api.notificaciones.repositories.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePersona {

    @Autowired
    private IPersonaRepository personaRepository;


    public List<PersonaModel> listarPersonas() {
        return  personaRepository.findAll();
    }

    public PersonaModel savePersona(PersonaModel personaModel){
        return  personaRepository.save(personaModel);

    }
    public Optional<PersonaModel> getById(Long id){
        return personaRepository.findById(id);
    }
    public Optional<PersonaModel> getByuser(String user){
        return personaRepository.findByNickName(user);
    }

    public PersonaModel updatePersonaByid(PersonaModel personaModel, Long id){
        PersonaModel persona=  personaRepository.findById(id).get();
        persona.setContrasena(personaModel.getContrasena());
        persona.setDocumento(personaModel.getDocumento());
        persona.setNombre(personaModel.getNombre());
        persona.setNickName(personaModel.getNickName());
        persona.setTipoDocumento(personaModel.getTipoDocumento());

        return personaRepository.save(persona);

    }
    public boolean deletePersona(Long id){
        try{
            personaRepository.deleteById(id);
            return  true;
        }catch (Exception e){
            return false;
        }

    }
    public Optional<PersonaModel> getDocumentPerson(String tipoD, String documento){
      return  personaRepository.findByDocumentoAndTipoDocumento(documento,tipoD);
    }
}
