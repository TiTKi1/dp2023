package knu.fit.mit.exam.repository;

import knu.fit.mit.exam.entity.RocketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "rockets", path = "rockets")
public interface RocketRepository extends JpaRepository<RocketEntity, Long> {
}