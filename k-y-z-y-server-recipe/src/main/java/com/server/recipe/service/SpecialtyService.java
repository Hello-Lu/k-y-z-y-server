package com.server.recipe.service;

import com.server.common.model.response.CommonCode;
import com.server.common.model.response.QueryResponseResult;
import com.server.common.model.response.ResponseResult;
import com.server.model.Specialtylist;
import com.server.recipe.dao.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpecialtyService {
    @Autowired
    SpecialtyRepository specialtyRepository;
    public ResponseResult addSpecialty(Specialtylist specialtylist) {

       if (specialtylist!=null){
           specialtyRepository.save(specialtylist);
           return new ResponseResult(CommonCode.SUCCESS);
       }
        return new ResponseResult(CommonCode.FAIL);




    }

    public ResponseResult DeleSpecialty(String specialistId) {
        if (specialistId!=null){
            specialtyRepository.deleteById(specialistId);
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);

    }

    public ResponseResult updateSpecialty(Specialtylist specialtylist) {
        Optional<Specialtylist> byId = specialtyRepository.findById(specialtylist.getSpecialistId());
        if (byId.isPresent()){
            Specialtylist specialtylist1 = byId.get();
            specialtylist1.setSpecialty(specialtylist.getSpecialty());
            specialtylist1.setName(specialtylist.getName());
            specialtyRepository.save(specialtylist1);
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);
    }

    public Specialtylist selectSpecialty(String name) {

        if (name!=null){
            Specialtylist byName = specialtyRepository.findByName(name);
            return byName;
        }
        return null;

    }
}
