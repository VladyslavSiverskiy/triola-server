package com.vsiverskyi.dataimport.repository.graphs;

import com.vsiverskyi.dataimport.model.graphs.Graphic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GraphicRepo extends JpaRepository<Graphic, String> {
}
