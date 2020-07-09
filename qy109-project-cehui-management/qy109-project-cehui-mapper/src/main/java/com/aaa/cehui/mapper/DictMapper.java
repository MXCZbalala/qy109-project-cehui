package com.aaa.cehui.mapper;

import com.aaa.cehui.model.Dict;
import tk.mybatis.mapper.common.Mapper;

public interface DictMapper extends Mapper<Dict> {

    Dict selectUpdateDict(Long dictId);

    Integer updateDict(Dict dict);

}