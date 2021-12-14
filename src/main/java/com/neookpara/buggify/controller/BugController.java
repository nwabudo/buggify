package com.neookpara.buggify.controller;

import com.neookpara.buggify.dto.ApiResponse;
import com.neookpara.buggify.dto.BugDTO;
import com.neookpara.buggify.entity.enums.Status;
import com.neookpara.buggify.services.BugService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/bugs")
public class BugController {

    private final BugService bugService;

    public BugController(BugService bugService){
        this.bugService = bugService;
    }

    @GetMapping("/open")
    public ResponseEntity<ApiResponse<List<BugDTO>>> fetchAllOpenBugs(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "20") int size){
        List<BugDTO> bugs = bugService.findAllOpenBugs(page, size);
        return new ResponseEntity<>(new ApiResponse<>(bugs), HttpStatus.OK);
    }

    @PutMapping("/{bugId}")
    public ResponseEntity<ApiResponse<?>> updateBugStatus(@PathVariable long bugId, @RequestParam("status") Status status){
        ApiResponse<String> response = bugService.updateBugStatus(bugId, status);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
