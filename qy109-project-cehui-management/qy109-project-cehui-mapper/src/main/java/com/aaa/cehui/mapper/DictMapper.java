package com.aaa.cehui.mapper;

import com.aaa.cehui.model.Dict;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DictMapper extends Mapper<Dict> {

    Dict selectUpdateDict(Long dictId);

    Integer updateDict(Dict dict);

    List<Dict> selectLikeDict(@Param("keyy") Integer keyy,@Param("valuee") String valuee,@Param("fieldName") String fieldName,@Param("tableName") String tableName);
}