package com.server.api.specialtyControl;

import com.server.common.model.response.QueryResponseResult;
import com.server.common.model.response.ResponseResult;
import com.server.model.Specialtylist;

public interface specialtyApi {
    public ResponseResult addSpecialty(Specialtylist specialtylist);
    public ResponseResult DeleSpecialty(String specialistId);
    public ResponseResult updateSpecialty(Specialtylist specialtylist);
    public Specialtylist selectSpecialty(String name);
}
