package com.api.notificaciones.services;

import com.api.notificaciones.models.ComparendoModel;
import com.api.notificaciones.models.DerechosModel;
import com.api.notificaciones.repositories.IDerechosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DerechosService {

    @Autowired
    private IDerechosRepository derechosRepository;


    public List<DerechosModel> listarDerechos() {
        return  derechosRepository.findAll();
    }

    public DerechosModel saveDerechos(DerechosModel derechosModel){
        return  derechosRepository.save(derechosModel);

    }
    public Optional<DerechosModel> getById(Long id){
        return derechosRepository.findById(id);
    }
    public List<DerechosModel> getByPlaca(String placa){
        return derechosRepository.findByPlacaVehiculo(placa);
    }


    public DerechosModel updateDerechosByid(DerechosModel derechosModel, Long id){
        DerechosModel derechosModel1=  derechosRepository.findById(id).get();
        derechosModel1.setPlacaVehiculo(derechosModel.getPlacaVehiculo());
        derechosModel1.setVigencia(derechosModel.getVigencia());
        derechosModel1.setIdPersona(derechosModel.getIdPersona());
        derechosModel1.setValor(derechosModel.getValor());
        return derechosRepository.save(derechosModel1);

    }
    public boolean deleteDerechos(Long id){
        try{
            derechosRepository.deleteById(id);
            return  true;
        }catch (Exception e){
            return false;
        }

    }
    public List<DerechosModel> findByPersonaId(Long id){
        return derechosRepository.findByPersonaId(id);
    }

}
