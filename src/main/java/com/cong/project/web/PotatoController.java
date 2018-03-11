package com.cong.project.web;
import com.cong.project.core.Result;
import com.cong.project.core.ResultGenerator;
import com.cong.project.model.PotatoTable;
import com.cong.project.service.PotatoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/03/06.
*/
@RestController
@RequestMapping("/potato")
public class PotatoController {
    @Resource
    private PotatoService potatoServiceImpl;

    @PostMapping("/")
    public Result add(@ModelAttribute PotatoTable potato) {
        potatoServiceImpl.save(potato);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@RequestParam Integer id) {
        potatoServiceImpl.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @ModelAttribute PotatoTable potato) {
        potatoServiceImpl.update(potato);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        PotatoTable potato = potatoServiceImpl.findById(id);
        return ResultGenerator.genSuccessResult(potato);
    }

    @GetMapping("/")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<PotatoTable> list = potatoServiceImpl.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
