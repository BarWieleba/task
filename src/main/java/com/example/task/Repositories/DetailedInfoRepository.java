package com.example.task.Repositories;

import com.example.task.Entities.DetailedInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailedInfoRepository extends JpaRepository<DetailedInfoEntity, Long> {

}
