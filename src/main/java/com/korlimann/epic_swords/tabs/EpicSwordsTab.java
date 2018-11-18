package com.korlimann.epic_swords.tabs;

import com.korlimann.epic_swords.init.ModItems;
import com.korlimann.epic_swords.items.ItemTerraBlade;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;

public class EpicSwordsTab extends CreativeTabs {

	/*
	 * In this class, our custom Creative Tabs gets implemented. With getTabIconItem, we reference to an Item in our ModItems
	 * class which gets set as the TabIcon
	 * */
	public EpicSwordsTab(String label) {
		super("epic_swords");
		//this.setBackgroundImageName("nameyougivehere.png"); Don't forget to add tab_ for the image
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.TERRA_BLADE);
	}

}
