package com.wecode.realestateagency.Repositories;

import com.wecode.realestateagency.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@org.springframework.stereotype.Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public User findUserByUsername(String username);
    User findById(long idUSer);

//    @Modifying
//    @Query(value = "insert into wish_list values ( idUser, idLocal) ", nativeQuery = true)
//    @Transactional
//    void addLocaltoWishlist(@Param("idUser")Long idUser,@Param("idLocal") Long idLocal);
}
