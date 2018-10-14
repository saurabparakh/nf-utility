package com.nf.service;

import com.nf.client.IconomiClient;
import com.nf.model.iconomi.AssetStats;
import com.nf.model.iconomi.DAAAllocation;
import com.nf.model.iconomi.DAADetails;
import com.nf.model.iconomi.Value;
import com.nf.repository.AssetStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class IconomiService {

    @Autowired
    IconomiClient iconomiClient;

    @Autowired
    AssetStatsRepository assetStatsRepository;

    public List<AssetStats> prepareAssetStats() {
        List<AssetStats> assetStats = new ArrayList<>();
        List<DAADetails> daaDetailsList = iconomiClient.geAllDAADetails().getDaaList();
        for(DAADetails daaDetails: daaDetailsList ) {
            daaDetails.setDaaStructure(iconomiClient.getDAAStructure(daaDetails.getTicker()));
        }
        List<AssetStats> assetStatsList =  calculateAssetStats(daaDetailsList);
        Collections.sort(assetStatsList);
        assetStatsRepository.saveAll(assetStatsList);
        return assetStatsList;
    }

    private List<AssetStats> calculateAssetStats(List<DAADetails> daaDetailsList) {
        Map<String, AssetStats > stringAssetStatsMap = new HashMap<>();
        List<AssetStats> assetStatsList = new ArrayList<>();
        for(DAADetails daaDetails: daaDetailsList ) {
            for(Value asset: daaDetails.getDaaStructure().getValues())    {
                AssetStats assetStats = new AssetStats();
                if(stringAssetStatsMap.containsKey(asset.getAssetName()))   {
                    assetStats = stringAssetStatsMap.get(asset.getAssetName());
                } else  {
                    stringAssetStatsMap.put(asset.getAssetName(), assetStats);
                }
                assetStats.setName(asset.getAssetName());
                assetStats.getDaaAllocationList().add(new DAAAllocation(daaDetails.getName(),asset.getRebalancedWeight()));
            }
        }

        for(String assetName:stringAssetStatsMap.keySet())  {
            stringAssetStatsMap.get(assetName).calculate();
            assetStatsList.add(stringAssetStatsMap.get(assetName));
        }
        return assetStatsList;

    }
}
