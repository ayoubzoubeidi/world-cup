package tn.isi.worldcup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.isi.worldcup.entities.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long> {
}
