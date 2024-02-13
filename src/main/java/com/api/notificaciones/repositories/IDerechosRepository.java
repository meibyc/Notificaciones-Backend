package com.api.notificaciones.repositories;

import com.api.notificaciones.models.ComparendoModel;
import com.api.notificaciones.models.DerechosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IDerechosRepository extends JpaRepository<DerechosModel,Long> {
    @Query("SELECT c FROM DerechosModel c WHERE c.idPersona = :idPersona")
    List<DerechosModel> findByPersonaId(@Param("idPersona") Long idPersona);


    @Query("SELECT d FROM DerechosModel d WHERE d.placaVehiculo = :placaVehiculo")
    List<DerechosModel> findByPlacaVehiculo(@Param("placaVehiculo") String placaVehiculo);
}