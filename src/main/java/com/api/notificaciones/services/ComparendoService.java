package com.api.notificaciones.services;

import com.api.notificaciones.models.ComparendoModel;
import com.api.notificaciones.repositories.IComparendoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComparendoService {

    @Autowired
    private IComparendoRepository comparendoRepository;


    public List<ComparendoModel> listarComparendos() {
        return  comparendoRepository.findAll();
    }

    public ComparendoModel saveComparendo(ComparendoModel comparendoModel){
        return  comparendoRepository.save(comparendoModel);

    }
    public Optional<ComparendoModel> getById(Long id){
        return comparendoRepository.findById(id);
    }

    public ComparendoModel updateComparendoByid(ComparendoModel comparendoModel, Long id){
        ComparendoModel comparendo=  comparendoRepository.findById(id).get();
        comparendo.setFechaComparendo(comparendoModel.getFechaComparendo());
        comparendo.setNumeroComparendo(comparendoModel.getNumeroComparendo());
        comparendo.setIdPersona(comparendoModel.getIdPersona());
        comparendo.setDescripcion(comparendoModel.getDescripcion());
        comparendo.setFechaNotificacion(comparendoModel.getFechaNotificacion());
        comparendo.setTipo(comparendoModel.getTipo());
        comparendo.setValor(comparendoModel.getValor());

        return comparendoRepository.save(comparendo);

    }
    public boolean deleteComparendo(Long id){
        try{
            comparendoRepository.deleteById(id);
            return  true;
        }catch (Exception e){
            return false;
        }

    }
    public List<ComparendoModel> findByPersonaId(Long id){
        return comparendoRepository.findByPersonaId(id);
    }

}
