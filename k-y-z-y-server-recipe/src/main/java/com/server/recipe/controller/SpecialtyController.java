package com.server.recipe.controller;

import com.server.api.specialtyControl.specialtyApi;
import com.server.common.model.response.QueryResponseResult;
import com.server.common.model.response.ResponseResult;
import com.server.model.Specialtylist;
import com.server.recipe.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 专家信息controller
 */
@RestController
@RequestMapping("/Specialty")
public class SpecialtyController implements specialtyApi {

    @Autowired
    SpecialtyService specialtyService;

    /**
     * 添加专家信息
     * @param specialtylist
     * @return
     */
    @Override
    @PostMapping("/addSpecialty")
    public ResponseResult addSpecialty(@RequestBody Specialtylist specialtylist) {
        return specialtyService.addSpecialty(specialtylist);
    }

    @Override
    @PostMapping("/deleSpecialty")
    public ResponseResult DeleSpecialty(@RequestParam("specialistId") String specialistId) {
        return specialtyService.DeleSpecialty(specialistId);
    }

    @Override
    @PostMapping("/updateSpecialty")
    public ResponseResult updateSpecialty(Specialtylist specialtylist) {
        return specialtyService.updateSpecialty(specialtylist);
    }

    @Override
    @PostMapping("/selectSpecialty")
    public Specialtylist selectSpecialty(String name) {
        return specialtyService.selectSpecialty(name);
    }
}
