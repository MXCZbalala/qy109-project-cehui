package com.aaa.cehui.controller;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.base.CommonController;
import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.Mapping_unit;
import com.aaa.cehui.model.Score;
import com.aaa.cehui.service.ScoreService;
import com.aaa.cehui.service.UnitInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sbs
 * @date 2020/7/21 15:44
 */
@RestController
public class ScoreController extends CommonController<Score> {
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private UnitInfoService unitInfoService;
    @Override
    public BaseService<Score> getBaseService() {
        return scoreService;
    }

    /**
     * 查询所有打分记录分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("/selectAllScorePage")
    public ResultData selectAllScorePage(@RequestParam("pageNo")Integer pageNo,@RequestParam("pageSize") Integer pageSize){
        List<Score> scores = getBaseService().selectAll(pageNo, pageSize);
        if (scores != null) {
            return getSuccess(scores);
        }else {
            return getFiled();
        }
    }

    /**
     * 添加打分记录
     * 并修改mapping_util中关于score和until_status的值
     * @param score
     * @return
     */
    @PostMapping("/insertScore")
    public ResultData insertScore(Score score){
        Integer add = getBaseService().add(score);
        Mapping_unit mapping_unit=new Mapping_unit();
        mapping_unit.setId(score.getUnitId());
        mapping_unit.setScore(score.getScore());
        int i=score.getScore();
        if (add != null) {
            if (i> 100 ){
                mapping_unit.setUnitStatus(1);
                unitInfoService.updateScoreAndStatusById(mapping_unit);
            }else if(i<100){
                mapping_unit.setUnitStatus(2);
                unitInfoService.updateScoreAndStatusById(mapping_unit);
            }else {
                mapping_unit.setUnitStatus(3);
                unitInfoService.updateScoreAndStatusById(mapping_unit);
            }
            return getSuccess(add);
        }else {
            return getFiled();
        }
    }

}
