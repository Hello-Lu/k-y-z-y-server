package com.server.Picture.service;

import com.server.Picture.dao.AliyunOSSUtil;
import com.server.Picture.dao.PictureRepository;
import com.server.common.model.response.CommonCode;
import com.server.common.model.response.QueryResponseResult;
import com.server.common.model.response.QueryResult;
import com.server.common.model.response.ResponseResult;
import com.server.model.Picture;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

@Service
public class PictureService {
    @Autowired
    private AliyunOSSUtil aliyunOSSUtil;
    @Autowired
    private PictureRepository pictureRepository;
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    public ResponseResult pictureAdd(MultipartFile file) {

        Picture picture=new Picture();
        String filename = file.getOriginalFilename();
        picture.setName(filename);
        String url = uploadPicture(file);
        if (url!=null){
            picture.setUrl(url);
            pictureRepository.save(picture);
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);
    }
    /**
     * oss文件上传（供前端调用）
     */
    public String uploadPicture( MultipartFile file){
        logger.info("文件上传");
        String filename = file.getOriginalFilename();
        System.out.println(filename);
        String uploadUrl = null;
        try {

            if (file != null) {
                if (!"".equals(filename.trim())) {
                    File newFile = new File(filename);
                    FileOutputStream os = new FileOutputStream(newFile);
                    os.write(file.getBytes());
                    os.close();
                    file.transferTo(newFile);
                    // 上传到OSS
                    uploadUrl = aliyunOSSUtil.upLoad(newFile);
                    //model.addAttribute("url",uploadUrl);
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return uploadUrl;
    }

    public QueryResponseResult pictureFindList(int page, int size) {
        //分页参数
        if (page<=0){
            page=1;
        }
        page=page-1;
        if (size<=0){
            size=10;
        }
        Pageable pageable = PageRequest.of(page, size);
        Page<Picture> all = pictureRepository.findAll(pageable);

        QueryResult queryResult=new QueryResult();
        queryResult.setList(all.getContent());//数据列表
        queryResult.setTotal(all.getTotalElements());//数据总记录数
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }

    public ResponseResult pictureDele(String id) {

        if (id.isEmpty()){
            pictureRepository.deleteById(id);
            return new ResponseResult(CommonCode.SUCCESS);
        }

        return new ResponseResult(CommonCode.FAIL);
    }
}
