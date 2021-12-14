package com.neookpara.buggify.repository;

import com.neookpara.buggify.entity.Bug;
import com.neookpara.buggify.entity.Role;
import com.neookpara.buggify.entity.enums.ERole;
import com.neookpara.buggify.entity.enums.Status;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BugRepository extends JpaRepository<Bug, Long> {

    @Query("select b from Bug b where b.status = :status ")
    List<Bug> findBugsByStatus(Pageable page, @Param("status") Status status);

    @Query("select b from Bug b")
    List<Bug> findAllBugs(Pageable page);
}
