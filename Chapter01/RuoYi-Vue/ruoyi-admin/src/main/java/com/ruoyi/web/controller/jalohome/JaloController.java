package com.ruoyi.web.controller.jalohome;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDept;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * jalohome 伽罗生活
 *
 * @author xinping
 */
@RestController
@RequestMapping("/jalo")
public class JaloController {

    /**
     *
       http://127.0.0.1:8080/jalo/list
     *
     * */
    @GetMapping("/list")
    public AjaxResult list(SysDept dept)
    {
        List  list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        return AjaxResult.success(list);
    }

}
