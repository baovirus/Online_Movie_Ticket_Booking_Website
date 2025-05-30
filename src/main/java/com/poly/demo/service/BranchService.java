package com.poly.demo.service;

import com.poly.demo.entity.Branch;
import com.poly.demo.entity.Movie;
import com.poly.demo.repository.BranchRepository;
import com.poly.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }
    
    public Page<Branch> getBranches(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("branchId").ascending());
        return branchRepository.findAll(pageable);
    }

    public Optional<Branch> getBranchById(Integer id) { // Đổi từ Long sang Integer
        return branchRepository.findById(id);
    }

    public Branch addBranch(Branch branch) {
        return branchRepository.save(branch);
    }

    public void deleteBranch(Integer id) { // Đổi từ Long sang Integer
        branchRepository.deleteById(id);
    }
}

