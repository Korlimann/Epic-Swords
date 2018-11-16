package com.korlimann.epic_swords.init;

import com.korlimann.epic_swords.entity.projectile.EntityTerraBladeBeam;
import com.korlimann.epic_swords.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

public class ModEntities {

	public static int id = 0;
	
	public static final EntityEntry TERRA_BLADE_BEAM = EntityEntryBuilder.create()
			.entity(EntityTerraBladeBeam.class)
			.id(new ResourceLocation(Reference.MOD_ID, "terra_blade_beam"), id++)
			.name("terra_blade_beam")
			.tracker(128, 1, true)
			.build();
}
