package coda.croodaceous.registry;

import coda.croodaceous.common.entities.FangFly;
import coda.croodaceous.common.entities.Jackrobat;
import coda.croodaceous.common.entities.Ramu;
import coda.croodaceous.CroodaceousMod;
import coda.croodaceous.common.entities.Bearowl;
import coda.croodaceous.common.entities.Liyote;
import coda.croodaceous.common.entities.TripGerbil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CEEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CroodaceousMod.MOD_ID);

    public static void registerAttributes(final EntityAttributeCreationEvent e) {
        e.put(CEEntities.LIYOTE.get(), Liyote.createAttributes().build());
        e.put(CEEntities.BEAROWL.get(), Bearowl.createAttributes().build());
        e.put(CEEntities.RAMU.get(), Ramu.createAttributes().build());
        e.put(CEEntities.FANG_FLY.get(), FangFly.createAttributes().build());
        e.put(CEEntities.JACKROBAT.get(), Jackrobat.createAttributes().build());
        e.put(CEEntities.TRIP_GERBIL.get(), TripGerbil.createAttributes().build());
    }

    public static void registerSpawnPlacements(final SpawnPlacementRegisterEvent event) {
        event.register(CEEntities.LIYOTE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Liyote::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(CEEntities.FANG_FLY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, FangFly::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(CEEntities.RAMU.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Ramu::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(CEEntities.JACKROBAT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Jackrobat::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(CEEntities.TRIP_GERBIL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TripGerbil::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }

    public static final RegistryObject<EntityType<Liyote>> LIYOTE = ENTITIES.register("liyote", () -> EntityType.Builder.of(Liyote::new, MobCategory.CREATURE).sized(0.75F, 0.6F).setTrackingRange(16).updateInterval(1).build("liyote"));
    public static final RegistryObject<EntityType<Bearowl>> BEAROWL = ENTITIES.register("bearowl", () -> EntityType.Builder.of(Bearowl::new, MobCategory.CREATURE).sized(2.5F, 2.5F).setTrackingRange(16).updateInterval(1).build("bearowl"));
    public static final RegistryObject<EntityType<Ramu>> RAMU = ENTITIES.register("ramu", () -> EntityType.Builder.of(Ramu::new, MobCategory.CREATURE).sized(1F, 2F).setTrackingRange(16).updateInterval(1).build("ramu"));
    public static final RegistryObject<EntityType<FangFly>> FANG_FLY = ENTITIES.register("fang_fly", () -> EntityType.Builder.of(FangFly::new, MobCategory.CREATURE).sized(0.5F, 0.5F).setTrackingRange(16).updateInterval(1).build("fang_fly"));
    public static final RegistryObject<EntityType<Jackrobat>> JACKROBAT = ENTITIES.register("jackrobat", () -> EntityType.Builder.of(Jackrobat::new, MobCategory.CREATURE).sized(0.5F, 0.5F).setTrackingRange(16).updateInterval(1).build("jackrobat"));
    public static final RegistryObject<EntityType<TripGerbil>> TRIP_GERBIL = ENTITIES.register("trip_gerbil", () -> EntityType.Builder.of(TripGerbil::new, MobCategory.CREATURE).sized(0.5F, 0.5F).setTrackingRange(16).updateInterval(1).build("trip_gerbil"));

}