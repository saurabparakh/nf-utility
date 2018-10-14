package com.nf.repository;

import com.nf.model.iconomi.AssetStats;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetStatsRepository extends MongoRepository<AssetStats, String> {


}

