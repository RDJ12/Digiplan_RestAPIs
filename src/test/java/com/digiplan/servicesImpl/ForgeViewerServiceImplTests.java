package com.digiplan.servicesImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.digiplan.entities.ForgeViewer;
import com.digiplan.repositories.ForgeViewerRepository;

@SpringBootTest
public class ForgeViewerServiceImplTests {

	@InjectMocks
	private ForgeViewerServiceImpl forgeViewerServiceImpl;

	@Mock
	private ForgeViewerRepository forgeViewerRepository;

	@Test
	public void test_getForgeViewer() throws Exception {
		ForgeViewer forgeViewer = new ForgeViewer(1, "8377936420", "attachments", "Lower", null,
				new Date(2022 - 01 - 22), "dXJuOmFkc2sub2JqZWN0czpvcy5vYmplY3Q");
		Integer id = 1;
		when(forgeViewerRepository.getById(id)).thenReturn(forgeViewer);
		assertEquals(id, forgeViewerServiceImpl.getForgeViewer(id).getId());
	}

	@Test
	public void test_getAllForgeViewers() throws Exception {
		List<ForgeViewer> forgeViewer = new ArrayList<>();
		forgeViewer.add(new ForgeViewer(1, "8377936420", "attachments", "Lower", null, new Date(2022 - 01 - 22),
				"dXJuOmFkc2sub2JqZWN0czpvcy5vYmplY3Q"));
		forgeViewer.add(new ForgeViewer(2, "8377936420", "attachments", "Lower", null, new Date(2022 - 01 - 22),
				"dXJuOmFkc2sub2JqZWN0czpvcy5vYmplY3Q"));
		forgeViewer.add(new ForgeViewer(3, "8377936420", "attachments", "Lower", null, new Date(2022 - 01 - 22),
				"dXJuOmFkc2sub2JqZWN0czpvcy5vYmplY3Q"));
		when(forgeViewerRepository.findAll()).thenReturn(forgeViewer);
		assertEquals(3, forgeViewerServiceImpl.getAllForgeViewers().size());
	}

	@Test
	public void test_addForgeViewer() throws Exception {
		ForgeViewer forgeViewer = new ForgeViewer(1, "8377936420", "attachments", "Lower", null,
				new Date(2022 - 01 - 22), "dXJuOmFkc2sub2JqZWN0czpvcy5vYmplY3Q");
		when(forgeViewerRepository.saveAndFlush(forgeViewer)).thenReturn(forgeViewer);
		assertEquals(forgeViewer, forgeViewerServiceImpl.addForgeViewer(forgeViewer));
	}

	@Test
	public void test_updateForgeViewer() throws Exception {
		ForgeViewer forgeViewer = new ForgeViewer(1, "8377936420", "attachments", "Lower", null,
				new Date(2020 - 07 - 12), "dXJuOmFkc2sub2JqZWN0czpvcy5vYmplY3Q");
		Optional<ForgeViewer> retrievedData = Optional.of(new ForgeViewer(1, "8377936420", "attachments", "Upper", null,
				new Date(2022 - 01 - 22), "dXJuOmFkc2sub2JqZWN0czpvcy5vYmplY3Q"));
		Integer id = 1;
		when(forgeViewerRepository.findById(id)).thenReturn(retrievedData);
		if (retrievedData.isPresent())
			when(forgeViewerRepository.saveAndFlush(forgeViewer)).thenReturn(forgeViewer);
		assertEquals(forgeViewer, forgeViewerServiceImpl.updateForgeViewer(id, forgeViewer));
	}

	@Test
	public void test_deleteForgeViewer() throws Exception {
		Integer id = 1;
		forgeViewerServiceImpl.deleteForgeViewer(id);
		verify(forgeViewerRepository, times(1)).deleteById(id);
	}

}
