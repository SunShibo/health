package com.example.controller;


import com.example.domain.JsonResponse;
import com.example.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 项目关系
 * */


@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping("/patient/getProjectRelation")
    public JsonResponse getProjectRelation() throws Exception {
        return  new JsonResponse(projectService.getProjectRelation());
    }



}
