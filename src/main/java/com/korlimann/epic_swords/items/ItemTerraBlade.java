package com.korlimann.epic_swords.items;

import com.korlimann.epic_swords.Main;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemTerraBlade extends ItemSword {
	
	public ItemTerraBlade(String name, ToolMaterial material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.epic_swords);
	}		
	
	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
		//world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		//BlockPos pos1 = new BlockPos(player.posX, player.posY, player.posZ);
		//world.playSoun(player, pos1, soundIn, category, volume, pitch);
		// IMPORTANT! Only spawn new entities on the server. If the world is not remote,
		// that means you are on the server:
		return true;
	}
}
