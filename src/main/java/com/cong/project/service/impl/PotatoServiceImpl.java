package com.cong.project.service.impl;

import com.cong.project.dao.PotatoMapper;
import com.cong.project.model.PotatoTable;
import com.cong.project.service.PotatoService;
import com.cong.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/03/06.
 */
@Service
@Transactional
public class PotatoServiceImpl extends AbstractService<PotatoTable> implements PotatoService {
    @Resource
    private PotatoMapper potatoMapper;

}
