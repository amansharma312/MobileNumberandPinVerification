package controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByMobileNumber(String mobileNumber);
    
    User findByMobileNumberAndMpin(String mobileNumber, String mpin);
    
//    @Query("from User u where u.mobileNumber = :mobileNumber and u.mpin = :mpin")
//    User getUserByMobileNumberAndMpin(@Param("mobileNumber") String mobileNumber, @Param("mpin") String mpin);
}

