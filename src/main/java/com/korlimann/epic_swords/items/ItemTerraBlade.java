package com.korlimann.epic_swords.items;

import com.korlimann.epic_swords.Main;
import com.korlimann.epic_swords.entity.projectile.EntityTerraBladeProjectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class ItemTerraBlade extends ItemSword {
	
	public ItemTerraBlade(String name, ToolMaterial material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.epic_swords);
	}		
	
	@Override
	public boolean onEntitySwing(EntityLivingBase entity, ItemStack stack) {
		if(!(entity instanceof EntityPlayer)) {
			return true;
		}
		EntityPlayer player = (EntityPlayer) entity;
		World world = player.getEntityWorld();
		if(!world.isRemote) {
			EntityTerraBladeProjectile projectile = new EntityTerraBladeProjectile(world, player, 1, 1, 1);
			world.spawnEntity(projectile);
		}
		return true;
	}
}
