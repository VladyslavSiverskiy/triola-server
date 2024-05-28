package com.vsiverskyi.app.repository.graphs;

import com.vsiverskyi.app.model.graphs.Graphic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GraphicRepo extends JpaRepository<Graphic, String> {
}
