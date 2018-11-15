package com.korlimann.epic_swords.init;

import java.util.ArrayList;
import java.util.List;

import com.korlimann.epic_swords.items.ItemBaseSword;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;

public class ModItems {
	/*
	 * In this class, all our items get initalized before they then get registered by our ObjectRegistry class. Hereby, the
	 * name every item at least has, is the one that you will need to set all your textures/models-files to.
	 * */
	
	public static final Item TERRA_BLADE = new ItemBaseSword("terra_blade", ToolMaterial.STONE);
}
