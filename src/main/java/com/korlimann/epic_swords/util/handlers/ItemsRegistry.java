package com.korlimann.epic_swords.util.handlers;

import com.korlimann.epic_swords.items.ItemTerraBlade;
import com.korlimann.epic_swords.util.Reference;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class ItemsRegistry {

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(
				new ItemTerraBlade("terra_blade", ToolMaterial.DIAMOND));
	}
}
