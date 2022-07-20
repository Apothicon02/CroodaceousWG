package com.anar4732.croodaceous;

import com.anar4732.croodaceous.registry.CEBlocks;
import com.anar4732.croodaceous.registry.CEEntities;
import com.anar4732.croodaceous.registry.CEItems;
import com.anar4732.croodaceous.registry.CEPointOfInterestTypes;
import com.mojang.logging.LogUtils;
import net.minecraft.SharedConstants;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.slf4j.Logger;

@Mod(CroodaceousMod.ID)
public class CroodaceousMod {
	public static final String ID = "croodaceous";
	private static final Logger LOGGER = LogUtils.getLogger();

	public CroodaceousMod() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		IEventBus forgeBus = MinecraftForge.EVENT_BUS;

		bus.addListener(this::setup);
		bus.addListener(this::clientSetup);
		bus.addListener(CEEntities::registerAttributes);
		bus.addListener(CEEntities::registerRenderers);

		forgeBus.addListener(this::addSpawns);

		CEEntities.ENTITIES.register(bus);
		CEItems.ITEMS.register(bus);
		CEBlocks.BLOCKS.register(bus);
		CEPointOfInterestTypes.POIS.register(bus);
		
//		MinecraftForge.EVENT_BUS.register(this);
	}
	
	/**
	 * Set a breakpoint {@link net.minecraft.Util#doPause(String) here} to debug any crash in the IDE
	 */
	private void setup(final FMLCommonSetupEvent event) {
		SharedConstants.IS_RUNNING_IN_IDE = !FMLEnvironment.production;
	}

	private void addSpawns(final BiomeLoadingEvent event) {
		if (event.getCategory().equals(Biome.BiomeCategory.MESA)) {
			event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(CEEntities.ENTITY_LIYOTE.get(), 1, 3, 5));
		}
	}
	
	private void clientSetup(final FMLClientSetupEvent e) {
		ItemBlockRenderTypes.setRenderLayer(CEBlocks.RAMU_NEST.get(), RenderType.cutout());
	}
	
}