package repository;

import entity.HitResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HitResultRepository extends JpaRepository<HitResult, Integer> {
}
