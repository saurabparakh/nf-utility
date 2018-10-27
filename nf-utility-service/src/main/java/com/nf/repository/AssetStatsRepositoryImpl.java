package com.nf.repository;

import com.nf.model.iconomi.AssetStats;
import com.nf.model.iconomi.CustomDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class AssetStatsRepositoryImpl implements AssetStatsRepositoryCustom {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<AssetStats> fetchAssetStatsByDate(CustomDate date) {
        Query query = new Query(Criteria.where("date").is(date.getDate()));
        query.addCriteria(Criteria.where("month").is(date.getMonth()));
        query.addCriteria(Criteria.where("year").is(date.getYear()));
        return mongoTemplate.find(query,AssetStats.class);
    }




}
