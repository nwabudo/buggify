package com.neookpara.buggify.services.impl;

import com.neookpara.buggify.BaseTest;
import com.neookpara.buggify.dto.BugDTO;
import com.neookpara.buggify.entity.Bug;
import com.neookpara.buggify.entity.User;
import com.neookpara.buggify.entity.enums.Status;
import com.neookpara.buggify.repository.BugRepository;
import com.neookpara.buggify.services.BugService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

class BugServiceImplTest extends BaseTest {

    @Autowired
    private BugService bugService;

    @MockBean
    private BugRepository bugRepository;

    private final User user = new User("Emmanuel", "Nwabudo", "nwabudoemmanuel@gmail.com");

    private final List<Bug> bugs = List.of(
            new Bug(1L, "NullPointer Exception", "Null pointer Experienced", Status.OPEN, user),
            new Bug(2L, "IllegalArgument Exception", "Illegal Argument Experienced", Status.OPEN, user));


    @BeforeEach
    public void setUp() {

        Mockito.when(bugRepository.findAllBugs(any())).thenReturn(bugs);
        Mockito.when(bugRepository.findBugsByStatus(any(), any())).thenReturn(bugs);
    }

    @Test
    void find_all_open_bugs(){
        List<BugDTO> actual = bugService.findAllOpenBugs(0, 2);

        assertEquals( bugs.size(), actual.size(),"Assert that Size of output are equal");
        assertEquals(bugs.get(0).getDescription(), actual.get(0).getDescription(),
                "Assert that Description of first element is equal");
    }
}