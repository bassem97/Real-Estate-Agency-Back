package com.wecode.realestateagency.Repositories;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.wecode.realestateagency.Models.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Observable;

@Repository
public interface LocalRepository extends JpaRepository<Local,Long> {
    @Query("SELECT l FROM Local l WHERE l.description like %:criteria% ")
     List<Local> find(@Param("criteria") String criteria);

    @Query("SELECT l FROM Local l WHERE l.address like %:address% ")
    List<Local> findByAddress(@Param("address") String address);

}
