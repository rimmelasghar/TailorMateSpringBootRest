package com.example.tailormate.service;

import com.example.tailormate.model.Colors;
import com.example.tailormate.model.PortfolioItem;
import com.example.tailormate.model.Tailor;

import java.util.List;

public interface PortfolioItemService {
    List<PortfolioItem> getAllPortfolioItems();
    PortfolioItem getPortfolioItemById(int id);
    PortfolioItem savePortfolioItem(PortfolioItem portfolioItem);
    PortfolioItem updatePortfolioItem(PortfolioItem portfolioItem);
    void deletePortfolioItem(int id);

    List<PortfolioItem> getPortfolioItemByTailor(Tailor tailor);
}
