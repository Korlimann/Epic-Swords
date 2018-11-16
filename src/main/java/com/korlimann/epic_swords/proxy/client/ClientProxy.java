package com.korlimann.epic_swords.proxy.client;

import com.korlimann.epic_swords.entity.projectile.EntityTerraBladeBeam;
import com.korlimann.epic_swords.proxy.CommonProxy;
import com.korlimann.epic_swords.proxy.client.renderer.entity.RenderTerraBladeBeam;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{

	
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	
	public static void registerModels(final ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityTerraBladeBeam.class, renderManager -> new RenderTerraBladeBeam(renderManager, 1.0F));
	}
}
