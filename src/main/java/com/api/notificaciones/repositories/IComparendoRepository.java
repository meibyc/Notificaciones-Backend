package com.api.notificaciones.repositories;

import com.api.notificaciones.models.ComparendoModel;
import com.api.notificaciones.models.PersonaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IComparendoRepository extends JpaRepository<ComparendoModel,Long> {
    @Query("SELECT c FROM ComparendoModel c WHERE c.idPersona = :idPersona")
    List<ComparendoModel> findByPersonaId(@Param("idPersona") Long idPersona);

}