package com.uiudevelopershub.thinktanku.config.excel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcelRepo extends JpaRepository<ExcelUser,Long> {
}
