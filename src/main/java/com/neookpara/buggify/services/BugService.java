package com.neookpara.buggify.services;

import com.neookpara.buggify.dto.ApiResponse;
import com.neookpara.buggify.dto.BugDTO;
import com.neookpara.buggify.entity.enums.Status;

import java.util.List;

public interface BugService {

    List<BugDTO> findAllOpenBugs(int page, int size);

    ApiResponse<String> updateBugStatus(long bugId, Status status);
}
