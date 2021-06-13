package com.ensah.core.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ensah.core.bo.Livre;

public interface ILivreDao extends JpaRepository<Livre, Long>, ILivreDaoCustom , GenericJpa<Livre, Long>{

}
