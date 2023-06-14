package com.example.tailormate.repository;

import com.example.tailormate.model.PortfolioItem;
import com.example.tailormate.model.Tailor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PortfolioItemRepository extends JpaRepository<PortfolioItem, Integer> {

    List<PortfolioItem> getPortfolioItemByTailor(Tailor tailor);
}
