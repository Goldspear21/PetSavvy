package petsavvy.pet.repositories;

import petsavvy.pet.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAll();
    List<User> findUserByUserID(int userID);

    List<User> findByPassword(String password);

    List<User> findByUserMail(String userMail);

    List<User> findByUsernameContainingIgnoreCase(String username);

    Optional<User> findByUsername(String username);


    @Query("SELECT u.userMail FROM User u WHERE u.userID = :userID")
    String findUserMailByUserID(@Param("userID") int userID);

    @Modifying
    @Transactional
    @Query(value ="ALTER TABLE user AUTO_INCREMENT = 1", nativeQuery= true)
    void resetAutoIncrement();

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.password = :password WHERE u.userID = :userID")
    void updatePasswordByUserID(@Param("password") String password, @Param("userID") int userID);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.userMail = :usermail WHERE u.userID = :userID")
    void updateUserMailByUserID(@Param("userMail") String userMail, @Param("userID") int userID);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.username = :username WHERE u.userID = :userID")
    void updateUserNameByUserID(@Param("username") String username, @Param("userID") int userID);

    @Modifying
    @Transactional
    void deleteByUserID(int userID);
}
