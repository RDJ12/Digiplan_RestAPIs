package com.digiplan.services;

import java.util.List;

import com.digiplan.entities.ForgeViewer;

public interface ForgeViewerService {

	public ForgeViewer getForgeViewer(Integer id);

	public List<ForgeViewer> getAllForgeViewers();

	public ForgeViewer addForgeViewer(ForgeViewer forgeViewerData);

	public ForgeViewer updateForgeViewer(Integer id, ForgeViewer forgeViewerData);

	public String deleteForgeViewer(Integer id);
}
