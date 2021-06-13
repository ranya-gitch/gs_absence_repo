package com.ensah.core.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ensah.core.bo.Auteur;

public interface IAuteurDao extends JpaRepository<Auteur, Long> , GenericJpa<Auteur, Long> {

}
