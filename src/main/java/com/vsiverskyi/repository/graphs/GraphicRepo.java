package com.vsiverskyi.repository.graphs;

import com.vsiverskyi.model.graphs.Graphic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GraphicRepo extends JpaRepository<Graphic, String> {
}
