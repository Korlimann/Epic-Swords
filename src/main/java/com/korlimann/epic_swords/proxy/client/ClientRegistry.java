package com.korlimann.epic_swords.proxy.client;

import com.korlimann.epic_swords.entity.projectile.EntityTerraBladeProjectile;
import com.korlimann.epic_swords.init.ModItems;
import com.korlimann.epic_swords.proxy.CommonProxy;
import com.korlimann.epic_swords.proxy.client.renderer.entity.RenderEntityTerraBladeProjectile;
import com.korlimann.epic_swords.util.Reference;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = { Side.CLIENT })
public class ClientRegistry extends CommonProxy{

	@SubscribeEvent
	public static void onModelRegistry(ModelRegistryEvent event) {
		registerRenderers();
		registerStaticModel(ModItems.TERRA_BLADE, new ModelResourceLocation(ModItems.TERRA_BLADE.getRegistryName(), "inventory"));
	}
	
	public static void registerRenderers() {
		
	}
	
	public static void registerStaticModel(Item item, ModelResourceLocation staticLocation)
    {
        ModelLoader.setCustomMeshDefinition(item, i -> staticLocation);
        ModelBakery.registerItemVariants(item, staticLocation);
    }
	
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
}
