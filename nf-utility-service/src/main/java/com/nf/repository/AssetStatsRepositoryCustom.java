package com.nf.repository;

import com.nf.model.iconomi.AssetStats;
import com.nf.model.iconomi.CustomDate;

import java.util.List;

public interface AssetStatsRepositoryCustom {

    public List<AssetStats> fetchAssetStatsByDate(CustomDate date);
}
