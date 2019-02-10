package com.example.polls.repository;

import com.example.polls.model.Offer;
import com.example.polls.model.Poll;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by rajeevkumarsingh on 20/11/17.
 */
@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {


    @Query("SELECT o FROM Offer o where o.device.id = :deviceid and o.defect.id= :defectId")
    List<Offer> findByDeviceId(@Param("deviceid")Integer deviceid, @Param("defectId")Integer defectId);
}
