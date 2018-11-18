package com.korlimann.epic_swords.util.handlers;

import com.korlimann.epic_swords.entity.projectile.EntityTerraBladeProjectile;
import com.korlimann.epic_swords.util.Reference;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EntityRegistry {

	public static int id = 0;

	@SubscribeEvent
	public static void registerEntities(RegistryEvent.Register<EntityEntry> event) {
		event.getRegistry().registerAll(
				EntityEntryBuilder.create()
				.entity(EntityTerraBladeProjectile.class)
				.id(new ResourceLocation(Reference.MOD_ID, "terra_blade_projectile"), id++)
				.name("terra_blade_projectile")
				.tracker(128, 1, true)
				.build());
	}
}
