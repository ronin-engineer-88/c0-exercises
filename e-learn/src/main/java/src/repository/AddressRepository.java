package src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import src.entity.Address;

public interface AddressRepository extends JpaRepository <Address, Long> {

}
