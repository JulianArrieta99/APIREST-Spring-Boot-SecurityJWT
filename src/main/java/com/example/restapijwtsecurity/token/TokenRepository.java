package com.example.restapijwtsecurity.token;

import com.example.restapijwtsecurity.token.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
/**
    @param select t from Token t: seleccionando objeto de la entidad Token y lo llamamos t como alias
    @param inner join User u on t.user.id = u.id: Realizando una unión interna entre las tablas Token y User utilizando la condición de que el campo id de User sea igual al campo user.id de Token. Esto significa que estamos relacionando tokens con sus usuarios correspondientes.
    @param where u.id = :userId: Esto filtra los resultados para que solo se incluyan aquellos tokens que pertenecen a un usuario específico cuyo ID es proporcionado como parámetro userId. El valor de :userId se espera que sea proporcionado cuando ejecutes la consulta.
    @param and (t.expired = false or t.revoke = false): Esta es la cláusula condicional final. Está diciendo que el token no debe estar expirado (expired es false) o no debe haber sido revocado (revoke es false). estamos buscando tokens que estén activos, osea, no expirados y no revocados.
 */

    @Query("""
    select t from Token t inner join User u on t.user.id = u.id
    where u.id = :userId and (t.expired = false or t.revoked = false)
""")
    List<Token> findAllValidTokensByUser(Long userId);

    Optional<Token> findByToken(String token);



}