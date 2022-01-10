package com.neookpara.buggify.services.impl;

import com.neookpara.buggify.dto.ApiResponse;
import com.neookpara.buggify.dto.BugDTO;
import com.neookpara.buggify.entity.Bug;
import com.neookpara.buggify.entity.enums.Status;
import com.neookpara.buggify.repository.BugRepository;
import com.neookpara.buggify.services.BugService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BugServiceImpl implements BugService {

    private final BugRepository bugRepository;

    @Override
    public List<BugDTO> findAllOpenBugs(int page, int size) {
        return bugRepository.findBugsByStatus(PageRequest.of(page, size), Status.OPEN)
                .stream().map(bug -> toDTO(bug))
                .collect(Collectors.toList());
    }

    @Override
    public ApiResponse<String> updateBugStatus(long bugId, Status status) {
        Bug bug = bugRepository.findById(bugId).orElse(null);
        if(bug == null) return new ApiResponse<>("Error no Bug with that Id Found", false);
        //As bug exist update its status
        bug.setStatus(status);
        bugRepository.save(bug);

        return new ApiResponse<>("Success, Bug has been updated");
    }

    private BugDTO toDTO(Bug entity){
       return BugDTO.builder()
               .devEmail(entity.getDeveloper().getEmail())
               .description(entity.getDescription())
               .title(entity.getTitle())
               .id(entity.getId())
               .status(entity.getStatus())
               .build();
    }
}
