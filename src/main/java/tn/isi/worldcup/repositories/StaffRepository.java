package tn.isi.worldcup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.isi.worldcup.entities.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long> {
}
