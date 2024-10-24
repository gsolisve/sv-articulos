package com.sv.articulos.controllers.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.sv.articulos.controllers.IItemController;
import com.sv.articulos.models.ItemModel;
import com.sv.articulos.models.StatusModel;
import com.sv.articulos.services.IItemService;
import com.sv.articulos.services.IStatusService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ItemControllerImpl implements IItemController {

	private final IItemService service;
	private final IStatusService statusService;

	@Override
	public ItemModel save(ItemModel t) {
		// TODO Auto-generated method stub
		return service.save(t);
	}

	@Override
	public ItemModel update(ItemModel t, Integer id) {
		// TODO Auto-generated method stub
		return service.update(t, id);
	}

	@Override
	public List<ItemModel> findAll() {
		// TODO Auto-generated method stub
		return service.findAll();
	}

	@Override
	public Page<ItemModel> findAllPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		return service.findAllPageable(pageable);
	}

	@Override
	public ItemModel findById(Integer id) {
		// TODO Auto-generated method stub
		return service.findById(id).orElse(null);
	}

	@Override
	public Boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return service.delete(id);
	}

	@Override
	public Boolean updateStatusItems(List<ItemModel> items) {

		items = service.findAllById(items);
		System.out.println("Items size: " + items.size());
		if (items != null && items.size() > 0) {
			
			items.forEach( (item) -> {
				System.out.println(
						"\n Item status Init Name: " + item.getName() + " - status: -" + item.getStatus().getId());
				StatusModel newStatus  = item.getStatus();
				newStatus  = statusService.findById(item.getStatus().getId() == 1 ? 2 : 1 ).orElse(null);
				System.out.print( "\n Status by Id: " + newStatus.toString());
				if (newStatus != null) {
					item.setStatus(newStatus);
				}
			});
			
			items.forEach(item -> System.out
					.println("\n Item status update Name: " + item.getName() + " - status: -" + item.getStatus().getId()));
			service.saveAll(items);
			return true;
		}
		return false;
	}

}
