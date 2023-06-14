package com.example.tailormate.service.impl;

import com.example.tailormate.model.AreaOfSpecialization;
import com.example.tailormate.model.PortfolioItem;
import com.example.tailormate.model.Tailor;
import com.example.tailormate.repository.AreaOfSpecializationRepository;
import com.example.tailormate.repository.PortfolioItemRepository;
import com.example.tailormate.repository.TailorRepository;
import com.example.tailormate.service.AreaOfSpecializationService;
import com.example.tailormate.service.PortfolioItemService;
import com.example.tailormate.service.TailorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioItemServiceImpl implements PortfolioItemService {

    private final PortfolioItemRepository portfolioItemRepository;

    @Autowired
    public PortfolioItemServiceImpl(PortfolioItemRepository portfolioItemRepository) {
        this.portfolioItemRepository = portfolioItemRepository;
    }

    @Override
    public List<PortfolioItem> getAllPortfolioItems() {
        return portfolioItemRepository.findAll();
    }

    @Override
    public PortfolioItem getPortfolioItemById(int id) {
        return portfolioItemRepository.findById(id).orElse(null);
    }

    @Override
    public PortfolioItem savePortfolioItem(PortfolioItem portfolioItem) {
        return portfolioItemRepository.save(portfolioItem);
    }

    @Override
    public PortfolioItem updatePortfolioItem(PortfolioItem portfolioItem) {
        return portfolioItemRepository.save(portfolioItem);
    }

    @Override
    public void deletePortfolioItem(int id) {
        portfolioItemRepository.deleteById(id);
    }

    @Override
    public List<PortfolioItem> getPortfolioItemByTailor(Tailor tailor) {
        return portfolioItemRepository.getPortfolioItemByTailor(tailor);
    }
}
