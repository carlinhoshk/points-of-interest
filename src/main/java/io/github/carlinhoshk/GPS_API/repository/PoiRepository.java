package io.github.carlinhoshk.GPS_API.repository;

import io.github.carlinhoshk.GPS_API.model.Poi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoiRepository extends JpaRepository<Poi, Long> {


}
