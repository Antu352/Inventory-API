/*
* AMRIT – Accessible Medical Records via Integrated Technology 
* Integrated EHR (Electronic Health Records) Solution 
*
* Copyright (C) "Piramal Swasthya Management and Research Institute" 
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.inventory.controller.item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.inventory.data.drugtype.M_Drugtype;
import com.iemr.inventory.data.facilitytype.M_facilitytype;
import com.iemr.inventory.data.items.ItemMaster;
import com.iemr.inventory.data.items.M_ItemCategory;
import com.iemr.inventory.data.items.M_ItemForm;
import com.iemr.inventory.data.items.M_Route;
import com.iemr.inventory.service.item.ItemService;
import com.iemr.inventory.utils.mapper.InputMapper;
import com.iemr.inventory.utils.response.OutputResponse;

@RestController
public class ItemController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private ItemService itemService;

	@CrossOrigin()
	@RequestMapping(value = "/getItemForm/{providerservicemapID}", headers = "Authorization", method = {
			RequestMethod.GET }, produces = { "application/json" })
	public String getItemForm(@PathVariable("providerservicemapID") Integer providerservicemapID) {

		OutputResponse response = new OutputResponse();
		try {

			// M_ItemCategory item = InputMapper.gson().fromJson(itemCategory,
			// M_ItemCategory.class);

			List<M_ItemForm> saveData= itemService.getItemFormProviderServiceMapID(providerservicemapID);
			

			response.setResponse(saveData.toString());

		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = "/getItemRoute/{providerservicemapID}", headers = "Authorization", method = {
			RequestMethod.GET }, produces = { "application/json" })
	public String getItemRoute(@PathVariable("providerservicemapID") Integer providerservicemapID) {

		OutputResponse response = new OutputResponse();
		try {

			// M_ItemCategory item = InputMapper.gson().fromJson(itemCategory,
			// M_ItemCategory.class);

			List<M_Route> saveData= itemService.getItemRouteProviderServiceMapID(providerservicemapID);
			
			response.setResponse(saveData.toString());

		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = "/getItemCategory/{providerservicemapID}/{bool}", headers = "Authorization", method = {
			RequestMethod.GET }, produces = { "application/json" })
	public String getItemCategory(@PathVariable("providerservicemapID") Integer providerServicemapID,
			@PathVariable("bool") Integer bool) {

		OutputResponse response = new OutputResponse();
		try {

			// M_ItemCategory item = InputMapper.gson().fromJson(itemCategory,
			// M_ItemCategory.class);

			List<M_ItemCategory> saveData;
			if (bool == 0) {
				saveData = itemService.getItemCategory(true, providerServicemapID);
			} else {
				saveData = itemService.getItemCategory(false, providerServicemapID);
			}

			response.setResponse(saveData.toString());

		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = "/createItemMaster", headers = "Authorization", method = {
			RequestMethod.POST }, produces = { "application/json" })
	public String createItemMaster(@RequestBody ItemMaster[] item) {

		OutputResponse response = new OutputResponse();
		try {

			// ItemMaster item = InputMapper.gson().fromJson(itemMaster,
			// ItemMaster.class);

			List<ItemMaster> itemList = Arrays.asList(item);
			List<ItemMaster> saveData = itemService.addAllItemMaster(itemList);

			response.setResponse(saveData.toString());

		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = "/getItemMaster/{providerservicemapID}", headers = "Authorization", method = {
			RequestMethod.GET }, produces = { "application/json" })
	public String getItemMaster(@PathVariable("providerservicemapID") Integer providerServicemapID) {

		OutputResponse response = new OutputResponse();
		try {

			// TODO: bool case(0): Show All case(1): Show Non Blocked item
			// case(2): Show Non Blocked and Non Discontinued item

			// M_ItemCategory item = InputMapper.gson().fromJson(itemCategory,
			// M_ItemCategory.class);

			List<ItemMaster> saveData = itemService.getItemMaster(providerServicemapID);

			response.setResponse(saveData.toString());

		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = "/getActiveItemMaster", headers = "Authorization", method = {
			RequestMethod.POST }, produces = { "application/json" })
	public String getActiveItemMaster(@RequestBody ItemMaster providerServicemapID) {

		OutputResponse response = new OutputResponse();
		try {

			// TODO: bool case(0): Show All case(1): Show Non Blocked item
			// case(2): Show Non Blocked and Non Discontinued item

			// M_ItemCategory item = InputMapper.gson().fromJson(itemCategory,
			// M_ItemCategory.class);

			List<ItemMaster> saveData = itemService.getActiveItemMaster(providerServicemapID);

			response.setResponse(saveData.toString());

		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/blockItemMaster/{itemmasterid}/{deleteflag}", headers = "Authorization", method = {
			RequestMethod.GET }, produces = { "application/json" })
	public String blockItemMaster(@PathVariable("itemmasterid") Integer itemmasterID,
			@PathVariable("deleteflag") Boolean delete) {

		OutputResponse response = new OutputResponse();
		try {

			Integer update = itemService.blockItemMaster(itemmasterID, delete);

			response.setResponse(update.toString());

		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = "/discontinueItemMaster/{itemmasterid}/{deleteflag}", headers = "Authorization", method = {
			RequestMethod.GET }, produces = { "application/json" })
	public String discontinueItemMaster(@PathVariable("itemmasterid") Integer itemmasterID,
			@PathVariable("deleteflag") Boolean delete) {

		OutputResponse response = new OutputResponse();
		try {

			Integer update = itemService.discontinueItemMaster(itemmasterID, delete);

			response.setResponse(update.toString());

		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = "/editItemMaster", headers = "Authorization", method = { RequestMethod.POST }, produces = {
			"application/json" })
	public String editItemMaster(@RequestBody ItemMaster item) {

		OutputResponse response = new OutputResponse();
		try {

			// ItemMaster item = InputMapper.gson().fromJson(itemMaster,
			// ItemMaster.class);

			ItemMaster saveData = itemService.getItemMasterByID(item.getItemID());
			saveData.setItemDesc(item.getItemDesc());
			saveData.setModifiedBy(item.getModifiedBy());
			saveData = itemService.createItemMaster(saveData);
			response.setResponse(saveData.toString());

		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = "/configItemIssue", headers = "Authorization", method = { RequestMethod.POST }, produces = {
			"application/json" })
	public String configItemIssue(@RequestBody M_ItemCategory[] itemIssue) {

		OutputResponse response = new OutputResponse();
		try {

			// ItemMaster item = InputMapper.gson().fromJson(itemMaster,
			// ItemMaster.class);

			List<M_ItemCategory> itemList = Arrays.asList(itemIssue);
			Integer saveData = itemService.updateItemIssueConfig(itemList);

			response.setResponse(saveData.toString());

		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();
	}

	
	
	
	
		
		@CrossOrigin()
		@RequestMapping(value = "/getItem", headers = "Authorization", method = {RequestMethod.POST }, produces = { "application/json" })
	public String getItem(@RequestBody String getItem) {
			
	      OutputResponse response = new OutputResponse();
	      
	try {

		
		ItemMaster item = InputMapper.gson().fromJson(getItem,ItemMaster.class);

		
		List<ItemMaster> getData=itemService.getItemMasters(item.getProviderServiceMapID(),item.getItemCategoryID());
		
		
		response.setResponse(getData.toString());

	} catch (Exception e) {
		logger.error(e.getMessage());
		response.setError(e);

	}
	/**
	 * sending the response...
	 */
	return response.toString();
	}


		

}
