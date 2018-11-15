package com.korlimann.epic_swords.items;

import com.korlimann.epic_swords.Main;
import com.korlimann.epic_swords.util.IHasModel;

import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel{

	/*
	 * This class creates custom items with no special function. 
	 * */
	
	public ItemBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.epic_swords);
		
		//ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
