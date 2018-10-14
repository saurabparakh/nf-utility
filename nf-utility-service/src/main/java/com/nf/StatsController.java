package com.nf;

import com.nf.model.iconomi.AssetStats;
import com.nf.service.IconomiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StatsController {

    @Autowired
    private IconomiService iconomiService;


    @RequestMapping("/assetstats")
    @ResponseBody
    public List<AssetStats> getAssetStats() {
        return iconomiService.prepareAssetStats();
    }
}

