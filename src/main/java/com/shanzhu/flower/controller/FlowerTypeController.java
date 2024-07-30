package com.shanzhu.flower.controller;

import com.shanzhu.flower.config.Constant;
import com.shanzhu.flower.config.HttpMsg;
import com.shanzhu.flower.entity.R;
import com.shanzhu.flower.entity.Species;
import com.shanzhu.flower.service.SpeciesService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 鲜花种类 控制层
 *
 * @author: ShanZhu
 * @date: 2024-01-24
 */
@RestController
@RequestMapping("species")
public class FlowerTypeController {

    @Resource
    private SpeciesService speciesService;

    @RequestMapping("/findAll")
    R findAll() {
        R r = new R();
        List<Species> all = speciesService.findAll();
        if (all.size()<=0){
            return r.setCode(4000).setMsg(HttpMsg.NO_TYPE_NOW);
        }
        return r.setCode(2000).setData(all);
    }

    @RequestMapping("/find")
    R find(@RequestParam("page") int page, @RequestParam("searchKey") String searchKey) {
        R r = new R();
        Map<String, Object> map = new HashMap<>();
        List<Species> list = speciesService.find(searchKey);
        if (list == null) {
            return r.setCode(2000);
        }
        List<Species> items = list.size() >= page * Constant.PAGE_SIZE ?
                list.subList((page - 1) * Constant.PAGE_SIZE, page * Constant.PAGE_SIZE)
                : list.subList((page - 1) * Constant.PAGE_SIZE, list.size());
        int len = list.size() % Constant.PAGE_SIZE == 0 ? list.size() / Constant.PAGE_SIZE
                : (list.size() / Constant.PAGE_SIZE + 1);
        map.put("items", items);
        map.put("len", len);
        return r.setCode(2000).setData(map);
    }

    @RequestMapping("/create")
    R create(@RequestBody Species species) {
        R r = new R();
        try {
            speciesService.add(species);
            return r.setCode(2000).setMsg(HttpMsg.ADD_TYPE_OK);
        } catch (Exception e) {
            return r.setCode(4000).setMsg(HttpMsg.ADD_TYPE_FAILED);
        }
    }

    @RequestMapping("/update")
    R update(@RequestBody Species species) {
        R r = new R();
        try {
            speciesService.update(species);
            return r.setCode(2000).setMsg(HttpMsg.UPDATE_TYPE_OK);
        } catch (Exception e) {
            return r.setCode(4000).setMsg(HttpMsg.UPDATE_TYPE_FAILED);
        }
    }

    @DeleteMapping("/delete")
    R delete(@RequestParam("id") int id) {
        R r = new R();
        try {
            speciesService.delete(id);
            return r.setCode(2000).setMsg(HttpMsg.DELETE_TYPE_OK);
        } catch (Exception e) {
            return r.setCode(4000).setMsg(HttpMsg.DELETE_TYPE_FAILED);
        }
    }

}

