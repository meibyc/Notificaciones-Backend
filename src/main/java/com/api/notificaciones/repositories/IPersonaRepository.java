package com.api.notificaciones.repositories;

import com.api.notificaciones.models.PersonaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPersonaRepository extends JpaRepository<PersonaModel,Long> {
    @Query("SELECT p FROM PersonaModel p WHERE p.documento = :documento AND p.tipoDocumento = :tipoDocumento")
    Optional<PersonaModel> findByDocumentoAndTipoDocumento(@Param("documento") String documento, @Param("tipoDocumento") String tipoDocumento);

    @Query("SELECT p FROM PersonaModel p WHERE p.nickName = :nickName")
    Optional<PersonaModel> findByNickName(@Param("nickName") String nickName);
}