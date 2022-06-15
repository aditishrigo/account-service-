package com.maveric.bank.Repository;
import com.maveric.bank.model.Account;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {

    Optional<Account> findAccountByAccountType(String type);

    @Modifying
    @Query("update account a set a.custmoreId = :custmoreId where a.id = :id")
    String updateaccountype(@Param(value = "type") String type, @Param(value = "id") int id);
}