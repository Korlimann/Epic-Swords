package com.korlimann.epic_swords.items;

import com.korlimann.epic_swords.Main;
import com.korlimann.epic_swords.util.IHasModel;

import net.minecraft.item.ItemSword;

public class ItemBaseSword extends ItemSword implements IHasModel {

	public ItemBaseSword(String name, ToolMaterial material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.epic_swords);
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	

}
