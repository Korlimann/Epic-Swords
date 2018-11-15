package com.korlimann.epic_swords.util.handlers;

import java.util.HashSet;
import java.util.Set;

import com.korlimann.epic_swords.Main;
//import com.korlimann.epic_swords.gen.KFCWorldGen;
import com.korlimann.epic_swords.init.ModBlocks;
import com.korlimann.epic_swords.init.ModItems;
import com.korlimann.epic_swords.util.ConsoleLogger;
import com.korlimann.epic_swords.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class ObjectRegistry {
	
	/*
	 * In this class, all our blocks and items get registered (models/textures/names load) so they'll show up ingame
	 * */
	
	public static Set<Item> items = new HashSet<Item>();
	public static Set<Block> blocks = new HashSet<Block>();
	
	public static void prepareBlocks(){
		
	}
	
	public static void prepareItems() {
		items.add(ModItems.TERRA_BLADE);
	}
	
	//This method will be called without us calling it. This is because 
	//Forge calls it -for- us, when the RegistryEvent happens. This is why
	//we had to use the @Mod.EventBusSubscriber at the top of the class.
	@SubscribeEvent
	public static void registerBlocks(Register<Block> event){
		
		//We make sure that the list gets filled with our blocks.
		prepareBlocks();
		int x = blocks.size();
		for(Block block : blocks){
			event.getRegistry().register(block);
		}
		ConsoleLogger.info("Blocks Registered");
		//TileEntityHandler.registerTileEntity();
		//ConsoleLogger.info("TileEntities Registered");
	}
	
	//We do not need to call prepareBlocks() in this method, because Blocks are registered before items.
	//Thus, our registerBlocks method has already happened.
	@SubscribeEvent
	public static void registerItems(Register<Item> event){
		
		for(Block block : blocks){
			ItemBlock iblock = new ItemBlock(block);
			iblock.setRegistryName(block.getRegistryName());
			event.getRegistry().register(iblock);
		}		
		ConsoleLogger.info("ItemBlocks Registered");
		prepareItems();
		
		for(Item item : items) {
			event.getRegistry().register(item);
		}
		ConsoleLogger.info("Items Registered");
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {		
		for(Block block : blocks) {
			if(block instanceof IHasModel) {
				((IHasModel)block).registerModels();
			}
		}
		ConsoleLogger.info("Block Models loaded");
		for(Item item : items) {
			if(item instanceof IHasModel) {
				((IHasModel)item).registerModels();
			}
		}
		ConsoleLogger.info("Item Models loaded");
	}
	
	public static void Common() {
		//GameRegistry.registerWorldGenerator(new KFCWorldGen(), 0);
	}

	public static void initRegistry() {
		//NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
		//ConsoleLogger.info("GuiHandler Registered");
	}
}